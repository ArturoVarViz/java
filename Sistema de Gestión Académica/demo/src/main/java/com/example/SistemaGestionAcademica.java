package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SistemaGestionAcademica {
    private JFrame frame;
    private Connection connection;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SistemaGestionAcademica window = new SistemaGestionAcademica();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SistemaGestionAcademica() {
        initialize();
        try {
            conexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        JPanel panelAlumnos = createPanel("Alumno");
        tabbedPane.addTab("Alumnos", null, panelAlumnos, null);

        JPanel panelProfesores = createPanel("Profesor");
        tabbedPane.addTab("Profesores", null, panelProfesores, null);

        JPanel panelCursos = createPanel("Curso");
        tabbedPane.addTab("Cursos", null, panelCursos, null);

        JPanel panelAsignaturas = createPanel("Asignatura");
        tabbedPane.addTab("Asignaturas", null, panelAsignaturas, null);
    }

    private void conexion() throws SQLException {
        String driver = "jdbc:postgresql:";
        String host = "//localhost:";
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host + porto + "/" + sid;
        connection = DriverManager.getConnection(url, usuario, password);
    }

    private JPanel createPanel(String tipo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear botones
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Añadir");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí necesitarás implementar la lógica para añadir un registro a tu base de datos
                JOptionPane.showInputDialog(frame, "Añadir " + tipo);
            }
        });
        buttonPanel.add(addButton);

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí necesitarás implementar la lógica para eliminar un registro de tu base de datos
                JOptionPane.showInputDialog(frame, "Eliminar " + tipo);
            }
        });
        buttonPanel.add(deleteButton);

        JButton searchButton = new JButton("Buscar");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí necesitarás implementar la lógica para buscar un registro en tu base de datos
                JOptionPane.showInputDialog(frame, "Buscar " + tipo);
            }
        });
        buttonPanel.add(searchButton);

        JButton showButton = new JButton("Mostrar " + tipo);
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "SELECT * FROM " + tipo;
                    PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet result = statement.executeQuery();

                    while (result.next()) {
                        int id = result.getInt("idAl");
                        String nombre = result.getString("nombre");
                        // Continúa para el resto de las columnas...

                        System.out.println("ID: " + id + ", Nombre: " + nombre);
                    }

                    // Cerrar ResultSet y PreparedStatement
                    result.close();
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println("Error al obtener los datos: " + ex.getMessage());
                }
            }
        });
        buttonPanel.add(showButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }
}
