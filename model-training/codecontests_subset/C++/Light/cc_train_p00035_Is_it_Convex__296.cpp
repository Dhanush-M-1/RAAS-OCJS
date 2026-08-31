#include <iostream>
#include <string>
#include <algorithm>
#include <cstdio>
#include <vector>
#include <cmath>
#include <stack>
#include <map>
#include <sstream>
#define REP(i, n) for(int i = 0;i < n;i++)
#define REPR(i, n) for(int i = n;i >= 0;i--)
using namespace std;

bool cross(double x[], double y[]){
    REP(i, 4){
        double v1, v2, v3;
        v1 = (x[(i)%4]-x[(i+1)%4])*(y[(i)%4]-y[(i+3)%4]) - (y[(i)%4]-y[(i+1)%4])*(x[(i)%4]-x[(i+3)%4]);
        v2 = (x[(i+1)%4]-x[(i+2)%4])*(y[(i+1)%4]-y[(i+4)%4]) - (y[(i+1)%4]-y[(i+2)%4])*(x[(i+1)%4]-x[(i+4)%4]);
        v3 = (x[(i+2)%4]-x[(i+3)%4])*(y[(i+2)%4]-y[(i+5)%4]) - (y[(i+2)%4]-y[(i+3)%4])*(x[(i+2)%4]-x[(i+5)%4]);
        if ( !(v1 < 0 && v2 < 0 && v3 < 0) && !(v1 > 0 && v2 > 0 && v3 > 0) ) {
            return false;
        }
    }
    return true;
}

int main(){
    double x[4], y[4];
    while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf"
        ,&x[0],&y[0],&x[1],&y[1],&x[2],&y[2],&x[3],&y[3]) != EOF) {
        if (cross(x, y)) cout << "YES" << endl;
        else cout << "NO" << endl;
    }
}
