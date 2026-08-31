#include <iostream>
#include <cstdio>
#include <complex>
#include <vector>

using namespace std;

typedef complex<double> P;

#define loop(i,a,b) for(int i=(a); i<(int)(b); i++)
#define rep(i,b) loop(i,0,b)

int main(){
    P ps[4];
    double x[4], y[4];
    while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",
                &x[0], &y[0], &x[1], &y[1], &x[2], &y[2], &x[3], &y[3]) != EOF){

        rep(i,4) ps[i] = P(x[i],y[i]);
        double ts[4];
        
        rep(i,4){
            P a = ps[i], b = ps[(i+1)%4], c = ps[(i+2)%4];
            a-=b; c-=b;
            double t = arg(a/c);
            ts[i]=t;
        }

        bool ok = true;
        rep(i,4){
            //cout << ts[i] << endl;
            if(ts[0]*ts[i]<0) ok = false;
        }

        if(ok) puts("YES");
        else puts("NO");
    }
}