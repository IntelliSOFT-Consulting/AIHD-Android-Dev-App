package org.development.aihd.app.fragments.initial;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import org.development.aihd.app.R;
import org.development.aihd.app.app.AppController;
import org.development.aihd.app.common.DateCalendar;
import org.development.aihd.app.common.JSONFormBuilder;
import org.development.aihd.app.model.KeyValue;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Initial_page_6 extends Fragment {

    private EditText editTextAdmitReason,editTextReturnDate, editTextFacility, editTextDateReffered, editTextHealthFacility, editTextDateOut, editTextReffered, editTextRefferalReason, editTextSupportGroup,
            editTextProvider;

    private String continueCare, referFacility, transferFacility, managementDM, managementHTN, eyeReview, surgicalReview, renalReview,
            cvdReview, nutrition, physiotherapy, followUpOther;

    private String supportGroup, designation, admit;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_6, container, false);

        RadioButton radioButtonAdmitYes = view.findViewById(R.id.radio_admit_yes);
        RadioButton radioButtonAdmitNo = view.findViewById(R.id.radio_admit_no);

        radioButton(radioButtonAdmitYes);
        radioButton(radioButtonAdmitNo);

        //Follow Up Plan
        CheckBox checkBoxContinueCare = view.findViewById(R.id.followup_continue);
        CheckBox checkBoxReferFacility = view.findViewById(R.id.followup_refer);
        CheckBox checkBoxTransferFacility = view.findViewById(R.id.followup_transfer);
        CheckBox checkBoxManagementDM = view.findViewById(R.id.followup_further_management_dm);
        CheckBox checkBoxManagementHTN = view.findViewById(R.id.followup_further_management_htn);
        CheckBox checkBoxEyeReview = view.findViewById(R.id.followup_eye_review);
        CheckBox checkBoxSurgicalReview = view.findViewById(R.id.followup_surgical_review);
        CheckBox checkBoxRenalReview = view.findViewById(R.id.followup_renal_review);
        CheckBox checkBoxCVDReview = view.findViewById(R.id.followup_cvd_review);
        CheckBox checkBoxNutrition = view.findViewById(R.id.followup_nutrition);
        CheckBox checkBoxPhysiotherapy = view.findViewById(R.id.followup_physiotherapy);
        CheckBox checkBoxFollowUpOther = view.findViewById(R.id.followup_other);

        checkBoxFollowUp(checkBoxContinueCare);
        checkBoxFollowUp(checkBoxReferFacility);
        checkBoxFollowUp(checkBoxTransferFacility);
        checkBoxFollowUp(checkBoxManagementDM);
        checkBoxFollowUp(checkBoxManagementHTN);
        checkBoxFollowUp(checkBoxEyeReview);
        checkBoxFollowUp(checkBoxSurgicalReview);
        checkBoxFollowUp(checkBoxRenalReview);
        checkBoxFollowUp(checkBoxCVDReview);
        checkBoxFollowUp(checkBoxNutrition);
        checkBoxFollowUp(checkBoxPhysiotherapy);
        checkBoxFollowUp(checkBoxFollowUpOther);

        editTextAdmitReason = view.findViewById(R.id.admit_reason);
        editTextReturnDate = view.findViewById(R.id.followup_date);
        editTextFacility = view.findViewById(R.id.facility);
        editTextDateReffered = view.findViewById(R.id.date_referred);
        editTextHealthFacility = view.findViewById(R.id.health_center);
        editTextDateOut = view.findViewById(R.id.date_transfer);
        editTextReffered = view.findViewById(R.id.reason_reffered);
        editTextRefferalReason = view.findViewById(R.id.followup_other_reason);
        editTextSupportGroup = view.findViewById(R.id.support_group);
        editTextProvider = view.findViewById(R.id.provider_name);
        editTextProvider.setText(AppController.getInstance().getSessionManager().getUserDetails().get("name"));

        DateCalendar.date(getActivity(), editTextReturnDate);
        DateCalendar.date(getActivity(), editTextDateReffered);
        DateCalendar.date(getActivity(), editTextDateOut);

        textWatcher(editTextReturnDate);
        textWatcher(editTextFacility);
        textWatcher(editTextDateReffered);
        textWatcher(editTextHealthFacility);
        textWatcher(editTextDateOut);
        textWatcher(editTextReffered);
        textWatcher(editTextRefferalReason);
        textWatcher(editTextSupportGroup);
        textWatcher(editTextProvider);

        Spinner spinnerSupportGroup = view.findViewById(R.id.spinnerSupportGroup);
        Spinner spinnerDesignation = view.findViewById(R.id.spinnerDesignation);

        spinnerData(getContext(), spinnerSupportGroup, "support_group");
        spinnerData(getContext(), spinnerDesignation, "designation");

        return view;
    }

    public void spinnerData(Context context, final Spinner spinner, final String data) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        if (data.matches("support_group")) {
            // adding each child node to HashMap key => value
            keyvalue.add(new KeyValue("", "Select Support Group"));
            keyvalue.add(new KeyValue("1065", "Yes"));
            keyvalue.add(new KeyValue("1066", "No"));
            keyvalue.add(new KeyValue("5622", "Unknown"));
        } else if (data.matches("designation")) {
            keyvalue.add(new KeyValue("", "Select Designation"));
            keyvalue.add(new KeyValue("", "Consultant"));
            keyvalue.add(new KeyValue("", "Medical officer"));
            keyvalue.add(new KeyValue("", "Clinical Officer"));
            keyvalue.add(new KeyValue("", "Nurse"));
        }

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                switch (spinner.getId()) {
                    case R.id.spinnerSupportGroup:
                        if (data.matches("support_group")) {
                            supportGroup = value.getId();
                        }
                        break;
                    case R.id.spinnerDesignation:
                        if (data.matches("designation")) {
                            designation = value.getId();
                        }
                        break;
                    default:
                        break;
                }
                updateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void textWatcher(EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(final Editable editable) {
                updateValues();
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });
    }


    public void checkBoxFollowUp(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                int value = checkBox.getId();

                //Check which checkbox was clicked
                switch (value) {
                    case R.id.followup_continue:
                        if (checked) {
                            continueCare = "165132";
                        } else {
                            continueCare = "";
                        }
                        break;
                    case R.id.followup_refer:
                        if (checked) {
                            referFacility = "164165";
                        } else {
                            referFacility = "";
                        }
                        break;
                    case R.id.followup_transfer:
                        if (checked) {
                            transferFacility = "1285";
                        } else {
                            transferFacility = "";
                        }
                        break;
                    case R.id.followup_further_management_dm:
                        if (checked) {
                            managementDM = "165133";
                        } else {
                            managementDM = "";
                        }
                        break;
                    case R.id.followup_further_management_htn:
                        if (checked) {
                            managementHTN = "165135";
                        } else {
                            managementHTN = "";
                        }
                        break;
                    case R.id.followup_eye_review:
                        if (checked) {
                            eyeReview = "165138";
                        } else {
                            eyeReview = "";
                        }
                        break;
                    case R.id.followup_surgical_review:
                        if (checked) {
                            surgicalReview = "165137";
                        } else {
                            surgicalReview = "";
                        }
                        break;
                    case R.id.followup_renal_review:
                        if (checked) {
                            renalReview = "165136";
                        } else {
                            renalReview = "";
                        }
                        break;
                    case R.id.followup_cvd_review:
                        if (checked) {
                            cvdReview = "119270";
                        } else {
                            cvdReview = "";
                        }
                        break;
                    case R.id.followup_nutrition:
                        if (checked) {
                            nutrition = "160552";
                        } else {
                            nutrition = "";
                        }
                        break;
                    case R.id.followup_physiotherapy:
                        if (checked) {
                            physiotherapy = "165134";
                        } else {
                            physiotherapy = "";
                        }
                        break;
                    case R.id.followup_other:
                        if (checked) {
                            followUpOther = "5622";
                        } else {
                            followUpOther = "";
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
                    case R.id.radio_admit_yes:
                        if (checked)
                            admit = "1065";
                        break;
                    case R.id.radio_admit_no:
                        if (checked)
                            admit = "1066";
                        break;
                    default:
                        break;

                }

                updateValues();
            }
        });

    }

    public void updateValues() {

        JSONArray jsonArry = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("162477", "", "valueCoded", admit, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("162879", "", "valueText", editTextAdmitReason.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165122", "", "valueCoded", continueCare, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5096", "", "valueDate", editTextReturnDate.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165122", "", "valueCoded", referFacility, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("", "", "valueText", editTextDateReffered.getText().toString(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165167", "", "valueText", editTextFacility.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165122", "", "valueCoded", transferFacility, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("159495", "", "valueText", editTextHealthFacility.getText().toString(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160649", "", "valueDate", editTextDateOut.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165168", "", "valueText", editTextReffered.getText().toString(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", managementDM, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", managementHTN, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", eyeReview, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", surgicalReview, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", renalReview, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", cvdReview, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", nutrition, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", physiotherapy, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", followUpOther, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165139", "", "valueText", editTextRefferalReason.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("163766", "", "valueCoded", supportGroup, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165169", "", "valueText", editTextSupportGroup.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1473", "", "valueText", editTextProvider.getText().toString(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163556", "", "valueCoded", designation, DateCalendar.date(), ""));


        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Log.d("JSON Initial Page 6", jsonArry.toString() + " ");

        FragmentModelInitial.getInstance().initialSix(jsonArry);
    }

}
