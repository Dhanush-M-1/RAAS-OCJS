#include<iostream>
#include<vector>
#include<stdio.h>
using namespace std;

vector<pair<int,int> >vec;

int main(){
    double x[4],y[4];
    while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&x[0],&y[0],&x[1],&y[1],&x[2],&y[2],&x[3],&y[3])!=EOF){
        double a[4],b[4];
        for(int i=0;i<4;i++){
            a[i]=x[(i+1)%4]-x[i];
            b[i]=y[(i+1)%4]-y[i];
        }
        int suc=1;
        for(int i=0;i<4;i++){
            if((a[i]*b[(i+1)%4]-b[i]*a[(i+1)%4])*(a[(i+1)%4]*b[(i+2)%4]-b[(i+1)%4]*a[(i+2)%4])<0){
           //     cout<<(x[i]*y[(i+1)%4]-y[i]*x[(i+1)%4])<<"     "<<(x[(i+1)%4]*y[(i+2)%4]-y[(i+1)%4]*x[(i+2)%4])<<endl;
                suc=0;
                break;
            }
          //  cout<<(x[i]*y[(i+1)%4])<<"    "<<(y[i]*x[(i+1)%4])<<"     "<<(x[(i+1)%4]*y[(i+2)%4])<<"    "<<(y[(i+1)%4]*x[(i+2)%4])<<endl;
        }
        if(suc)
            cout<<"YES"<<endl;
        else
            cout<<"NO"<<endl;
    }
    return 0;
}