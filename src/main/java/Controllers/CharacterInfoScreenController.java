package Controllers;

import Model.Character;
import Model.Items.Inventory;
import Model.Items.InventoryItem;
import Model.Items.InventoryItemBuilder;
import Model.ProficiencySkills;
import Model.StatName;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class CharacterInfoScreenController implements Initializable {

    @FXML private Button receiveDataButton;

    @FXML private CheckBox athleticsCheck;
    @FXML private CheckBox acrobaticsCheck;
    @FXML private CheckBox sleightCheck;
    @FXML private CheckBox stealthCheck;
    @FXML private CheckBox arcanaCheck;
    @FXML private CheckBox historyCheck;
    @FXML private CheckBox investigationCheck;
    @FXML private CheckBox natureCheck;
    @FXML private CheckBox religionCheck;
    @FXML private CheckBox animalCheck;
    @FXML private CheckBox insightCheck;
    @FXML private CheckBox medicineCheck;
    @FXML private CheckBox perceptionCheck;
    @FXML private CheckBox survivalCheck;
    @FXML private CheckBox deceptionCheck;
    @FXML private CheckBox intimidationCheck;
    @FXML private CheckBox performanceCheck;
    @FXML private CheckBox persuasionCheck;

    @FXML private TextField strengthText;
    @FXML private TextField dexText;
    @FXML private TextField conText;
    @FXML private TextField wisText;
    @FXML private TextField intText;
    @FXML private TextField chaText;


    @FXML private CheckBox g;
    @FXML private CheckBox f;
    @FXML private CheckBox h;
    @FXML private CheckBox d;


    //Basics tab fx:ids

    @FXML private Text strengthModifierText;
    @FXML private Text dexterityModifierText;
    @FXML private Text constitutionModifierText;
    @FXML private Text wisdomModifierText;
    @FXML private Text intelligenceModifierText;
    @FXML private Text charismaModifierText;


    @FXML private Text athleticsSkillLevelText;
    @FXML private Text acrobaticsSkillLevelText;
    @FXML private Text sleightOfHandSkillLevelText;
    @FXML private Text stealthSkillLevelText;
    @FXML private Text arcanaSkillLevelText;
    @FXML private Text historySkillLevelText;
    @FXML private Text investigationSkillLevelText;
    @FXML private Text natureSkillLevelText;
    @FXML private Text religionSkillLevelText;
    @FXML private Text animalHandlingSkillLevelText;
    @FXML private Text insightSkillLevelText;
    @FXML private Text medicineSkillLevelText;
    @FXML private Text perceptionSkillLevelText;
    @FXML private Text survivalSkillLevelText;
    @FXML private Text deceptionSkillLevelText;
    @FXML private Text intimidationSkillLevelText;
    @FXML private Text performanceSkillLevelText;
    @FXML private Text persuasionSkillLevelText;

    @FXML private TextArea spellsTextArea;
    @FXML private TextArea languagesTextArea;


    @FXML Label characterNameLabel;
    @FXML Label characterRaceLabel;
    @FXML Label characterClassLabel;
    @FXML Label characterLevelLabel;


    @FXML TextField nameTextField;
    @FXML TextField raceTextField;
    @FXML TextField jobTextField;

    // Combat fx:ids

    @FXML private Text strengthCombatPtsText;
    @FXML private Text dexterityCombatPtsText;
    @FXML private Text constitutionCombatPtsText;
    @FXML private Text wisdomCombatPtsText;
    @FXML private Text intelligenceCombatPtsText;
    @FXML private Text charismaCombatPtsText;

    @FXML private Text strengthCombatModifierText;
    @FXML private Text dexterityCombatModifierText;
    @FXML private Text constitutionCombatModifierText;
    @FXML private Text wisdomCombatModifierText;
    @FXML private Text intelligenceCombatModifierText;
    @FXML private Text charismaCombatModifierText;

    @FXML private Text acText;
    @FXML private Text initiativeText;
    @FXML private Text movementSpeedText;
    @FXML private Text HitpointsText;

    @FXML private TextArea featuresTextArea;
    @FXML private TextArea proficienciesTextArea;
    @FXML private TextArea spellTextArea;

    @FXML private Text HitPointsText;

    @FXML private FlowPane spellsFlowPane;

    List<List<String>> spellList;
    // Character character;



    // Spells fx:ids

    @FXML private Button level1SpellsButton;
    @FXML private Button level2SpellsButton;
    @FXML private Button level3SpellsButton;
    @FXML private Button level4SpellsButton;
    @FXML private Button level5SpellsButton;
    @FXML private Button level6SpellsButton;
    @FXML private Button level7SpellsButton;
    @FXML private Button level8SpellsButton;
    @FXML private Button level9SpellsButton;


    // Lore & Notes fx:ids

    @FXML private TextArea earlierLifeTextArea;
    @FXML private TextArea organizationTextArea;
    @FXML private TextArea coreMemoriesTextArea;
    @FXML private TextArea notesTextArea;

    @FXML private Button loreAndNotesSaveButton;

    // Inventory fx:ids

    @FXML private RadioButton equippableRadioButton;
    @FXML private RadioButton consumableRadioButton;
    @FXML private RadioButton miscellaneousRadioButton;

    @FXML private CheckBox acCheckBox;
    @FXML private CheckBox atkBonusCheckBox;
    @FXML private CheckBox isMagicalCheckBox;

    @FXML private FlowPane inventoryFlowPane;
    @FXML private TextField currentGoldTextField;

    //listItem fx-ids
    @FXML private TextField itemNameTextField;
    @FXML private TextField itemValueTextField;
    @FXML private TextArea itemCreationDescriptionTextArea;


    @FXML private Button createItemButton;
    @FXML private Button clearItemCreationButton;


    @FXML private Text itemNameText;
    @FXML private Text itemTypeText;
    @FXML private Text itemMagicalText;
    @FXML private Text itemAttackBonusText;
    @FXML private Text itemACText;
    @FXML private Text itemValueText;

    @FXML private TextArea itemDescriptionTextArea;

    @FXML private Button itemSellButton;
    @FXML private Button itemRemoveButton;
    @FXML private Button itemConsumeButton;

    /**
     * Initializes the controller class for the CharacterInfoScreen.fxml.
     * A necessary method for the FXML to work, since it is needed for the initializeable interface.
     * Prepares the components that need initialization, such as textareas and radiobuttons.
     * The parameters are not used in the method calls but are necessary to implement the initializeable interface.
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        System.out.println("here");

        setActionsTextArea();
        setReactionsTextArea();
        setBonusActionsTextArea();
        prepareRadioButtons();
        prepareCheckBoxes(new ArrayList<ProficiencySkills>(List.of(ProficiencySkills.Acrobatics)));
        // prepareStats(character.getStats());
        prepareModifiers();
        // prepareName(character.getName());
        // prepareRace(character.getRaceName());
        // prepareJob(character.getJobName());
        // prepareSpells();
        prepareReceiveDataButton();
    }

    private void prepareReceiveDataButton() {
        receiveDataButton.setOnMouseClicked(event -> receiveData(event));
    }



    // Basics features

    // Combat features

    /**
     * Sets the actions to be displayed in the text area.
     * Could be used to set the actions specific to the character, but is currently set to a generalized text that work for all characters.
     */
    private void setActionsTextArea() {
        String actions = """
                - Attack
                - Dash
                - Disengage
                - Dodge
                - Help
                - Hide
                - Search
                - Use an Object
                - Grapple
                - Shove
                - Cast a Spell
                - Ready An Action
                - Use a Class Feature""";

        featuresTextArea.setEditable(false);
        featuresTextArea.setText(actions);
    }

    /*Sets the reactions to be displayed in the text area. Could be used to set the reactions specific to the character,
    but is currently set to a generalized text that work for all characters. */

    private void setReactionsTextArea() {
        String reactions = """
                - Opportunity Attack
                - Perform a readied action
                - Cast a spell
                """;

        proficienciesTextArea.setEditable(false);
        proficienciesTextArea.setText(reactions);
    }

    /* Sets the bonus actions to be displayed in the text area. Could be used to set the bonus actions specific to the
     * character, but is currently set to a generalized text that work for all characters. */
    private void setBonusActionsTextArea() {
        String bonusActions = """
                - Offhand Attack
                - Cast a spell
                - Use a Class Feature
                """;

        spellTextArea.setEditable(false);
        spellTextArea.setText(bonusActions);
    }

    /*private void prepareSpells() {
        List<List<String>> sortedSpellList = new ArrayList<>();
        List<List<String>> level1spells = new ArrayList<>();
        for (List<String> spell : spellList) {
            String spellJobb = spell.get(0);
            if (Objects.equals(spellJobb, character.getJob().getJobName())) {
                sortedSpellList.add(spell);
            }
        }

        for (List<String> spell : sortedSpellList) {
            String spellLevel = spell.get(1);
            if (Objects.equals(spellLevel, "1")) {
                level1spells.add(spell);
            }
        }

        for (List<String> spell : level1spells) {
            String spellName = spell.get(2);
            String spellDescription = spell.get(3);
            spellsFlowPane.getChildren().add(new Label(spellName + "\n" + spellDescription));

        }
    }*/

    private void prepareName(String string){
        nameTextField.setText(string);
    }

    private void prepareRace(String string){
        raceTextField.setText(string);
    }

    private void prepareJob(String string){
        jobTextField.setText(string);
    }

    private void prepareStats(HashMap<StatName, Integer> stats){
        strengthText.setText(stats.get(StatName.Strength).toString());
        conText.setText(stats.get(StatName.Constitution).toString());
        wisText.setText(stats.get(StatName.Wisdom).toString());
        chaText.setText(stats.get(StatName.Charisma).toString());
        intText.setText(stats.get(StatName.Intelligence).toString());
        dexText.setText(stats.get(StatName.Dexterity).toString());
    }

    private void prepareModifiers(){
        strengthModifierText.setText("5");
        intelligenceModifierText.setText("5");
        wisdomModifierText.setText("5");
        constitutionModifierText.setText("5");
        charismaModifierText.setText("5");
        dexterityModifierText.setText("5");
    }

    private void prepareSpell(Map<String, String> map) {
        String name = map.get("name");
        String level = map.get("level");
        String description = map.get("description");
        String jobb = map.get("class");
        List<String> spell = Arrays.asList(jobb, level, name, description);
        spellList.add(spell);
    }

    private void prepareCheckBoxes(ArrayList<ProficiencySkills> proflist){

        if(proflist.contains(ProficiencySkills.Athletics)){
            athleticsCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Deception)) {
            deceptionCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Intimidation)) {
            intimidationCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Performance)) {
            performanceCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Persuasion)) {
            persuasionCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.AnimalHandling)) {
            animalCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Insight)) {
            insightCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Medicine)) {
            medicineCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Perception)) {
            perceptionCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Survival)) {
            survivalCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Arcana)) {
            arcanaCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.History)) {
            historyCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Investigation)) {
            investigationCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Nature)) {
            natureCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Religion)) {
            religionCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Acrobatics)) {
            acrobaticsCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.SleightOfHand)) {
            sleightCheck.setSelected(true);
        }
        if(proflist.contains(ProficiencySkills.Stealth)) {
            stealthCheck.setSelected(true);
        }
    }
    @FXML /* Disables the AC and Attack Bonus option when a Consumable item type is selected, as they cannot have either
    of those traits. */
    private void disablecheckboxes(Boolean bool) {

        acCheckBox.setDisable(bool);
        atkBonusCheckBox.setDisable(bool);
    }

    /* Prepares the radio buttons for the inventory. Calls on function that disables the AC and Attack Bonus checkboxes
    for consumable items. */
    private void prepareRadioButtons(){
        ToggleGroup itemToggleGroup = new ToggleGroup();
        consumableRadioButton.setToggleGroup(itemToggleGroup);
        equippableRadioButton.setToggleGroup(itemToggleGroup);
        miscellaneousRadioButton.setToggleGroup(itemToggleGroup);
        itemToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (itemToggleGroup.getSelectedToggle() != null){
                RadioButton selected = (RadioButton) itemToggleGroup.getSelectedToggle();
                System.out.println(selected.getText());
                if (consumableRadioButton.isSelected()){
                    disablecheckboxes(true);
                    System.out.println("disable");
                }
                else {
                    disablecheckboxes(false);
                    System.out.println("enable");
                }


            }
        });
    }

    // Spells features

    // Lore & Notes features

    @FXML
    private void saveLoreAndNotesTab(){
        // Save the current state of the Lore & Notes tab
    }

    // Inventory features

    private void updateInventoryList() {
        //Inventory inventory = character.getInventory();
        Inventory inventory = new Inventory(1);
        InventoryItemBuilder builder = new InventoryItemBuilder("Armour", "Cheese-tplate", "Goes clink clonk", 2, 4.0, false);
        builder.ac(12);
        builder.isequipped(true);
        InventoryItem cheeseArmor = new InventoryItem(builder);
        inventory.addItem(cheeseArmor);
        inventoryFlowPane.getChildren().clear();
        List<InventoryItem> items = inventory.getInventory();
        for (InventoryItem item : items) {
            ItemsListItem rli = new ItemsListItem(item, this);
            inventoryFlowPane.getChildren().add(rli);
        }
    }



    private void receiveData(MouseEvent event) {
        // Step 1
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        // Step 2
        Character character = (Character) stage.getUserData();
        // Step 3
        String name = character.getName();
        String race = character.getRaceName();
        System.out.println(name);
        System.out.println(race);
    }
}
