#include<iostream>
#include<algorithm>
#include<string>
#include<vector>
#include<bitset>
#include<cmath>
#include<cstdio>
using namespace std;
double dis(double xa,double ya,double xb,double yb){
    return sqrt((xa-xb)*(xa-xb)+(ya-yb)*(ya-yb));
}
double S(double a,double b,double c){
    double s=(a+b+c)/2;
    return sqrt(s*(s-a)*(s-b)*(s-c));
}
bool in(double xa,double ya,double xb,
        double yb,double xc,double yc,double xp,double yp){
    double AB,BC,CA,AP,BP,CP;
    AB=dis(xa,ya,xb,yb);
    BC=dis(xb,yb,xc,yc);
    CA=dis(xc,yc,xa,ya);
    AP=dis(xa,ya,xp,yp);
    BP=dis(xb,yb,xp,yp);
    CP=dis(xc,yc,xp,yp);
    double ABC,ABP,BCP,CAP;
    ABC=S(AB,BC,CA);ABP=S(AB,AP,BP);
    BCP=S(BC,BP,CP);CAP=S(CA,CP,AP);

    double dif=ABC-ABP-BCP-CAP;
    if(dif<=0.0001&&dif>=-0.0001)return true;
    else return false;
}
int main(){
    double x[4],y[4];
    while(scanf("%lf,%lf",&x[0],&y[0])!=EOF){
        for(int i=1;i<4;i++)scanf(",%lf,%lf",&x[i],&y[i]);
        bool F=false;
        for(int i=0;i<4;i++){
            int a=(i+1)%4,b=(i+2)%4,c=(i+3)%4;
            F|=in(x[i],y[i],x[a],y[a],x[b],y[b],x[c],y[c]);
        }

        if(!F)cout<<"YES"<<endl;
        else cout<<"NO"<<endl;
    }
}