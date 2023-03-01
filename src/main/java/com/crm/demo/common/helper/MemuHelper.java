package com.crm.demo.common.helper;

import com.alibaba.fastjson.JSONObject;
import com.crm.demo.pojo.entity.SysRight;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 根据权限数据构建登录用户左侧菜单数据
 * </p>
 *
 * @author qy
 * @since 2019-11-11
 */
public class MemuHelper {

    /**
     * 构建菜单
     * @param treeNodes
     * @return
     */
    public static List<JSONObject> bulid(List<SysRight> treeNodes) {
        List<JSONObject> meuns = new ArrayList<>();
        if(treeNodes.size() == 1) {
            SysRight topNode = treeNodes.get(0);
            //左侧一级菜单
            List<SysRight> oneMeunList = topNode.getChildren();
            for(SysRight one :oneMeunList) {
                JSONObject oneMeun = new JSONObject();
                oneMeun.put("path", one.getRightUrl());
                oneMeun.put("component", one.getRightComponent());
                oneMeun.put("redirect", "noredirect");
                oneMeun.put("name", "name_"+one.getRightCode());
                oneMeun.put("hidden", false);

                JSONObject oneMeta = new JSONObject();
                oneMeta.put("title", one.getRightText());
//                oneMeta.put("icon", one.getIcon());
                oneMeun.put("meta", oneMeta);

                List<JSONObject> children = new ArrayList<>();
                List<SysRight> twoMeunList = one.getChildren();
                for(SysRight two :twoMeunList) {
                    JSONObject twoMeun = new JSONObject();
                    twoMeun.put("path", two.getRightUrl());
                    twoMeun.put("component", two.getRightComponent());
                    twoMeun.put("name", "name_"+two.getRightCode());
                    twoMeun.put("hidden", false);

                    JSONObject twoMeta = new JSONObject();
                    twoMeta.put("title", two.getRightText());
                    twoMeun.put("meta", twoMeta);

                    children.add(twoMeun);

                    List<SysRight> threeMeunList = two.getChildren();
                    for(SysRight three :threeMeunList) {
                        if(StringUtils.isEmpty(three.getRightUrl())) continue;

                        JSONObject threeMeun = new JSONObject();
                        threeMeun.put("path", three.getRightUrl());
                        threeMeun.put("component", three.getRightComponent());
                        threeMeun.put("name", "name_"+three.getRightCode());
                        threeMeun.put("hidden", true);

                        JSONObject threeMeta = new JSONObject();
                        threeMeta.put("title", three.getRightText());
                        threeMeun.put("meta", threeMeta);

                        children.add(threeMeun);
                    }
                }
                oneMeun.put("children", children);
                meuns.add(oneMeun);
            }
        }
        return meuns;
    }
}
