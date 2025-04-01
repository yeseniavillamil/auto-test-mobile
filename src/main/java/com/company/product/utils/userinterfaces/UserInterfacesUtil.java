package com.company.product.utils.userinterfaces;

import com.company.product.models.dtos.userinterfaces.UserInterfaceDTO;
import com.company.product.utils.javadoc.JavaDocUtil;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.Collection;

/**
 * Utility related to userinterfaces processing
 */
public class UserInterfacesUtil
{

    private static UserInterfacesUtil instance;
    private Config featuresUI;

    private static final String PATH_SEPARATOR = FileSystems.getDefault().getSeparator();
    private static final String PACKAGE_RESOURCES = "src"+PATH_SEPARATOR+"test"+PATH_SEPARATOR+"resources"+PATH_SEPARATOR;


    /**
     * For more information:
     * @see JavaDocUtil#CONSTRUCTOR
     */
    private UserInterfacesUtil(){

        Collection<File> files = FileUtils.listFiles(
                new File(PACKAGE_RESOURCES+"userinterfaces"),
                new String[]{"conf"},
                true
        );

        for(File file : files)
        {
            Config fileConf = ConfigFactory.parseResources(
                    file.getPath().replace(PACKAGE_RESOURCES, StringUtils.EMPTY)
            ).resolve();

            if(this.featuresUI == null){
                this.featuresUI = fileConf;
            }else{
                this.featuresUI = this.featuresUI.withFallback(fileConf);
            }
        }

        //this.featuresUI = ConfigFactory.parseResources("userinterfaces/features_ui.conf").resolve()
    }

    public static UserInterfacesUtil getInstance(){
        if(UserInterfacesUtil.instance == null){
            UserInterfacesUtil.instance = new UserInterfacesUtil();
        }

        return UserInterfacesUtil.instance;
    }

    public UserInterfaceDTO getUserInterface(String id){

        try{
            return UserInterfaceDTO.builder()
                    .id(id)
                    .name(this.featuresUI.getString(id+".name"))
                    .selector(this.featuresUI.getString(id+".selector"))
                    .build();
        }catch(Exception e){
            return null;
        }
    }


}
