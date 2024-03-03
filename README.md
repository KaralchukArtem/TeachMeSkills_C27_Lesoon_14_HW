TeachMeSkills_C27_Lesoon_14_HW

The application allows the user to parse .txt files with document numbers. 
The application parses each line in the document and checks the line value.

If the value matches the following rules:
1. The document number must consist of 15 characters;
2. Begins with the sequence of a document or contract;
3. And contains only letters or numbers without any other characters (regular expression check),
4. then the application writes the valid document numbers into the following .txt files: validDocument.txt or validContract.txt.

If the value does not comply with the rules specified above, the application writes this value to the invalidDocumentNumber.txt files and adds
the reason why this value is invalid.

During file analysis, if an error occurs, a recording occurs in error_log.txt and execution_log.txt.
1. error_log.txt contains all the errors that the user may encounter. (for example: incorrect file path, etc.).
2. execution_log.txt contains all error_log.txt errors in the application from the very beginning, supplementing the file with StackTrace + Date Time lines.
