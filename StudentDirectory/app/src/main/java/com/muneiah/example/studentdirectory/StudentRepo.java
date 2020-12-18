package com.muneiah.example.studentdirectory;

        import android.app.Application;
        import android.os.AsyncTask;

        import androidx.lifecycle.LiveData;

        import java.util.List;

public class StudentRepo {
    LiveData<List<StudentEntity>> listLiveData;
    StudentDataBase studentDataBase;

    public StudentRepo(Application application) {
        studentDataBase=StudentDataBase.getInstance(application);
        listLiveData=studentDataBase.studentDAO().retrivetLiveData();

    }

    public class AsyncTaskForInsert extends AsyncTask<StudentEntity,Void,Void>{

        @Override
        protected Void doInBackground(StudentEntity... studentEntities) {
            studentDataBase.studentDAO().insertData(studentEntities[0]);
            return null;
        }
    }

    public class AsyncTaskForUpdate extends AsyncTask<StudentEntity,Void,Void>{

        @Override
        protected Void doInBackground(StudentEntity... studentEntities) {
            studentDataBase.studentDAO().updateData(studentEntities[0]);
            return null;
        }
    }
    public class AsyncTaskForDelete extends AsyncTask<StudentEntity,Void,Void>{

        @Override
        protected Void doInBackground(StudentEntity... studentEntities) {
            studentDataBase.studentDAO().deleteData(studentEntities[0]);
            return null;
        }
    }
    public LiveData<List<StudentEntity>> listLiveData(){
        return listLiveData;
    }
    public void insert(StudentEntity entity){
        new AsyncTaskForInsert().execute(entity);
    }
    public void update(StudentEntity entity){
        new AsyncTaskForUpdate().execute(entity);
    }
    public void delete(StudentEntity entity){
        new AsyncTaskForDelete().execute(entity);
    }
}
