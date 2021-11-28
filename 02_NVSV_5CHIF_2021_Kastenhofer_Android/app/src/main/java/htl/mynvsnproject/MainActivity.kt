package htl.mynvsnproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

const val FULL_NAME_KEY = "FULL_NAME_KEY"

class MainActivity : AppCompatActivity() {


    private val loginButton: Button
        get() = findViewById(R.id.login_button)

    private val firstName: EditText
        get() = findViewById(R.id.first_name)

    private val lastName: EditText
        get() = findViewById(R.id.last_name)

    private val email: EditText
        get() = findViewById(R.id.email)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

        // here we handle the Button onClick event
        loginButton.setOnClickListener {

            val firstName = firstName.text.toString().trim()
            val lastName = lastName.text.toString().trim()
            val email = email.text.toString()

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()){
                Toast.makeText(this, getString(R.string.add_text_validation), Toast.LENGTH_LONG).show()
            }
            else {
                val fullName = firstName.plus(" ").plus(lastName)

                Intent(this, HomePage::class.java)
                    .also { welcomeIntent ->
                        //Add the data
                        welcomeIntent.putExtra(FULL_NAME_KEY, fullName)
                        //Launch
                        startActivity(welcomeIntent)
                    }
                hideKeyboard()
                clearInputFields()
            }
        }
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")

    }



    private fun clearInputFields() {
        firstName.text.clear()
        lastName.text.clear()
        email.text.clear()
    }

    private fun hideKeyboard() {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }

    companion object {
        private const val TAG = "MainActivity"
        private const val DISCOUNT_CONFIRMATION_MESSAGE = "DISCOUNT_CONFIRMATION_MESSAGE"
        private const val DISCOUNT_CODE = "DISCOUNT_CODE"
    }
}