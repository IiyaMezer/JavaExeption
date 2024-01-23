public class Person {
    private String _name;
    private String _lastName;
    private String _surName;
    private String _gender;
    private String _phoneNumber;
    private String _birthDate;

    public Person(){}

    @Override
    public String toString(){
        return _surName + " " +
                _name + " " +
                _lastName + " " +
                _birthDate + " " +
                _phoneNumber + " " +
                _gender;
    }

    public void setName(String name){
        if(this._name ==null){
            this._name = name;
        } else throw new RuntimeException("Имя уже указано, проверьте ввод.");
    }

    public void setSurName(String surName){
        if(this._surName ==null){
            this._surName = surName;
        } else throw new RuntimeException("Фамилия уже указана, проверьте ввод.");
    }
    public void setLastName(String lastName){
        if(this._lastName ==null){
            this._lastName = lastName;
        } else throw new RuntimeException("Отчество уже указано, проверьте ввод.");
    }

    public void setGender(String gender) {
        if (this._gender == null) {
            this._gender = gender;
        } else throw new RuntimeException("Пол уже указан, проверьте ввод.");
    }

    public void setBirthDate(String birthDate) {
        if (this._birthDate == null) {
            this._birthDate = birthDate;
        } else throw new RuntimeException("Дата рождения уже указана, проверьте ввод.");
    }

    public void setPhoneNumber(String phoneNumber) {
        if (this._phoneNumber == null) {
            this._phoneNumber = phoneNumber;
        } else throw new RuntimeException("Номер телефона уже указан, проверьте ввод.");
    }
    public String getName() {
        return _name;
    }

    public String getLastName() {
        return _lastName;
    }

    public String getSurname() {
        return _surName;
    }

    public String getGender() {
        return _gender;
    }

    public String getPhoneNumber() {
        return _phoneNumber;
    }

    public String getBirthDate() {return _birthDate;
    }
}
