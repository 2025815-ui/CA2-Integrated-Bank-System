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


// Class representing Bank Employee Hierarchy as a Binary Tree
// Uses level order insertion — fills left then right at each level
public class EmployeeHierarchy {

    // Node class — each node stores one employee record
    static class EmployeeNode {
        String name;
        String managerType;
        String department;
        EmployeeNode left, right;

        // Constructor — creates node with employee details
        EmployeeNode(String name, String managerType, String department) {
            this.name = name;
            this.managerType = managerType;
            this.department = department;
        }
    }

    // Root of tree — first employee inserted
    EmployeeNode root;

    // Insert using level order — fills left first then right
    // Uses queue to find next available position
    public void insert(String name, String managerType, String department) {

        // Create new node with employee details
        EmployeeNode newNode = new EmployeeNode(name, managerType, department);

        // If tree is empty new node becomes root
        if (root == null) {
            root = newNode;
            return;
        }

        // Use queue to find next available position
        // Level order — checks each node left to right top to bottom
        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            EmployeeNode temp = queue.poll();

            // Check left child first
            if (temp.left == null) {
                // Left is empty — insert here
                temp.left = newNode;
                return;
            } else {
                // Left is taken — add to queue to check later
                queue.add(temp.left);
            }

            // Check right child
            if (temp.right == null) {
                // Right is empty — insert here
                temp.right = newNode;
                return;
            } else {
                // Right is taken — add to queue to check later
                queue.add(temp.right);
            }
        }
    }

    // Level order traversal — displays tree level by level
    // Shows which level each employee is on
    public void levelOrder() {

        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }

        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;

        System.out.println("\n===== BANK EMPLOYEE HIERARCHY =====");

        while (!queue.isEmpty()) {

            // Count nodes at current level
            int levelSize = queue.size();

            System.out.println("\n--- Level " + level + " ---");

            // Print all nodes at this level
            for (int i = 0; i < levelSize; i++) {
                EmployeeNode temp = queue.poll();

                System.out.println("  " + (i + 1) + ". "
                        + "Name: " + temp.name
                        + " | Manager: " + temp.managerType
                        + " | Dept: " + temp.department);

                // Add children to queue for next level
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }

            level++;
        }

        System.out.println("\n====================================");
    }

    // Calculate height of tree recursively
    // Height = number of levels from root to deepest node
    public int height(EmployeeNode node) {
        if (node == null) return 0;
        return Math.max(
                height(node.left),
                height(node.right)
        ) + 1;
    }

    // Count total nodes in tree recursively
    public int countNodes(EmployeeNode node) {
        if (node == null) return 0;
        return 1
                + countNodes(node.left)
                + countNodes(node.right);
    }

    // Static method called from Main
    // Reads employees from list and builds tree
    public static void buildHierarchy(ArrayList<Employee> employees) {

        // Check minimum 20 employees as required by brief
        if (employees.size() < 20) {
            System.out.println("Need at least 20 employees!");
            System.out.println("Currently have: " + employees.size());
            System.out.println("Please load file or generate more employees.");
            return;
        }

        EmployeeHierarchy tree = new EmployeeHierarchy();

        // Insert first 20 employees into tree
        // Using level order insertion — left first then right
        System.out.println("\nInserting 20 employees into tree...");

        for (int i = 0; i < 20; i++) {
            Employee emp = employees.get(i);
            tree.insert(
                emp.getEmployeeName(),
                emp.getManager().getmanagerType(),
                emp.getDepartment().getDepartmentName()
            );
        }

        System.out.println("20 employees inserted successfully!");

        // Display tree using level order traversal
        tree.levelOrder();

        // Show tree height
        System.out.println("Tree Height: "
                + tree.height(tree.root));

        // Show total node count
        System.out.println("Total Nodes: "
                + tree.countNodes(tree.root));
    }
}