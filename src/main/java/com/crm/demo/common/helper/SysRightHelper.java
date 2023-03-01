package com.crm.demo.common.helper;

import com.crm.demo.pojo.entity.SysRight;

import java.util.ArrayList;
import java.util.List;

public class SysRightHelper {
    /**
     * 递归建菜单
     * @param treeNodes
     * @return
     */
    public static List<SysRight> bulid(List<SysRight> treeNodes) {
        List<SysRight> trees = new ArrayList<>();
        for (SysRight treeNode : treeNodes) {
            if ("ROOT_MENU".equals(treeNode.getRightParentCode())) {
                treeNode.setLevel(1);
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查询子节点
     * @param treeNode
     * @param treeNodes
     * @return
     */
    public static SysRight findChildren(SysRight treeNode, List<SysRight> treeNodes) {
        treeNode.setChildren(new ArrayList<SysRight>());

        for (SysRight it : treeNodes) {
            if (treeNode.getRightCode().equals(it.getRightParentCode())) {
                int level = treeNode.getLevel() + 1;
                it.setLevel(level);
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
}
