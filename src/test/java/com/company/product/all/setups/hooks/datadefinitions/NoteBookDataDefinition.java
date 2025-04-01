package com.company.product.all.setups.hooks.datadefinitions;

import com.company.product.models.scena.NoteBook;
import com.company.product.models.scena.screenplay.Protagonist;
import com.company.product.utils.formats.FormatUtil;
import com.company.product.utils.objects.MapperUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class NoteBookDataDefinition {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @DataTableType()
    public NoteBook noteBook(DataTable table)throws Exception
    {
        for (Map<String, String> tblGherkinInput : table.entries())
        {
            Map<String, String> tblGherkin = new HashMap<>(tblGherkinInput);

            if(table.column(0).get(0).matches("[0-9A-Za-z_]+(\\.[0-9A-Za-z_]+)+"))
            {
                replaceFormat(tblGherkin);

                Map<String, Object> objectsMap = MapperUtil.convertToObjectsMap(tblGherkin);
                updateNoteBook(Protagonist.review().hisNotebook(),objectsMap);
            }
        }

        return Protagonist.review().hisNotebook();
    }

    private static void replaceFormat(Map<String, String> tblGherkin)
    {
        for (Map.Entry<String, String> entry : tblGherkin.entrySet())
        {
            FormatUtil.validateTblGherkin(tblGherkin,entry.getKey(),entry.getValue());
        }
        Protagonist.review().getTblGherkin().putAll(tblGherkin);
    }

    public void updateNoteBook(Object targetObject, Map<String, Object> updates) throws Exception {
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String jsonPropertyName = entry.getKey();
            Object value = entry.getValue();

            Field field = findFieldByJsonProperty(targetObject.getClass(), jsonPropertyName);
            if (field == null) {
                throw new NoSuchFieldException("No field found for JSON property: " + jsonPropertyName);
            }

            String fieldName = field.getName();
            Method getterMethod = findGetterMethod(targetObject.getClass(), fieldName);
            Object currentValue = getterMethod != null ? getterMethod.invoke(targetObject) : null;

            Method setterMethod = findSetterMethod(targetObject.getClass(), fieldName);
            if (setterMethod == null) {
                throw new NoSuchMethodException("No setter found for field: " + fieldName);
            }

            Class<?> paramType = setterMethod.getParameterTypes()[0];

            if (value instanceof Map) {
                if (currentValue == null) {
                    currentValue = paramType.getDeclaredConstructor().newInstance();
                }
                updateNoteBook(currentValue, (Map<String, Object>) value);
                setterMethod.invoke(targetObject, currentValue);
            } else {
                // Solo actualiza si el valor actual es null o si el nuevo valor no es null
                if (currentValue == null || value != null) {
                    Object convertedValue = objectMapper.convertValue(value, paramType);
                    setterMethod.invoke(targetObject, convertedValue);
                }
            }
        }
    }

    private Field findFieldByJsonProperty(Class<?> clazz, String jsonPropertyName) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonProperty.class)) {
                JsonProperty annotation = field.getAnnotation(JsonProperty.class);
                if (annotation.value().equals(jsonPropertyName)) {
                    return field;
                }
            }
        }
        return null;
    }

    private Method findSetterMethod(Class<?> clazz, String fieldName) {
        String setterName = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
        try {
            return clazz.getDeclaredMethod(setterName, clazz.getDeclaredField(fieldName).getType());
        } catch (NoSuchMethodException | NoSuchFieldException e) {
            return null;
        }
    }

    private Method findGetterMethod(Class<?> clazz, String fieldName) {
        String getterName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
        try {
            return clazz.getDeclaredMethod(getterName);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

}


