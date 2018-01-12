/**
 * Project Name:zjweb
 * File Name:IS_DELETE.java
 * Package Name:com.zjweb.enums
 * Date:2016年10月25日上午10:03:15
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.tsgl.enums;
/**
 * ClassName:IS_DELETE <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年10月25日 上午10:03:15 <br/>
 * @author   xm
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public enum IS_DELETE {
        delete(1,"已删除"),
        no_Delete(0,"未删除");
        private int value;
        private String description;
        private IS_DELETE(int value,String description){
            this.setValue(value);
            this.setDescription(description);
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
}
