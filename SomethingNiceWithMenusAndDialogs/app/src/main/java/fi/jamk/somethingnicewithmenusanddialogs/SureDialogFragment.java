package fi.jamk.somethingnicewithmenusanddialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Henkka on 26.9.2016.
 */

public class SureDialogFragment extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class to create a Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_title2)
                .setMessage(R.string.dialog_exit2)
                .setPositiveButton(R.string.dialog_yes2, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Close application
                        Toast.makeText(getActivity(), "Okay :(", Toast.LENGTH_LONG).show();
                        //android.os.Process.killProcess(android.os.Process.myPid());
                        //System.exit(1);
                    }
                })
                .setNegativeButton(R.string.dialog_cancel2, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        Toast.makeText(getActivity(), "That's right! :)", Toast.LENGTH_LONG).show();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
