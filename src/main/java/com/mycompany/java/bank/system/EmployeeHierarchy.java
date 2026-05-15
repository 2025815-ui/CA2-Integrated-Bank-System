/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java.bank.system;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

/**
 *
 * @author yarzarmin
 */
public class EmployeeHierarchy {

    // Node class
    static class EmployeeNode {

        String name;
        String managerType;
        String department;

        EmployeeNode left, right;

        EmployeeNode(String name, String managerType, String department) {
            this.name = name;
            this.managerType = managerType;
            this.department = department;
        }
    }

    EmployeeNode root;

    // Insert using level-order
    public void insert(String name, String managerType, String department) {

        EmployeeNode newNode = new EmployeeNode(name, managerType, department);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            EmployeeNode temp = queue.poll();

            if (temp.left == null) {
                temp.left = newNode;
                return;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = newNode;
                return;
            } else {
                queue.add(temp.right);
            }
        }
    }

    // Level-order traversal
    public void levelOrder() {

        if (root == null) {
            return;
        }

        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("\nEmployee Hierarchy:");

        while (!queue.isEmpty()) {

            EmployeeNode temp = queue.poll();

            System.out.println(
                    temp.name + " | "
                    + temp.managerType + " | "
                    + temp.department
            );

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    // Height
    public int height(EmployeeNode node) {

        if (node == null) {
            return 0;
        }

        return Math.max(
                height(node.left),
                height(node.right)
        ) + 1;
    }

    // Count nodes
    public int countNodes(EmployeeNode node) {

        if (node == null) {
            return 0;
        }

        return 1
                + countNodes(node.left)
                + countNodes(node.right);
    }

    //STATIC METHOD for switch-case
    public static void buildHierarchy(ArrayList<Employee> employees) {

        EmployeeHierarchy hierarchy = new EmployeeHierarchy();

        // Insert all employees
        for (Employee emp : employees) {

            hierarchy.insert(
                    emp.getEmployeeName(),
                    emp.getManager().getmanagerType(),
                    emp.getDepartment().getDepartmentName()
            );
        }

        // Display hierarchy
        hierarchy.levelOrder();

        // Height
        System.out.println("\nTree Height: "
                + hierarchy.height(hierarchy.root));

        // Node count
        System.out.println("Total Nodes: "
                + hierarchy.countNodes(hierarchy.root));
    }
}
