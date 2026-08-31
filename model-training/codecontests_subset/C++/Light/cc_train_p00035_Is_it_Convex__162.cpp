#include<iostream>
#include<string>
#include<algorithm>
#include<vector>
#include<cstdio>
#include<cstring>
#include<complex>
using namespace std;

#define rep(i,n) for(int i=0;i<n;i++)
#define REP(n) rep(i,n)
#define all(n) n.begin(),n.end()

// vector(geometric) definition
typedef complex<double> cdouble;
// define with polor
const int N = 4;

int main()
{
    cdouble v[N + 2];
    double x[N], y[N];
    char t;
    while(cin>>x[0]>>t>>y[0]>>t >>x[1]>>t>>y[1]>>t >>x[2]>>t>>y[2]>>t
            >>x[3]>>t>>y[3])
    {
        REP(N) v[i] = cdouble(x[i], y[i]);
        v[N] = v[0];
        v[N + 1] = v[1];
        double ang[N + 2];
        //REP(6)cout << v[i] << endl;

        for(int i = 1; i <= 4; i++)
        {
            ang[i] = fmod( arg(v[i - 1] - v[i]) - arg(v[i + 1] - v[i]) + (10 * M_PI), M_PI * 2); 
            //cout << i << "th angle = " << ang[i] << endl;
        }
        int ans = 1;
        if(ang[1] > M_PI) {REP(4)if(ang[i + 1] < M_PI) ans = 0; }
        else {REP(4)if(ang[i + 1] > M_PI) ans = 0;}
        if(ans) cout << "YES" << endl;
        else cout << "NO" << endl;
    }
    return 0;
}