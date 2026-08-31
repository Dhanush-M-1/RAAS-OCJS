#include<cstdio>
#include<cmath>
int main(){
    double x[4],y[4];
    while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf\n",&x[0],&y[0],&x[1],&y[1],&x[2],&y[2],&x[3],&y[3])!=-1){
        bool is=true;
        double radsum=0;
        for(int i=0;i<4;i++){
            int a=i,b=(i+1)%4,c=(i+2)%4;
            radsum+=acos((pow(x[a]-x[b],2)+pow(y[a]-y[b],2)+pow(x[b]-x[c],2)+pow(y[b]-y[c],2)-pow(x[c]-x[a],2)-pow(y[c]-y[a],2))/(2*sqrt(pow(x[a]-x[b],2)+pow(y[a]-y[b],2))*sqrt(pow(x[b]-x[c],2)+pow(y[b]-y[c],2))));
        }
        if(radsum<M_PI*2)printf("NO\n");
        else printf("YES\n");
    }
}
