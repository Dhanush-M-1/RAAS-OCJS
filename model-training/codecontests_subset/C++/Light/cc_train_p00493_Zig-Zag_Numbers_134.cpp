#include <bits/stdc++.h>
using namespace std;

constexpr int MOD = 10000;

int dp[505][2][3][10][500]; // dp[桁][未満フラグ][谷:0/山:1/未定:2][直前の数字][余り]

int solve(string x, int m, int f=0){
    int n = x.size();
    memset(dp, 0, sizeof(dp));
    dp[0][0][2][0][0] = 1;
    for(int i=0;i<n;i++){
        int D = x[i]-'0';
        for(int j=0;j<2;j++){
            for(int k=0;k<3;k++){
                for(int l=0;l<10;l++){
                    for(int d=0;d<=(j?9:D);d++){
                        if((k==0 && l>=d) || (k==1 && l<=d) || (k==2 && l>0 && l==d)) continue;
                        for(int r=0;r<m;r++){
                            dp[i+1][j||(d<D)][((k==2&&l==0)?2:l<d)][d][(r*10+d)%m] += dp[i][j][k][l][r];
                            dp[i+1][j||(d<D)][((k==2&&l==0)?2:l<d)][d][(r*10+d)%m] %= MOD;
                        }
                    }
                }
            }
        }
    }
    int res = 0;
    for(int i=(f?1:0);i<2;i++)for(int j=0;j<3;j++)for(int k=0;k<=9;k++){
        res += dp[n][i][j][k][0];
        res %= MOD;
    }
    return res;
}

int main(){
    string a, b;
    int m;
    cin >> a >> b >> m;
    cout << (solve(b,m) - solve(a,m,1) + MOD)%MOD << endl;
    return 0;
}

