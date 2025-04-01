package com.company.product.utils.objects;

import com.company.product.utils.GeneralUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergerUtil {

    private static final ObjectMapper mapper = new ObjectMapper()
            //.setSerializationInclusion(JsonInclude.Include.NON_NULL)
            ;

    private MergerUtil(){
        GeneralUtil.notAllowInstantiation();
    }

    public static void merge(Object source, Object target) throws JsonProcessingException {

        JsonNode sourceNode = MergerUtil.mapper.valueToTree(source);
        JsonNode targetNode = MergerUtil.mapper.valueToTree(target);

        mergeNodes(sourceNode, targetNode);

        //MergerUtil.mapper.readerForUpdating(target).readValue(targetNode.toString());
        MergerUtil.mapper.updateValue(target, targetNode);
        //MergerUtil.mapper.updateValue(target, sourceNode);
    }

    private static void mergeNodes(JsonNode sourceNode, JsonNode targetNode) {
        if (sourceNode.isObject() && targetNode.isObject()) {
            ObjectNode targetObjectNode = (ObjectNode) targetNode;
            ObjectNode sourceObjectNode = (ObjectNode) sourceNode;

            sourceObjectNode.fieldNames().forEachRemaining(fieldName -> {
                JsonNode sourceFieldValue = sourceObjectNode.get(fieldName);
                JsonNode targetFieldValue = targetObjectNode.get(fieldName);

                if (sourceFieldValue.isObject()) {
                    if (targetFieldValue == null || targetFieldValue.isNull()) {
                        targetObjectNode.set(fieldName, sourceFieldValue);
                    } else {
                        mergeNodes(sourceFieldValue, targetFieldValue);
                    }
                } else if (!sourceFieldValue.isNull()) {
                    targetObjectNode.set(fieldName, sourceFieldValue);
                }
            });
        }
    }


}

