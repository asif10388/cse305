package csc305.arrayshenanigans;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;

public class ArrayController
{
    @javafx.fxml.FXML
    private Label postProcessingResultLabel;
    @javafx.fxml.FXML
    private RadioButton forwardRadioBtn;
    @javafx.fxml.FXML
    private TextField valInputField;
    @javafx.fxml.FXML
    private ToggleGroup travelsalOrderToggleGroup;
    @javafx.fxml.FXML
    private ToggleGroup arrayInstanceToggleGroup;
    @javafx.fxml.FXML
    private Label selectionTraversalResult;
    @javafx.fxml.FXML
    private ComboBox<String> oddEvenCombobox;
    @javafx.fxml.FXML
    private RadioButton backwardRadioBtn;

    private ArrayList<Integer> valList;

    private MyArray arr1;
    private MyArray arr2;
    private MyArray arr3;
    @javafx.fxml.FXML
    private RadioButton arr1RadioBtn;
    @javafx.fxml.FXML
    private RadioButton arr2RadioBtn;
    @javafx.fxml.FXML
    private RadioButton arr3RadioBtn;

    @javafx.fxml.FXML
    public void initialize() {
        valList = new ArrayList<Integer>();

        arr1 = new MyArray();
        arr2 = new MyArray();
        arr3 = new MyArray();

        oddEvenCombobox.getItems().addAll("Odd", "Even");
    }

    @javafx.fxml.FXML
    public void onCreateMyArryInstanceArr2ButtonClick(ActionEvent actionEvent) {
        ArrayList<Integer> valListToAppend = new ArrayList<>(valList);
        arr2.setVals(valListToAppend);
        valList.clear();

        System.out.println(arr1.getVals());
        System.out.println(arr2.getVals());
    }

    @javafx.fxml.FXML
    public void onTraverseSelectionButtonClick(ActionEvent actionEvent) {
        String oddEvenComboboxValue = oddEvenCombobox.getValue();
        boolean isForwardBtnSelected = forwardRadioBtn.isSelected();
        boolean isBackwardBtnSelected = backwardRadioBtn.isSelected();

        boolean isArr1Selected = arr1RadioBtn.isSelected();
        boolean isArr2Selected = arr2RadioBtn.isSelected();
        boolean isArr3Selected = arr3RadioBtn.isSelected();

        if(isArr1Selected) {
            ArrayList<Integer> resultArrayList = new ArrayList<>();

            if(isForwardBtnSelected) {
                if(oddEvenComboboxValue.equals("Odd")) {
                    for(int i = 0; i < arr1.getVals().size(); i++) {
                        if(arr1.getVals().get(i) % 2 != 0) {
                            resultArrayList.add(arr1.getVals().get(i));
                        }
                    }

                    selectionTraversalResult.setText("Odd numbers of arr1 in Forward are " + resultArrayList.toString());
                }else{
                    for(int i = 0; i < arr1.getVals().size(); i++) {
                        if(arr1.getVals().get(i) % 2 == 0) {
                            resultArrayList.add(arr1.getVals().get(i));
                        }
                    }

                    selectionTraversalResult.setText("Odd numbers of arr1 in Forward are " + resultArrayList.toString());
                }
            }

            if(isBackwardBtnSelected) {
                if(oddEvenComboboxValue.equals("Odd")) {
                    for(int i = arr1.getVals().size() - 1; i >= 0; i--) {
                        if(arr1.getVals().get(i) % 2 != 0) {
                            resultArrayList.add(arr1.getVals().get(i));
                        }
                    }

                    selectionTraversalResult.setText("Odd numbers of arr1 in Forward are " + resultArrayList.toString());
                }else{
                    for(int i = arr1.getVals().size() - 1; i >= 0; i--) {
                        if(arr1.getVals().get(i) % 2 == 0) {
                            resultArrayList.add(arr1.getVals().get(i));
                        }
                    }

                    selectionTraversalResult.setText("Odd numbers of arr1 in Forward are " + resultArrayList.toString());
                }
            }
        }

        if(isArr2Selected) {
            ArrayList<Integer> resultArrayList = new ArrayList<>();

            if(isForwardBtnSelected) {
                if(oddEvenComboboxValue.equals("Odd")) {
                    for(int i = 0; i < arr2.getVals().size(); i++) {
                        if(arr2.getVals().get(i) % 2 != 0) {
                            resultArrayList.add(arr2.getVals().get(i));
                        }
                    }

                    selectionTraversalResult.setText("Odd numbers of arr1 in Forward are " + resultArrayList.toString());
                }else{
                    for(int i = 0; i < arr2.getVals().size(); i++) {
                        if(arr2.getVals().get(i) % 2 == 0) {
                            resultArrayList.add(arr2.getVals().get(i));
                        }
                    }

                    selectionTraversalResult.setText("Odd numbers of arr1 in Forward are " + resultArrayList.toString());
                }
            }

            if(isBackwardBtnSelected) {
                if(oddEvenComboboxValue.equals("Odd")) {
                    for(int i = arr2.getVals().size() - 1; i >= 0; i--) {
                        if(arr2.getVals().get(i) % 2 != 0) {
                            resultArrayList.add(arr2.getVals().get(i));
                        }
                    }

                    selectionTraversalResult.setText("Odd numbers of arr1 in Forward are " + resultArrayList.toString());
                }else{
                    for(int i = arr2.getVals().size() - 1; i >= 0; i--) {
                        if(arr2.getVals().get(i) % 2 == 0) {
                            resultArrayList.add(arr2.getVals().get(i));
                        }
                    }

                    selectionTraversalResult.setText("Odd numbers of arr1 in Forward are " + resultArrayList.toString());
                }
            }
        }

        if(isArr3Selected) {
            ArrayList<Integer> resultArrayList = new ArrayList<>();

            if(isForwardBtnSelected) {
                if(oddEvenComboboxValue.equals("Odd")) {
                    for(int i = 0; i < arr3.getVals().size(); i++) {
                        if(arr3.getVals().get(i) % 2 != 0) {
                            resultArrayList.add(arr3.getVals().get(i));
                        }
                    }

                    selectionTraversalResult.setText("Odd numbers of arr1 in Forward are " + resultArrayList.toString());
                }else{
                    for(int i = 0; i < arr3.getVals().size(); i++) {
                        if(arr3.getVals().get(i) % 2 == 0) {
                            resultArrayList.add(arr3.getVals().get(i));
                        }
                    }

                    selectionTraversalResult.setText("Odd numbers of arr1 in Forward are " + resultArrayList.toString());
                }
            }

            if(isBackwardBtnSelected) {
                if(oddEvenComboboxValue.equals("Odd")) {
                    for(int i = arr3.getVals().size() - 1; i >= 0; i--) {
                        if(arr3.getVals().get(i) % 2 != 0) {
                            resultArrayList.add(arr3.getVals().get(i));
                        }
                    }

                    selectionTraversalResult.setText("Odd numbers of arr1 in Forward are " + resultArrayList.toString());
                }else{
                    for(int i = arr3.getVals().size() - 1; i >= 0; i--) {
                        if(arr3.getVals().get(i) % 2 == 0) {
                            resultArrayList.add(arr3.getVals().get(i));
                        }
                    }

                    selectionTraversalResult.setText("Odd numbers of arr1 in Forward are " + resultArrayList.toString());
                }
            }
        }

    }

    @javafx.fxml.FXML
    public void onCreateMyArryInstanceArr1ButtonClick(ActionEvent actionEvent) {
        ArrayList<Integer> valListToAppend = new ArrayList<>(valList);
        arr1.setVals(valListToAppend);
        valList.clear();

        System.out.println(arr1.getVals());
        System.out.println(arr2.getVals());
    }

    @javafx.fxml.FXML
    public void onMergeArr1Arr2ButtonClick(ActionEvent actionEvent) {
        ArrayList<Integer> mergedValList = new ArrayList<>(arr1.getVals());
        mergedValList.addAll(arr2.getVals());

        arr3.setVals(mergedValList);

        postProcessingResultLabel.setText(
                "Content of MyArrayInstance arr1: " + arr1.getVals().toString()
                + "\nSize of MyArrayInstance arr1: " + arr1.getVals().size()
                + "\nContent of MyArrayInstance arr2: " + arr2.getVals().toString()
                + "\nSize of MyArrayInstance arr2: " + arr2.getVals().size()
                + "\nContent of MyArrayInstance arr3: " + arr3.getVals().toString()
                + "\nSize of MyArrayInstance arr3: " + arr3.getVals().size()
        );
    }

    @javafx.fxml.FXML
    public void onAddElementToValListButtonClick(ActionEvent actionEvent) {
        Integer val = Integer.valueOf(valInputField.getText());
        valList.add(val);

//        Alert alert = new Alert((Alert.AlertType.INFORMATION));
//        alert.setTitle("Add Element");
//
//        alert.setHeaderText(null);
//        alert.setContentText(valList.toString());
//
//        alert.showAndWait();

        valInputField.clear();
    }
}