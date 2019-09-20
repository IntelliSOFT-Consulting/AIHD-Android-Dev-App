package org.aihdint.aihd.fragments.followup;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

import org.aihdint.aihd.common.Common;
import org.aihdint.aihd.R;
import org.aihdint.aihd.common.DateCalendar;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import customfonts.TextView_Roboto_Bold;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_3 extends Fragment {

    private View view;
    private EditText editTextSystolic, editTextDiastolic;
    private EditText editTextWaist, editTextHip, editTextHeight, editTextWeight, editTextNutrition;
    private TextView_Roboto_Bold textViewBMI, textViewWaistHipRatio;
    private String foot_exam, eye_exam, dental_exam, eye_checkup;
    private String cardiovascular_disease, high_blood_pressure, high_cholestrol, peripheral_vascular_disease,
            peripheral_neuropathy, autonomic_neuropathy, retinopathy, kidney_disease, asthma_COPD,
            arthritis, foot, assesment_other, foot_amputation;
    private EditText editTextCardiovascularDisease, editTextHBP, editTextHighCholestrol, editTextVascularDisease, editTextPNeuropathy, editTextANeuropathy,
            editTextRetinopathy, editTextKidneyDisease, editTextAsthma, editTextArthritis, editTextFoot, editTextOther;
    private EditText editTextFBS, editTextRBS, editTextHBA, editTextHDL, editTextLDL, editTextTriglycerides, editTextUEC, editTextUrinalysis, editTextLabDate;

    private EditText editTextFootRiskComments, editTextFootExamComments;
    private String peripheral_neuropathy_foot, ulcers_foot, amputation, acute_joint, low_current_risk, at_risk, high_risk, ulcerated_foot, foot_emergency;
    private String pedal_pulse, peripheral_neuropathy_exam, deformity, foot_ulcer, amputation_exam, acute_joint_exam, sensation_loss;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dm_followup_fragment_3, container, false);

        editTextSystolic = view.findViewById(R.id.followup_systolic);
        editTextDiastolic = view.findViewById(R.id.followup_diastolic);

        editTextWaist = view.findViewById(R.id.followup_waist_circ);
        editTextHip = view.findViewById(R.id.followup_hip_circ);
        editTextHeight = view.findViewById(R.id.followup_height);
        editTextWeight = view.findViewById(R.id.followup_weight);
        editTextNutrition = view.findViewById(R.id.followup_nutrition);

        editTextCardiovascularDisease = view.findViewById(R.id.details_cardiovascular_disease);
        editTextHBP = view.findViewById(R.id.details_high_bp);
        editTextHighCholestrol = view.findViewById(R.id.details_high_cholestrol);
        editTextVascularDisease = view.findViewById(R.id.details_peripheral_vascular_disease);
        editTextPNeuropathy = view.findViewById(R.id.details_peripheral_neuropathy);
        editTextANeuropathy = view.findViewById(R.id.details_autonomic_neuropathy);
        editTextRetinopathy = view.findViewById(R.id.details_retinopathy);
        editTextKidneyDisease = view.findViewById(R.id.details_kidney_disease);
        editTextAsthma = view.findViewById(R.id.details_asthma_COPD);
        editTextArthritis = view.findViewById(R.id.details_arthritis);
        editTextFoot = view.findViewById(R.id.details_foot);
        editTextOther = view.findViewById(R.id.details_assesment_other);

        editTextFBS = view.findViewById(R.id.followup_fbs);
        editTextRBS = view.findViewById(R.id.followup_rbs);
        editTextHBA = view.findViewById(R.id.followup_hba);
        editTextHDL = view.findViewById(R.id.followup_hdl);
        editTextLDL = view.findViewById(R.id.followup_ldl);
        editTextTriglycerides = view.findViewById(R.id.followup_triglycerides);
        editTextUEC = view.findViewById(R.id.followup_uec);
        editTextUrinalysis = view.findViewById(R.id.followup_urinalysis);

        editTextLabDate = view.findViewById(R.id.date_labs);
        DateCalendar.date(getActivity(), editTextLabDate);
        //editTextLabDate.setText(DateCalendar.date());

        textWatcher(editTextSystolic, "blood_pressure");
        textWatcher(editTextDiastolic, "blood_pressure");

        textViewBMI = view.findViewById(R.id.followup_bmi);
        textViewWaistHipRatio = view.findViewById(R.id.followup_hip_waist_ratio);

        textWatcher(editTextSystolic, "blood_pressure");
        textWatcher(editTextDiastolic, "blood_pressure");

        textWatcher(editTextHeight, "bmi");
        textWatcher(editTextWeight, "bmi");
        textWatcher(editTextWaist, "whr");
        textWatcher(editTextHip, "whr");

        textWatcher(editTextCardiovascularDisease, "");
        textWatcher(editTextHBP, "");
        textWatcher(editTextHighCholestrol, "");
        textWatcher(editTextVascularDisease, "");
        textWatcher(editTextPNeuropathy, "");
        textWatcher(editTextANeuropathy, "");
        textWatcher(editTextRetinopathy, "");
        textWatcher(editTextKidneyDisease, "");
        textWatcher(editTextAsthma, "");
        textWatcher(editTextArthritis, "");
        textWatcher(editTextFoot, "");
        textWatcher(editTextOther, "");

        textWatcher(editTextFBS, "");
        textWatcher(editTextRBS, "");
        textWatcher(editTextHBA, "");
        textWatcher(editTextHDL, "");
        textWatcher(editTextLDL, "");
        textWatcher(editTextTriglycerides, "");
        textWatcher(editTextUEC, "");
        textWatcher(editTextUrinalysis, "");

        textViewBMI = view.findViewById(R.id.followup_bmi);
        textViewWaistHipRatio = view.findViewById(R.id.followup_hip_waist_ratio);

        CheckBox checkBoxCardiovascularDisease = view.findViewById(R.id.checkbox_cardiovascular_disease);
        CheckBox checkBoxHBP = view.findViewById(R.id.checkbox_high_BP);
        CheckBox checkBoxHighCholestrol = view.findViewById(R.id.checkbox_high_cholestrol);
        CheckBox checkBoxVascularDisease = view.findViewById(R.id.checkbox_peripheral_vascular_disease);
        CheckBox checkBoxPNeuropathy = view.findViewById(R.id.checkbox_peripheral_neuropathy_assesment);
        CheckBox checkBoxANeuropathy = view.findViewById(R.id.checkbox_autonomic_neuropathy);
        CheckBox checkBoxRetinopathy = view.findViewById(R.id.checkbox_retinopathy);
        CheckBox checkBoxKidneyDisease = view.findViewById(R.id.checkbox_kidney_disease);
        CheckBox checkBoxAsthma = view.findViewById(R.id.checkbox_asthma_COPD);
        CheckBox checkBoxArthritis = view.findViewById(R.id.checkbox_arthritis);
        CheckBox checkBoxFoot = view.findViewById(R.id.checkbox_foot);
        CheckBox checkBoxOther = view.findViewById(R.id.checkbox_assesment_other);

        checkBox(checkBoxCardiovascularDisease);
        checkBox(checkBoxHBP);
        checkBox(checkBoxHighCholestrol);
        checkBox(checkBoxVascularDisease);
        checkBox(checkBoxPNeuropathy);
        checkBox(checkBoxANeuropathy);
        checkBox(checkBoxRetinopathy);
        checkBox(checkBoxKidneyDisease);
        checkBox(checkBoxAsthma);
        checkBox(checkBoxArthritis);
        checkBox(checkBoxFoot);
        checkBox(checkBoxOther);

        RadioButton radioButtonFootAmputationYes = view.findViewById(R.id.radio_foot_amputations_yes);
        RadioButton radioButtonFootAmputationNo = view.findViewById(R.id.radio_foot_amputations_no);

        radioButtonClicked(radioButtonFootAmputationYes);
        radioButtonClicked(radioButtonFootAmputationNo);

        editTextFootRiskComments = view.findViewById(R.id.foot_risk_comments);
        editTextFootExamComments = view.findViewById(R.id.foot_exam_comments);

        textWatcher(editTextFootRiskComments, "");
        textWatcher(editTextFootExamComments, "");

        CheckBox checkboxPeripheralNeuropathy = view.findViewById(R.id.checkbox_peripheral_neuropathy);
        CheckBox checkboxUlcers = view.findViewById(R.id.checkbox_ulcers);
        CheckBox checkboxAmputation = view.findViewById(R.id.checkbox_amputation);
        CheckBox checkboxAcuteJoint = view.findViewById(R.id.checkbox_acute_joint);
        CheckBox checkboxLowRisk = view.findViewById(R.id.checkbox_low_risk);
        CheckBox checkboxAtRisk = view.findViewById(R.id.checkbox_at_risk);
        CheckBox checkboxHighRisk = view.findViewById(R.id.checkbox_high_risk);
        CheckBox checkboxUlceratedFoot = view.findViewById(R.id.checkbox_ulcerated_foot);
        CheckBox checkboxFootEmergency = view.findViewById(R.id.checkbox_foot_emergency);

        checkBox(checkboxPeripheralNeuropathy);
        checkBox(checkboxUlcers);
        checkBox(checkboxAmputation);
        checkBox(checkboxAcuteJoint);
        checkBox(checkboxLowRisk);
        checkBox(checkboxAtRisk);
        checkBox(checkboxHighRisk);
        checkBox(checkboxUlceratedFoot);
        checkBox(checkboxFootEmergency);

        RadioButton radioButtonTreatmentPedalPulse = view.findViewById(R.id.radio_foot_exam_treatment_pedal_pulse);
        RadioButton radioButtonResolvedPedalPulse = view.findViewById(R.id.radio_foot_exam_resolved_pedal_pulse);
        RadioButton radioButtonReferralPedalPulse = view.findViewById(R.id.radio_foot_exam_referral_pedal_pulse);
        RadioButton radioButtonFootSavedPedalPulse = view.findViewById(R.id.radio_foot_exam_saved_pedal_pulse);

        RadioButton radioButtonTreatmentPeripheralNeuropathy = view.findViewById(R.id.radio_foot_exam_treatment_peripheral_neuropathy);
        RadioButton radioButtonResolvedPeripheralNeuropathy = view.findViewById(R.id.radio_foot_exam_resolved_peripheral_neuropathy);
        RadioButton radioButtonReferralPeripheralNeuropathy = view.findViewById(R.id.radio_foot_exam_referral_peripheral_neuropathy);
        RadioButton radioButtonFootSavedPPeripheralNeuropathy = view.findViewById(R.id.radio_foot_exam_saved_peripheral_neuropathy);

        RadioButton radioButtonTreatmentDeformity = view.findViewById(R.id.radio_foot_exam_treatment_deformity);
        RadioButton radioButtonResolvedDeformity = view.findViewById(R.id.radio_foot_exam_resolved_deformity);
        RadioButton radioButtonReferralDeformity = view.findViewById(R.id.radio_foot_exam_referral_deformity);
        RadioButton radioButtonFootSavedDeformity = view.findViewById(R.id.radio_foot_exam_saved_deformity);

        RadioButton radioButtonTreatmentFootUcler = view.findViewById(R.id.radio_foot_exam_treatment_foot_ulcer);
        RadioButton radioButtonResolvedFootUcler = view.findViewById(R.id.radio_foot_exam_resolved_foot_ulcer);
        RadioButton radioButtonReferralFootUcler = view.findViewById(R.id.radio_foot_exam_referral_foot_ulcer);
        RadioButton radioButtonFootSavedFootUcler = view.findViewById(R.id.radio_foot_exam_saved_foot_ulcer);

        RadioButton radioButtonTreatmentAmputation = view.findViewById(R.id.radio_foot_exam_treatment_amputation);
        RadioButton radioButtonResolvedAmputation = view.findViewById(R.id.radio_foot_exam_resolved_amputation);
        RadioButton radioButtonReferralAmputation = view.findViewById(R.id.radio_foot_exam_referral_amputation);
        RadioButton radioButtonFootSavedAmputation = view.findViewById(R.id.radio_foot_exam_saved_amputation);

        RadioButton radioButtonTreatmentAcuteJoint = view.findViewById(R.id.radio_foot_exam_treatment_acute_joint);
        RadioButton radioButtonResolvedAcuteJoint = view.findViewById(R.id.radio_foot_exam_resolved_acute_joint);
        RadioButton radioButtonReferralAcuteJoint = view.findViewById(R.id.radio_foot_exam_referral_acute_joint);
        RadioButton radioButtonFootSavedAcuteJoint = view.findViewById(R.id.radio_foot_exam_saved_acute_joint);

        RadioButton radioButtonTreatmentSensationLoss = view.findViewById(R.id.radio_foot_exam_treatment_sensation_loss);
        RadioButton radioButtonResolvedSensationLoss = view.findViewById(R.id.radio_foot_exam_resolved_sensation_loss);
        RadioButton radioButtonReferralSensationLoss = view.findViewById(R.id.radio_foot_exam_referral_sensation_loss);
        RadioButton radioButtonFootSavedSensationLoss = view.findViewById(R.id.radio_foot_exam_saved_sensation_loss);

        radioButton(radioButtonTreatmentPedalPulse);
        radioButton(radioButtonResolvedPedalPulse);
        radioButton(radioButtonReferralPedalPulse);
        radioButton(radioButtonFootSavedPedalPulse);

        radioButton(radioButtonTreatmentPeripheralNeuropathy);
        radioButton(radioButtonResolvedPeripheralNeuropathy);
        radioButton(radioButtonReferralPeripheralNeuropathy);
        radioButton(radioButtonFootSavedPPeripheralNeuropathy);

        radioButton(radioButtonTreatmentDeformity);
        radioButton(radioButtonResolvedDeformity);
        radioButton(radioButtonReferralDeformity);
        radioButton(radioButtonFootSavedDeformity);

        radioButton(radioButtonTreatmentFootUcler);
        radioButton(radioButtonResolvedFootUcler);
        radioButton(radioButtonReferralFootUcler);
        radioButton(radioButtonFootSavedFootUcler);

        radioButton(radioButtonTreatmentAmputation);
        radioButton(radioButtonResolvedAmputation);
        radioButton(radioButtonReferralAmputation);
        radioButton(radioButtonFootSavedAmputation);

        radioButton(radioButtonTreatmentAcuteJoint);
        radioButton(radioButtonResolvedAcuteJoint);
        radioButton(radioButtonReferralAcuteJoint);
        radioButton(radioButtonFootSavedAcuteJoint);

        radioButton(radioButtonTreatmentSensationLoss);
        radioButton(radioButtonResolvedSensationLoss);
        radioButton(radioButtonReferralSensationLoss);
        radioButton(radioButtonFootSavedSensationLoss);

        return view;
    }

    public void textWatcher(EditText editText, final String check) {

        editText.addTextChangedListener(new TextWatcher() {

            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void afterTextChanged(final Editable editable) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        switch (check) {
                            case "blood_pressure":
                                if (editTextSystolic != null && editTextDiastolic != null) {
                                    Common.checkBP(view, editTextSystolic, editTextDiastolic);
                                }
                                break;
                            case "bmi":
                                Common.bmi(getContext(), editTextHeight, editTextWeight, textViewBMI);
                                break;
                            case "whr":
                                Common.whr(editTextWaist, editTextHip, textViewWaistHipRatio);
                                break;
                            default:
                                break;
                        }

                    }
                }, 3000);

                updateValues();
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                /* Do nothing*/
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                /* Do nothing*/
            }
        });
    }


    public void radioButtonClicked(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                switch (radioButton.getId()) {
                    case R.id.radio_foot_amputations_yes:
                        if (checked) {
                            foot_amputation = "1065";
                        }
                        break;
                    case R.id.radio_foot_amputations_no:
                        if (checked) {
                            foot_amputation = "1066";
                        }
                        break;
                    default:
                        break;
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

                //Check which checkbox was clicked
                switch (checkBox.getId()) {
                    case R.id.checkbox_foot_exam:
                        if (checked) {
                            foot_exam = "165099";
                        } else {
                            foot_exam = "";
                        }
                        break;
                    case R.id.checkbox_eye_exam:
                        if (checked) {
                            eye_exam = "165100";
                        } else {
                            eye_exam = "";
                        }
                        break;
                    case R.id.checkbox_dental_exam:
                        if (checked) {
                            dental_exam = "165101";
                        } else {
                            dental_exam = "";
                        }
                        break;
                    case R.id.checkbox_eye_check_up:
                        if (checked) {
                            eye_checkup = "165102";
                        } else {
                            eye_checkup = "";
                        }
                        break;
                    case R.id.checkbox_cardiovascular_disease:
                        if (checked) {
                            cardiovascular_disease = "119270";
                        } else {
                            cardiovascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_high_BP:
                        if (checked) {
                            high_blood_pressure = "117399";
                        } else {
                            high_blood_pressure = "";
                        }
                        break;
                    case R.id.checkbox_high_cholestrol:
                        if (checked) {
                            high_cholestrol = "117460";
                        } else {
                            high_cholestrol = "";
                        }
                        break;
                    case R.id.checkbox_peripheral_vascular_disease:
                        if (checked) {
                            peripheral_vascular_disease = "114212";
                        } else {
                            peripheral_vascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_peripheral_neuropathy_assesment:
                        if (checked) {
                            peripheral_neuropathy = "118983";
                        } else {
                            peripheral_neuropathy = "";
                        }
                        break;
                    case R.id.checkbox_autonomic_neuropathy:
                        if (checked) {
                            autonomic_neuropathy = "155215";
                        } else {
                            autonomic_neuropathy = "";
                        }
                        break;
                    case R.id.checkbox_retinopathy:
                        if (checked) {
                            retinopathy = "113257";
                        } else {
                            retinopathy = "";
                        }
                        break;
                    case R.id.checkbox_kidney_disease:
                        if (checked) {
                            kidney_disease = "6033";
                        } else {
                            kidney_disease = "";
                        }
                        break;
                    case R.id.checkbox_asthma_COPD:
                        if (checked) {
                            asthma_COPD = "121375";
                        } else {
                            asthma_COPD = "";
                        }
                        break;
                    case R.id.checkbox_arthritis:
                        if (checked) {
                            arthritis = "148432";
                        } else {
                            arthritis = "";
                        }
                        break;
                    case R.id.checkbox_foot:
                        if (checked) {
                            foot = "165104";
                        } else {
                            foot = "";
                        }
                        break;
                    case R.id.checkbox_assesment_other:
                        if (checked) {
                            assesment_other = "5622";
                        } else {
                            assesment_other = "";
                        }
                        break;
                    case R.id.checkbox_peripheral_neuropathy:
                        if (checked) {
                            peripheral_neuropathy_foot = "118983";
                        } else {
                            peripheral_neuropathy_foot = "";
                        }
                        break;
                    case R.id.checkbox_ulcers:
                        if (checked) {
                            ulcers_foot = "123919";
                        } else {
                            ulcers_foot = "";
                        }
                        break;
                    case R.id.checkbox_amputation:
                        if (checked) {
                            amputation = "164009";
                        } else {
                            amputation = "";
                        }
                        break;
                    case R.id.checkbox_acute_joint:
                        if (checked) {
                            acute_joint = "165317";
                        } else {
                            acute_joint = "";
                        }
                        break;
                    case R.id.checkbox_low_risk:
                        if (checked) {
                            low_current_risk = "165338";
                        } else {
                            low_current_risk = "";
                        }
                        break;
                    case R.id.checkbox_at_risk:
                        if (checked) {
                            at_risk = "165321";
                        } else {
                            at_risk = "";
                        }
                        break;
                    case R.id.checkbox_high_risk:
                        if (checked) {
                            high_risk = "165320";
                        } else {
                            high_risk = "";
                        }
                        break;
                    case R.id.checkbox_ulcerated_foot:
                        if (checked) {
                            ulcerated_foot = "163411";
                        } else {
                            ulcerated_foot = "";
                        }
                        break;
                    case R.id.checkbox_foot_emergency:
                        if (checked) {
                            foot_emergency = "165319";
                        } else {
                            foot_emergency = "";
                        }
                        break;
                    default:
                        break;
                }
                updateValues();
            }
        });
    }

    public void radioButton(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Is the button now checked?
                boolean checked = (buttonView).isChecked();
                int value = radioButton.getId();

                // Check which radio button was clicked
                switch (value) {

                    case R.id.radio_foot_exam_treatment_pedal_pulse:
                        if (checked)
                            pedal_pulse = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_pedal_pulse:
                        if (checked)
                            pedal_pulse = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_pedal_pulse:
                        if (checked)
                            pedal_pulse = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_pedal_pulse:
                        if (checked)
                            pedal_pulse = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_peripheral_neuropathy:
                        if (checked)
                            peripheral_neuropathy_exam = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_peripheral_neuropathy:
                        if (checked)
                            peripheral_neuropathy_exam = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_peripheral_neuropathy:
                        peripheral_neuropathy_exam = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_peripheral_neuropathy:
                        if (checked)
                            peripheral_neuropathy_exam = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_deformity:
                        if (checked)
                            deformity = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_deformity:
                        if (checked)
                            deformity = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_deformity:
                        if (checked)
                            deformity = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_deformity:
                        if (checked)
                            deformity = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_foot_ulcer:
                        if (checked)
                            foot_ulcer = "160749";
                        break;

                    case R.id.radio_foot_exam_resolved_foot_ulcer:
                        if (checked)
                            foot_ulcer = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_foot_ulcer:
                        if (checked)
                            foot_ulcer = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_foot_ulcer:
                        if (checked)
                            foot_ulcer = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_amputation:
                        if (checked)
                            amputation_exam = "160749";
                        break;

                    case R.id.radio_foot_exam_resolved_amputation:
                        if (checked)
                            amputation_exam = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_amputation:
                        if (checked)
                            amputation_exam = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_amputation:
                        if (checked)
                            amputation_exam = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_acute_joint:
                        if (checked)
                            acute_joint_exam = "160749";
                        break;

                    case R.id.radio_foot_exam_resolved_acute_joint:
                        if (checked)
                            acute_joint_exam = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_acute_joint:
                        if (checked)
                            acute_joint_exam = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_acute_joint:
                        if (checked)
                            acute_joint_exam = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_sensation_loss:
                        if (checked)
                            sensation_loss = "160749";
                        break;

                    case R.id.radio_foot_exam_resolved_sensation_loss:
                        if (checked)
                            sensation_loss = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_sensation_loss:
                        if (checked)
                            sensation_loss = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_sensation_loss:
                        if (checked)
                            sensation_loss = "165329";
                        break;


                }

                updateValues();
            }
        });

    }

    public void updateValues() {

        JSONArray jsonArry = new JSONArray();
        JSONArray jsonGroup = new JSONArray();

        JSONArray jsonArry1 = new JSONArray();
        JSONArray jsonArry2 = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("5090", "", "valueNumeric", editTextHeight.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5089", "", "valueNumeric", editTextWeight.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5085", "", "valueNumeric", editTextSystolic.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5086", "", "valueNumeric", editTextDiastolic.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163081", "", "valueNumeric", editTextHip.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163080", "", "valueNumeric", editTextWaist.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165190", "", "valueText", editTextNutrition.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", foot_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", eye_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", dental_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", eye_checkup, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", peripheral_neuropathy_foot, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", ulcers_foot, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", amputation, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", acute_joint, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165337", "", "valueText", editTextFootRiskComments.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", low_current_risk, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", at_risk, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", high_risk, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", ulcerated_foot, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", foot_emergency, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165339", "", "valueCoded", pedal_pulse, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165324", "", "valueCoded", peripheral_neuropathy_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165325", "", "valueCoded", deformity, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165326", "", "valueCoded", foot_ulcer, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165340", "", "valueCoded", amputation_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165327", "", "valueCoded", acute_joint_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165328", "", "valueCoded", sensation_loss, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165337", "", "valueText", editTextFootExamComments.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", cardiovascular_disease, DateCalendar.date(), editTextCardiovascularDisease.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", high_blood_pressure, DateCalendar.date(), editTextHBP.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", high_cholestrol, DateCalendar.date(), editTextHighCholestrol.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", peripheral_vascular_disease, DateCalendar.date(), editTextVascularDisease.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", peripheral_neuropathy, DateCalendar.date(), editTextPNeuropathy.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", autonomic_neuropathy, DateCalendar.date(), editTextANeuropathy.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", retinopathy, DateCalendar.date(), editTextRetinopathy.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", kidney_disease, DateCalendar.date(), editTextKidneyDisease.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", asthma_COPD, DateCalendar.date(), editTextAsthma.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", arthritis, DateCalendar.date(), editTextArthritis.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", foot, DateCalendar.date(), editTextFoot.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", assesment_other, DateCalendar.date(), editTextOther.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("165104", "", "valueCoded", foot_amputation, DateCalendar.date(), ""));

        jsonArry1.put(JSONFormBuilder.observations("160912", "161487", "valueNumeric", editTextFBS.getText().toString().trim(), editTextLabDate.getText().toString().trim(), ""));
        jsonArry1.put(JSONFormBuilder.observations("887", "161487", "valueNumeric", editTextRBS.getText().toString().trim(), editTextLabDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("159644", "", "valueNumeric", editTextHBA.getText().toString().trim(), editTextLabDate.getText().toString().trim(), ""));
        jsonArry2.put(JSONFormBuilder.observations("1007", "161487", "valueNumeric", editTextHDL.getText().toString().trim(), editTextLabDate.getText().toString().trim(), ""));
        jsonArry2.put(JSONFormBuilder.observations("1008", "161487", "valueNumeric", editTextLDL.getText().toString().trim(), editTextLabDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("1009", "", "valueNumeric", editTextTriglycerides.getText().toString().trim(), editTextLabDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("164364", "", "valueNumeric", editTextUEC.getText().toString().trim(), editTextLabDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("160987", "", "valueText", editTextUrinalysis.getText().toString().trim(), editTextLabDate.getText().toString().trim(), ""));

        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);

            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry1), jsonGroup);
            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry2), jsonGroup);

            if (jsonGroup.length() > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("groups", jsonGroup);

                jsonArry.put(jsonObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("JSON FollowUp Page 3", jsonArry.toString() + " ");

        FragmentModelFollowUp.getInstance().followUpThree(jsonArry);
    }

}
