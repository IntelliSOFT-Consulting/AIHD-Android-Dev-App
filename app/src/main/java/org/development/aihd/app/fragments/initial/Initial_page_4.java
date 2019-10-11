package org.development.aihd.app.fragments.initial;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import org.development.aihd.app.common.DateCalendar;
import org.development.aihd.app.common.JSONFormBuilder;
import org.development.aihd.app.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Initial_page_4 extends Fragment {

    //Checkboxes
    private String stroke, heart, kidney, neuropahty, visual, ulcers, erectile, other, gastrology, cataracts, dental,
            dm_htm_education, nutrition, activity, selfcare, stress, nutrition_assessment, anthropometric, biochemical, diet_history, meal_planning, caloric_intake, nutrients;

    //RadioButtons
    private EditText editTextStroke, editTextHeart, editTextKidney, editTextNeuropahty, editTextVisual, editTextUlcers, editTextErectile, editTextGatrology, editTextCataracts, editTextDental, editTextOtherComplication,
            editTextStrokeDate, editTextHeartDate, editTextKidneyDate, editTextNeuropahtyDate, editTextVisualDate, editTextUlcersDate, editTextErectileDate,
            editTextGatrologyDate, editTextCataractsDate, editTextDentalDate, editTextOtherComplicationDate,
            editTextNutritionAssessment, editTextMealPlanning;

    private LinearLayout linearLayoutNutritionAssessment, linearLayoutMealPlanning;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_4, container, false);

        linearLayoutNutritionAssessment = view.findViewById(R.id.linearLayoutNutritionAssessment);
        linearLayoutMealPlanning = view.findViewById(R.id.linearLayoutMealPlanning);

        CheckBox checkBoxStroke = view.findViewById(R.id.checkbox_complication_stroke);
        CheckBox checkBoxHeart = view.findViewById(R.id.checkbox_complication_heart);
        CheckBox checkBoxKidney = view.findViewById(R.id.checkbox_complication_kidney);
        CheckBox checkBoxNeuropahty = view.findViewById(R.id.checkbox_complication_neuropathy);
        CheckBox checkBoxVisual = view.findViewById(R.id.checkbox_complication_visual);
        CheckBox checkBoxUlcers = view.findViewById(R.id.checkbox_complication_foot_ulcer);
        CheckBox checkBoxErectile = view.findViewById(R.id.checkbox_complication_erectile);
        CheckBox checkBoxGastrology = view.findViewById(R.id.checkbox_complication_gastropathy);
        CheckBox checkBoxCataracts = view.findViewById(R.id.checkbox_complication_cataracts);
        CheckBox checkBoxDental = view.findViewById(R.id.checkbox_complication_dental);
        CheckBox checkBoxOther = view.findViewById(R.id.checkbox_complication_other);

        CheckBox checkBoxNutrition = view.findViewById(R.id.checkbox_nutrition);
        CheckBox checkBoxActivity = view.findViewById(R.id.checkbox_physical_activity);
        CheckBox checkBoxDMHTN = view.findViewById(R.id.checkbox_dm_htn_education);
        CheckBox checkBoxSelfCare = view.findViewById(R.id.checkbox_selfcare);
        CheckBox checkBoxStress = view.findViewById(R.id.checkbox_stress);

        CheckBox checkBoxNutritionAssesment = view.findViewById(R.id.checkbox_nutrition_assessment);
        CheckBox checkBoxAnthropometric = view.findViewById(R.id.checkbox_anthropometric);
        CheckBox checkBoxBiochemical = view.findViewById(R.id.checkbox_biochemical);
        CheckBox checkBoxDietHistory = view.findViewById(R.id.checkbox_diet_history);

        CheckBox checkBoxMealPlanning = view.findViewById(R.id.checkbox_meal_planning);
        CheckBox checkBoxCaloricIntake = view.findViewById(R.id.checkbox_caloric_intake);
        CheckBox checkBoxNutrients = view.findViewById(R.id.checkbox_nutrients);

        checkBox(checkBoxStroke);
        checkBox(checkBoxHeart);
        checkBox(checkBoxKidney);
        checkBox(checkBoxNeuropahty);
        checkBox(checkBoxVisual);
        checkBox(checkBoxUlcers);
        checkBox(checkBoxErectile);
        checkBox(checkBoxGastrology);
        checkBox(checkBoxCataracts);
        checkBox(checkBoxDental);
        checkBox(checkBoxOther);

        checkBox(checkBoxNutrition);
        checkBox(checkBoxActivity);
        checkBox(checkBoxDMHTN);
        checkBox(checkBoxSelfCare);
        checkBox(checkBoxStress);
        checkBox(checkBoxNutritionAssesment);
        checkBox(checkBoxAnthropometric);
        checkBox(checkBoxBiochemical);
        checkBox(checkBoxDietHistory);
        checkBox(checkBoxMealPlanning);
        checkBox(checkBoxCaloricIntake);
        checkBox(checkBoxNutrients);

        editTextStroke = view.findViewById(R.id.diagnosis_comment_stroke);
        editTextHeart = view.findViewById(R.id.diagnosis_comment_heart_failure);
        editTextKidney = view.findViewById(R.id.diagnosis_comment_kidney_failure);
        editTextNeuropahty = view.findViewById(R.id.diagnosis_comment_neuropathy);
        editTextVisual = view.findViewById(R.id.diagnosis_comment_visual);
        editTextUlcers = view.findViewById(R.id.diagnosis_comment_foot_ulcer);
        editTextErectile = view.findViewById(R.id.diagnosis_comment_erectile);
        editTextGatrology = view.findViewById(R.id.diagnosis_comment_gastropathy);
        editTextCataracts = view.findViewById(R.id.diagnosis_comment_cataracts);
        editTextDental = view.findViewById(R.id.diagnosis_comment_dental);
        editTextOtherComplication = view.findViewById(R.id.diagnosis_comment_other);
        editTextNutritionAssessment = view.findViewById(R.id.comment_nutrition_assessment);
        editTextMealPlanning = view.findViewById(R.id.comment_meal_planning);

        editTextStrokeDate = view.findViewById(R.id.diagnosis_date_stroke);
        editTextHeartDate = view.findViewById(R.id.diagnosis_date_heart_failure);
        editTextKidneyDate = view.findViewById(R.id.diagnosis_date_kidney_failure);
        editTextNeuropahtyDate = view.findViewById(R.id.diagnosis_date_neuropathy);
        editTextVisualDate = view.findViewById(R.id.diagnosis_date_visual);
        editTextUlcersDate = view.findViewById(R.id.diagnosis_date_foot_ulcer);
        editTextErectileDate = view.findViewById(R.id.diagnosis_date_erectile);
        editTextGatrologyDate = view.findViewById(R.id.diagnosis_date_gastropathy);
        editTextCataractsDate = view.findViewById(R.id.diagnosis_date_cataracts);
        editTextDentalDate = view.findViewById(R.id.diagnosis_date_dental);
        editTextOtherComplicationDate = view.findViewById(R.id.diagnosis_date_other);

        DateCalendar.date(getActivity(), editTextStrokeDate);
        DateCalendar.date(getActivity(), editTextHeartDate);
        DateCalendar.date(getActivity(), editTextKidneyDate);
        DateCalendar.date(getActivity(), editTextNeuropahtyDate);
        DateCalendar.date(getActivity(), editTextVisualDate);
        DateCalendar.date(getActivity(), editTextUlcersDate);
        DateCalendar.date(getActivity(), editTextErectileDate);
        DateCalendar.date(getActivity(), editTextGatrologyDate);
        DateCalendar.date(getActivity(), editTextCataractsDate);
        DateCalendar.date(getActivity(), editTextDentalDate);
        DateCalendar.date(getActivity(), editTextOtherComplicationDate);

        textWatcher(editTextStroke);
        textWatcher(editTextHeart);
        textWatcher(editTextKidney);
        textWatcher(editTextNeuropahty);
        textWatcher(editTextVisual);
        textWatcher(editTextUlcers);
        textWatcher(editTextErectile);
        textWatcher(editTextGatrology);
        textWatcher(editTextCataracts);
        textWatcher(editTextDental);
        textWatcher(editTextOtherComplication);

        textWatcher(editTextStrokeDate);
        textWatcher(editTextHeartDate);
        textWatcher(editTextKidneyDate);
        textWatcher(editTextNeuropahtyDate);
        textWatcher(editTextVisualDate);
        textWatcher(editTextUlcersDate);
        textWatcher(editTextErectileDate);
        textWatcher(editTextGatrologyDate);
        textWatcher(editTextCataractsDate);
        textWatcher(editTextDentalDate);
        textWatcher(editTextNutritionAssessment);
        textWatcher(editTextMealPlanning);

        return view;
    }

    public void nutritionAssessment(String diagnosis) {
        if (diagnosis.matches("5484")) {
            linearLayoutNutritionAssessment.setVisibility(View.VISIBLE);
        } else {
            linearLayoutNutritionAssessment.setVisibility(View.GONE);
        }
    }

    public void mealPlanning(String diagnosis) {
        if (diagnosis.matches("165369")) {
            linearLayoutMealPlanning.setVisibility(View.VISIBLE);
        } else {
            linearLayoutMealPlanning.setVisibility(View.GONE);
        }
    }

    public void textWatcher(EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(final Editable editable) {
                updateValues();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });
    }


    public void checkBox(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                int value = checkBox.getId();

                //Check which checkbox was clicked
                switch (value) {
                    case R.id.checkbox_complication_stroke:
                        if (checked) {
                            stroke = "111103";
                        } else {
                            stroke = "";
                        }
                        break;
                    case R.id.checkbox_complication_heart:
                        if (checked) {
                            heart = "139069";
                        } else {
                            heart = "";
                        }
                        break;
                    case R.id.checkbox_complication_kidney:
                        if (checked) {
                            kidney = "113338";
                        } else {
                            kidney = "";
                        }
                        break;
                    case R.id.checkbox_complication_neuropathy:
                        if (checked) {
                            neuropahty = "118983";
                        } else {
                            neuropahty = "";
                        }
                        break;
                    case R.id.checkbox_complication_visual:
                        if (checked) {
                            visual = "159298";
                        } else {
                            visual = "";
                        }
                        break;
                    case R.id.checkbox_complication_foot_ulcer:
                        if (checked) {
                            ulcers = "163411";
                        } else {
                            ulcers = "";
                        }
                        break;
                    case R.id.checkbox_complication_erectile:
                        if (checked) {
                            erectile = "156162";
                        } else {
                            erectile = "";
                        }
                        break;
                    case R.id.checkbox_complication_gastropathy:
                        if (checked) {
                            gastrology = "145339";
                        } else {
                            gastrology = "";
                        }
                        break;
                    case R.id.checkbox_complication_cataracts:
                        if (checked) {
                            cataracts = "120860";
                        } else {
                            cataracts = "";
                        }
                        break;
                    case R.id.checkbox_complication_dental:
                        if (checked) {
                            dental = "165331";
                        } else {
                            dental = "";
                        }
                        break;
                    case R.id.checkbox_complication_other:
                        if (checked) {
                            other = "5622";
                        } else {
                            other = "";
                        }
                        break;
                    case R.id.checkbox_nutrition:
                        if (checked) {
                            nutrition = "1380";
                        } else {
                            nutrition = "";
                        }
                        break;
                    case R.id.checkbox_physical_activity:
                        if (checked) {
                            activity = "159364";
                        } else {
                            activity = "";
                        }
                        break;

                    case R.id.checkbox_dm_htn_education:
                        if (checked) {
                            dm_htm_education = "165364";
                        } else {
                            dm_htm_education = "";
                        }
                        break;
                    case R.id.checkbox_selfcare:
                        if (checked) {
                            selfcare = "165365";
                        } else {
                            selfcare = "";
                        }
                        break;
                    case R.id.checkbox_stress:
                        if (checked) {
                            stress = "165374";
                        } else {
                            stress = "";
                        }
                        break;
                    case R.id.checkbox_nutrition_assessment:
                        if (checked) {
                            nutrition_assessment = "5484";
                        } else {
                            nutrition_assessment = "";
                        }
                        nutritionAssessment(nutrition_assessment);
                        break;
                    case R.id.checkbox_anthropometric:
                        if (checked) {
                            anthropometric = "165366";
                        } else {
                            anthropometric = "";
                        }
                        break;
                    case R.id.checkbox_biochemical:
                        if (checked) {
                            biochemical = "165367";
                        } else {
                            biochemical = "";
                        }
                        break;
                    case R.id.checkbox_diet_history:
                        if (checked) {
                            diet_history = "165368";
                        } else {
                            diet_history = "";
                        }
                        break;
                    case R.id.checkbox_meal_planning:
                        if (checked) {
                            meal_planning = "165369";
                        } else {
                            meal_planning = "";
                        }
                        mealPlanning(meal_planning);
                        break;
                    case R.id.checkbox_caloric_intake:
                        if (checked) {
                            caloric_intake = "165370";
                        } else {
                            caloric_intake = "";
                        }
                        break;
                    case R.id.checkbox_nutrients:
                        if (checked) {
                            nutrients = "165371";
                        } else {
                            nutrients = "";
                        }
                        break;


                }

                updateValues();
            }
        });
    }


    public void updateValues() {

        JSONArray jsonArry = new JSONArray();
        JSONArray jsonObs = new JSONArray();
        JSONArray jsonArry1 = new JSONArray();
        JSONArray jsonArry2 = new JSONArray();
        JSONArray jsonArry3 = new JSONArray();
        JSONArray jsonArry4 = new JSONArray();
        JSONArray jsonArry5 = new JSONArray();
        JSONArray jsonArry6 = new JSONArray();
        JSONArray jsonArry7 = new JSONArray();
        JSONArray jsonArry8 = new JSONArray();
        JSONArray jsonArry9 = new JSONArray();
        JSONArray jsonArry10 = new JSONArray();
        JSONArray jsonArry11 = new JSONArray();

        jsonArry1.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", stroke, DateCalendar.date(), ""));
        jsonArry1.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextStrokeDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry1.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", "", DateCalendar.date(), editTextStroke.getText().toString().trim()));

        jsonArry2.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", heart, DateCalendar.date(), ""));
        jsonArry2.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextHeartDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry2.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", "", DateCalendar.date(), editTextHeart.getText().toString().trim()));

        jsonArry3.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", kidney, DateCalendar.date(), ""));
        jsonArry3.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextKidneyDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry3.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", "", DateCalendar.date(), editTextKidney.getText().toString().trim()));

        jsonArry4.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", neuropahty, DateCalendar.date(), ""));
        jsonArry4.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextNeuropahtyDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry4.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", "", DateCalendar.date(), editTextNeuropahty.getText().toString().trim()));

        jsonArry5.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", visual, DateCalendar.date(), ""));
        jsonArry5.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextVisualDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry5.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", "", DateCalendar.date(), editTextVisual.getText().toString().trim()));

        jsonArry6.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", ulcers, DateCalendar.date(), ""));
        jsonArry6.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextUlcersDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry6.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", "", DateCalendar.date(), editTextUlcers.getText().toString().trim()));

        jsonArry7.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", erectile, DateCalendar.date(), ""));
        jsonArry7.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextErectileDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry7.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", "", DateCalendar.date(), editTextErectile.getText().toString().trim()));

        jsonArry8.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", gastrology, DateCalendar.date(), ""));
        jsonArry8.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextGatrologyDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry8.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", "", DateCalendar.date(), editTextGatrology.getText().toString().trim()));

        jsonArry9.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", cataracts, DateCalendar.date(), ""));
        jsonArry9.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextCataractsDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry9.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", "", DateCalendar.date(), editTextCataracts.getText().toString().trim()));

        jsonArry10.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", dental, DateCalendar.date(), ""));
        jsonArry10.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextDentalDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry10.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", "", DateCalendar.date(), editTextDental.getText().toString().trim()));

        jsonArry11.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", other, DateCalendar.date(), ""));
        jsonArry11.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextOtherComplicationDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry11.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", "", DateCalendar.date(), editTextOtherComplication.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", dm_htm_education, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", nutrition, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", activity, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", selfcare, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", stress, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", anthropometric, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", biochemical, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", nutrition_assessment, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", diet_history, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", meal_planning, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", caloric_intake, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", nutrients, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165176", "", "valueText", editTextNutritionAssessment.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165176", "", "valueText", editTextMealPlanning.getText().toString().trim(), DateCalendar.date(), ""));


        try {
            jsonArry1 = JSONFormBuilder.concatArray(jsonArry1);
            jsonArry2 = JSONFormBuilder.concatArray(jsonArry2);
            jsonArry3 = JSONFormBuilder.concatArray(jsonArry3);
            jsonArry4 = JSONFormBuilder.concatArray(jsonArry4);
            jsonArry5 = JSONFormBuilder.concatArray(jsonArry5);
            jsonArry6 = JSONFormBuilder.concatArray(jsonArry6);
            jsonArry7 = JSONFormBuilder.concatArray(jsonArry7);
            jsonArry8 = JSONFormBuilder.concatArray(jsonArry8);
            jsonArry9 = JSONFormBuilder.concatArray(jsonArry9);
            jsonArry10 = JSONFormBuilder.concatArray(jsonArry10);
            jsonArry11 = JSONFormBuilder.concatArray(jsonArry11);

            jsonArry = JSONFormBuilder.concatArray(jsonArry);

            JSONFormBuilder.checkLength(jsonArry1, jsonObs);
            JSONFormBuilder.checkLength(jsonArry2, jsonObs);
            JSONFormBuilder.checkLength(jsonArry3, jsonObs);
            JSONFormBuilder.checkLength(jsonArry4, jsonObs);
            JSONFormBuilder.checkLength(jsonArry5, jsonObs);
            JSONFormBuilder.checkLength(jsonArry6, jsonObs);
            JSONFormBuilder.checkLength(jsonArry7, jsonObs);
            JSONFormBuilder.checkLength(jsonArry8, jsonObs);
            JSONFormBuilder.checkLength(jsonArry9, jsonObs);
            JSONFormBuilder.checkLength(jsonArry10, jsonObs);
            JSONFormBuilder.checkLength(jsonArry11, jsonObs);

            if (jsonObs.length() > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("groups", jsonObs);

                jsonArry.put(jsonObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("JSON Initial Page 4", jsonArry.toString() + "");

        FragmentModelInitial.getInstance().initialFour(jsonArry);
    }

}
