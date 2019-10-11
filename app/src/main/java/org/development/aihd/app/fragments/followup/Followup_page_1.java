package org.development.aihd.app.fragments.followup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.development.aihd.app.R;
import org.development.aihd.app.common.DateCalendar;
import org.development.aihd.app.common.JSONFormBuilder;
import org.development.aihd.app.common.Alerts;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_1 extends Fragment {

    private View view;
    private EditText dm_followup_date, supporter_nameEditText, supporter_phoneEditText, supporter_phone_otherEditText;
    private EditText dmDiagnosisDateEditText, dmClinicDateEditText;
    private EditText htnDiagnosisDateEditText, htnClinicDateEditText;
    private EditText editTextTBDate, editTextTBComment;
    private String visit_type, dm_diagnosis, hypertension, nhif, diabetes_type, hypertension_type, tb_screen, tb_status, hiv_status;
    private RadioGroup radioGroupDiabetes, radioGroupHypertention;
    private String exercise, diet, smoking, drinking;
    private LinearLayout linearLayoutNutritionAssessment, linearLayoutMealPlanning;
    private String dm_htm_education, nutrition, activity, selfcare, stress, nutrition_assessment, anthropometric, biochemical, diet_history, meal_planning, caloric_intake, nutrients;
    private EditText editTextNutritionAssessment, editTextMealPlanning;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dm_followup_fragment_1, container, false);
        dm_diagnosis = hypertension = tb_status = nhif = "";

        linearLayoutNutritionAssessment = view.findViewById(R.id.linearLayoutNutritionAssessment);
        linearLayoutMealPlanning = view.findViewById(R.id.linearLayoutMealPlanning);

        dm_followup_date = view.findViewById(R.id.dm_followup_date);
        supporter_nameEditText = view.findViewById(R.id.supporter_name);
        supporter_phoneEditText = view.findViewById(R.id.supporter_telephone);
        supporter_phone_otherEditText = view.findViewById(R.id.supporter_telephone_other);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        dm_followup_date.setText(dateFormat.format(new Date())); // current date
        DateCalendar.fulldate(getActivity(), dm_followup_date);

        radioGroupDiabetes = view.findViewById(R.id.radioGroupDiabetes);
        radioGroupHypertention = view.findViewById(R.id.radioGroupHypertension);

        dmDiagnosisDateEditText = view.findViewById(R.id.dm_diagnosis_date);
        dmClinicDateEditText = view.findViewById(R.id.dm_clinic_date);

        htnDiagnosisDateEditText = view.findViewById(R.id.htn_diagnosis_date);
        htnClinicDateEditText = view.findViewById(R.id.htn_clinic_date);

        editTextTBDate = view.findViewById(R.id.tb_treatment_start);
        editTextTBComment = view.findViewById(R.id.tb_comment);

        editTextNutritionAssessment = view.findViewById(R.id.comment_nutrition_assessment);
        editTextMealPlanning = view.findViewById(R.id.comment_meal_planning);

        DateCalendar.date(getActivity(), dmDiagnosisDateEditText);
        DateCalendar.date(getActivity(), dmClinicDateEditText);
        DateCalendar.date(getActivity(), htnDiagnosisDateEditText);
        DateCalendar.date(getActivity(), htnClinicDateEditText);
        DateCalendar.date(getActivity(), editTextTBDate);

        textWatcher(dm_followup_date);
        textWatcher(supporter_nameEditText);
        textWatcher(supporter_phoneEditText);
        textWatcher(supporter_phone_otherEditText);
        textWatcher(dmDiagnosisDateEditText);
        textWatcher(dmClinicDateEditText);
        textWatcher(htnDiagnosisDateEditText);
        textWatcher(htnClinicDateEditText);
        textWatcher(editTextTBDate);
        textWatcher(editTextTBComment);
        textWatcher(editTextNutritionAssessment);
        textWatcher(editTextMealPlanning);

        RadioButton radioButtonSick = view.findViewById(R.id.radio_visit_sick);
        RadioButton radioButtonReferred = view.findViewById(R.id.radio_visit_referred);
        RadioButton radioButtonScheduled = view.findViewById(R.id.radio_visit_scheduled);
        RadioButton radioButtonUnscheduled = view.findViewById(R.id.radio_visit_unscheduled);
        RadioButton radioButtonDMNew = view.findViewById(R.id.radio_diabetes_new);
        RadioButton radioButtonDMKnown = view.findViewById(R.id.radio_diabetes_known);
        RadioButton radioButtonDMNA = view.findViewById(R.id.radio_diabetes_na);
        RadioButton radioButtonDMType1 = view.findViewById(R.id.radio_diabetes_type_1);
        RadioButton radioButtonDMType = view.findViewById(R.id.radio_diabetes_type_2);
        RadioButton radioButtonDMGDM = view.findViewById(R.id.radio_diabetes_GDM);
        RadioButton radioButtonDMSecondary = view.findViewById(R.id.radio_diabetes_secondary);
        RadioButton radioButtonHTNNew = view.findViewById(R.id.radio_hypertension_new);
        RadioButton radioButtonHTNKnown = view.findViewById(R.id.radio_hypertension_known);
        RadioButton radioButtonHTNNA = view.findViewById(R.id.radio_hypertension_na);
        RadioButton radioButtonHTNMild = view.findViewById(R.id.radio_hypertension_mild);
        RadioButton radioButtonHTNModerate = view.findViewById(R.id.radio_hypertension_moderate);
        RadioButton radioButtonHTNSevere = view.findViewById(R.id.radio_hypertension_severe);
        RadioButton radioButtonHTNPreeclampsia = view.findViewById(R.id.radio_hypertension_preeclampsia);
        RadioButton radioButtonNHIFYes = view.findViewById(R.id.radio_nhif_yes);
        RadioButton radioButtonNHIFNo = view.findViewById(R.id.radio_nhif_no);
        RadioButton radioButtonHIVNegative = view.findViewById(R.id.radio_hiv_negative);
        RadioButton radioButtonHIVPositive = view.findViewById(R.id.radio_hiv_positive);
        RadioButton radioButtonHIVUknown = view.findViewById(R.id.radio_hiv_unknown);
        RadioButton radioButtonTBYes = view.findViewById(R.id.radio_tb_yes);
        RadioButton radioButtonTBNo = view.findViewById(R.id.radio_tb_no);
        RadioButton radioButtonTBNa = view.findViewById(R.id.radio_tb_na);
        RadioButton radioButtonTBNegative = view.findViewById(R.id.radio_tb_status_negative);
        RadioButton radioButtonTBPositive = view.findViewById(R.id.radio_tb_status_positive);
        RadioButton radioButtonTBTreatment = view.findViewById(R.id.radio_tb_status_treatment);
        RadioButton radioButtonExerciseYes = view.findViewById(R.id.radio_exercise_yes);
        RadioButton radioButtonExerciseNo = view.findViewById(R.id.radio_exercise_no);
        RadioButton radioButtonDietYes = view.findViewById(R.id.radio_diet_yes);
        RadioButton radioButtonDietNo = view.findViewById(R.id.radio_diet_no);
        RadioButton radioButtonCigarettesYes = view.findViewById(R.id.radio_smoke_yes);
        RadioButton radioButtonCigarettesNo = view.findViewById(R.id.radio_smoke_no);
        RadioButton radioButtonAlcoholYes = view.findViewById(R.id.radio_drink_yes);
        RadioButton radioButtonAlcoholNo = view.findViewById(R.id.radio_drink_no);


        radioButtonClicked(radioButtonSick);
        radioButtonClicked(radioButtonReferred);
        radioButtonClicked(radioButtonScheduled);
        radioButtonClicked(radioButtonUnscheduled);
        radioButtonClicked(radioButtonDMNew);
        radioButtonClicked(radioButtonDMKnown);
        radioButtonClicked(radioButtonDMNA);
        radioButtonClicked(radioButtonDMType1);
        radioButtonClicked(radioButtonDMType);
        radioButtonClicked(radioButtonDMGDM);
        radioButtonClicked(radioButtonDMSecondary);
        radioButtonClicked(radioButtonHTNNew);
        radioButtonClicked(radioButtonHTNKnown);
        radioButtonClicked(radioButtonHTNNA);
        radioButtonClicked(radioButtonHTNMild);
        radioButtonClicked(radioButtonHTNModerate);
        radioButtonClicked(radioButtonHTNSevere);
        radioButtonClicked(radioButtonHTNPreeclampsia);
        radioButtonClicked(radioButtonNHIFYes);
        radioButtonClicked(radioButtonNHIFNo);
        radioButtonClicked(radioButtonHIVNegative);
        radioButtonClicked(radioButtonHIVPositive);
        radioButtonClicked(radioButtonHIVUknown);
        radioButtonClicked(radioButtonTBYes);
        radioButtonClicked(radioButtonTBNo);
        radioButtonClicked(radioButtonTBNa);
        radioButtonClicked(radioButtonTBNegative);
        radioButtonClicked(radioButtonTBPositive);
        radioButtonClicked(radioButtonTBTreatment);
        radioButtonClicked(radioButtonExerciseYes);
        radioButtonClicked(radioButtonExerciseNo);
        radioButtonClicked(radioButtonDietYes);
        radioButtonClicked(radioButtonDietNo);
        radioButtonClicked(radioButtonCigarettesYes);
        radioButtonClicked(radioButtonCigarettesNo);
        radioButtonClicked(radioButtonAlcoholYes);
        radioButtonClicked(radioButtonAlcoholNo);

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

    public void dmDiagnosis(String diagnosis) {
        if (diagnosis.matches("165087")) {
            dmDiagnosisDateEditText.setVisibility(View.GONE);
            dmClinicDateEditText.setVisibility(View.GONE);
            radioGroupDiabetes.setVisibility(View.VISIBLE);
        } else if (diagnosis.matches("165088")) {
            dmDiagnosisDateEditText.setVisibility(View.VISIBLE);
            dmClinicDateEditText.setVisibility(View.VISIBLE);
            radioGroupDiabetes.setVisibility(View.VISIBLE);
        } else {
            dmDiagnosisDateEditText.setVisibility(View.GONE);
            dmClinicDateEditText.setVisibility(View.GONE);
            radioGroupDiabetes.setVisibility(View.GONE);
        }

    }

    public void htnDiagnosis(String status) {
        if (status.matches("165092")) {
            htnDiagnosisDateEditText.setVisibility(View.GONE);
            htnClinicDateEditText.setVisibility(View.GONE);
            radioGroupHypertention.setVisibility(View.VISIBLE);
        } else if (status.matches("165093")) {
            htnDiagnosisDateEditText.setVisibility(View.VISIBLE);
            htnClinicDateEditText.setVisibility(View.VISIBLE);
            radioGroupHypertention.setVisibility(View.VISIBLE);
        } else {
            htnDiagnosisDateEditText.setVisibility(View.GONE);
            htnClinicDateEditText.setVisibility(View.GONE);
            radioGroupHypertention.setVisibility(View.GONE);
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

    public void radioButtonClicked(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                int value = radioButton.getId();
                switch (value) {
                    case R.id.radio_visit_sick:
                        if (checked)
                            visit_type = "163293";
                        break;
                    case R.id.radio_visit_referred:
                        if (checked)
                            visit_type = "160563";
                        break;
                    case R.id.radio_visit_scheduled:
                        if (checked)
                            visit_type = "1246";
                        break;
                    case R.id.radio_visit_unscheduled:
                        if (checked)
                            visit_type = "160101";
                        break;
                    case R.id.radio_diabetes_new:
                        if (checked)
                            dm_diagnosis = "165087";
                        break;
                    case R.id.radio_diabetes_known:
                        if (checked)
                            dm_diagnosis = "165088";
                        break;
                    case R.id.radio_diabetes_na:
                        if (checked)
                            dm_diagnosis = "1175";
                        break;
                    case R.id.radio_hypertension_new:
                        if (checked)
                            hypertension = "165092";
                        break;
                    case R.id.radio_hypertension_known:
                        if (checked)
                            hypertension = "165093";
                        break;
                    case R.id.radio_hypertension_na:
                        if (checked)
                            hypertension = "1175";
                        break;
                    case R.id.radio_nhif_yes:
                        if (checked)
                            nhif = "1065";
                        break;
                    case R.id.radio_nhif_no:
                        if (checked)
                            nhif = "1066";
                        break;
                    case R.id.radio_diabetes_type_1:
                        if (checked)
                            diabetes_type = "142474";
                        break;
                    case R.id.radio_diabetes_GDM:
                        if (checked)
                            diabetes_type = "1449";
                        break;
                    case R.id.radio_diabetes_type_2:
                        if (checked)
                            diabetes_type = "142473";
                        break;
                    case R.id.radio_diabetes_secondary:
                        if (checked)
                            diabetes_type = "165199";
                        break;
                    case R.id.radio_hypertension_mild:
                        if (checked)
                            hypertension_type = "165194";
                        break;
                    case R.id.radio_hypertension_moderate:
                        if (checked)
                            hypertension_type = "165195";
                        break;
                    case R.id.radio_hypertension_severe:
                        if (checked)
                            hypertension_type = "165196";
                        break;
                    case R.id.radio_hypertension_preeclampsia:
                        if (checked)
                            hypertension_type = "165197";
                        break;
                    case R.id.radio_tb_yes:
                        if (checked)
                            tb_screen = "1065";
                        break;
                    case R.id.radio_tb_no:
                        if (checked)
                            tb_screen = "1066";
                        break;
                    case R.id.radio_tb_na:
                        if (checked)
                            tb_screen = "1175";
                        break;
                    case R.id.radio_tb_status_negative:
                        if (checked)
                            tb_status = "664";
                        break;
                    case R.id.radio_tb_status_positive:
                        if (checked)
                            tb_status = "703";
                        break;
                    case R.id.radio_tb_status_treatment:
                        if (checked)
                            tb_status = "1662";
                        break;
                    case R.id.radio_hiv_negative:
                        if (checked)
                            hiv_status = "664";
                        break;
                    case R.id.radio_hiv_positive:
                        if (checked)
                            hiv_status = "138571";
                        break;
                    case R.id.radio_hiv_unknown:
                        if (checked)
                            hiv_status = "1067";
                        break;
                    case R.id.radio_exercise_yes:
                        if (checked)
                            exercise = "1065";
                        break;
                    case R.id.radio_exercise_no:
                        if (checked)
                            exercise = "1066";
                        break;
                    case R.id.radio_exercise_stopped:
                        if (checked)
                            exercise = "158939";
                        break;
                    case R.id.radio_diet_yes:
                        if (checked)
                            diet = "1065";
                        break;
                    case R.id.radio_diet_no:
                        if (checked)
                            diet = "1066";
                        break;
                    case R.id.radio_diet_stopped:
                        if (checked)
                            diet = "158939";
                        break;
                    case R.id.radio_smoke_yes:
                        if (checked)
                            smoking = "1065";
                        break;
                    case R.id.radio_smoke_no:
                        if (checked)
                            smoking = "1066";
                        break;
                    case R.id.radio_smoke_stopped:
                        if (checked)
                            smoking = "158939";
                        break;
                    case R.id.radio_drink_yes:
                        if (checked)
                            drinking = "159450";
                        break;
                    case R.id.radio_drink_no:
                        if (checked)
                            drinking = "1090";
                        break;
                    case R.id.radio_drink_stopped:
                        if (checked)
                            drinking = "159452";
                        break;
                }

                dmDiagnosis(dm_diagnosis);
                htnDiagnosis(hypertension);

                if ("1066".equals(nhif)) {
                    Alerts.errorMessage(view, "Encourage Client to Register for NHIF");
                }

                if ("703".equals(tb_status)) {
                    editTextTBDate.setVisibility(View.VISIBLE);
                } else {
                    editTextTBDate.setVisibility(View.GONE);
                }
                updateValues();
            }
        });
    }


    public void checkBox(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                int value = checkBox.getId();

                switch (value) {
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
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
        String current_time = timeFormat.format(new Date());
        String encounter_date = dm_followup_date.getText().toString().trim() + " " + current_time;

        JSONArray jsonArry = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("160638", "", "valueText", supporter_nameEditText.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160642", "", "valueText", supporter_phoneEditText.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165209", "", "valueText", supporter_phone_otherEditText.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("164181", "", "valueCoded", visit_type, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165086", "", "valueCoded", dm_diagnosis, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165094", "", "valueCoded", diabetes_type, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165091", "", "valueCoded", hypertension, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165094", "", "valueCoded", hypertension_type, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1917", "", "valueCoded", nhif, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("138405", "", "valueCoded", hiv_status, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165089", "", "valueDate", dmDiagnosisDateEditText.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165150", "", "valueDate", dmClinicDateEditText.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165090", "", "valueDate", htnDiagnosisDateEditText.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165151", "", "valueDate", htnClinicDateEditText.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("164800", "", "valueCoded", tb_screen, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1659", "", "valueCoded", tb_status, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165172", "", "valueDate", editTextTBDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165173", "", "valueText", editTextTBComment.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165208", "", "valueCoded", exercise, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165207", "", "valueCoded", diet, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("152722", "", "valueCoded", smoking, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("159449", "", "valueCoded", drinking, DateCalendar.date(), ""));

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
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("JSON FollowUp Page 1", jsonArry.toString() + " ");

        FragmentModelFollowUp.getInstance().followUpOne(encounter_date, jsonArry);
    }
}
