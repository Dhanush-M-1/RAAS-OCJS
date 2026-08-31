#include <bits/stdc++.h>
#define N 10000
using namespace std;

string a,b;
long long m;
long long dp[512][4][4][16][512] = {0};

long long solve(string &s);

int main(){
    cin >> a >> b >> m;
    reverse(a.begin(),a.end());
    int id = 0;
    while(a[id]=='0')a[id++] = '9';
    --a[id];
    if(a[a.size()-1] == '0')a.pop_back();
    reverse(a.begin(),a.end());
    cout << (solve(b)- solve(a) + N) % N << endl;
    return 0;
}

long long solve(string &s){
    long long ans = 0,ssize = s.size();
    if(ssize == 0)return 0;
    if(ssize == 1)return ((s[0] - '0')/m + N) % N;
    //last digit
    ans = (-9/m + N) % N;
    for(int i = 0;i <= ssize;++i)
        for(int j= 0;j <2;++j)
            for(int k= 0;k < 2;++k)
                for(int l = 0;l < 10;++l)
                    for(int o = 0;o < m;++o)
                        dp[i][j][k][l][o] = 0;
    //index
    for(int i = 0;i < ssize;++i)
        //next num
        for(int j = 0;j < 10;++j){
            if(j != 0 && (i != 0 || s[i] - '0' >= j))
                for(int k = 0;k < 2;++k)
                    ++dp[i+1][!(i==0&&s[i] - '0' ==j)][k][j][j%m] %= N;
            //before num (down)
            for(int k = 0;k < j;++k)
                if(j != k)
                    //mod m
                    for(int l = 0;l < m;++l){
                        // less than:1
                        if(j < s[i] - '0'){
                            dp[i+1][1][1][j][(l * 10+j)%m] += (dp[i][1][0][k][l] + dp[i][0][0][k][l]) % N;
                            dp[i+1][1][1][j][(l * 10+j)%m] %= N;
                        }
                        //  equal
                        else if(j == s[i] - '0'){
                            dp[i+1][1][1][j][(l * 10+j)%m] += dp[i][1][0][k][l];
                            dp[i+1][1][1][j][(l * 10+j)%m] %= N;
                            dp[i+1][0][1][j][(l * 10+j)%m] += dp[i][0][0][k][l];
                            dp[i+1][0][1][j][(l * 10+j)%m] %= N;
                        }
                        else {
                            dp[i+1][1][1][j][(l * 10+j)%m] += dp[i][1][0][k][l];
                            dp[i+1][1][1][j][(l * 10+j)%m] %= N;
                        }
                    }
            //before num (up)
            for(int k = j + 1;k < 10;++k)
                if(j != k)
                    //mod m
                    for(int l = 0;l < m;++l){
                        // less than:1
                        if(j < s[i] - '0'){
                            dp[i+1][1][0][j][(l * 10 +j)%m] += (dp[i][1][1][k][l] + dp[i][0][1][k][l]) % N;
                            dp[i+1][1][0][j][(l * 10 +j)%m] %= N;
                        }
                            //  equal
                        else if(j == s[i] - '0'){
                            dp[i+1][1][0][j][(l * 10 +j)%m] += dp[i][1][1][k][l];
                            dp[i+1][1][0][j][(l * 10 +j)%m] %= N;
                            dp[i+1][0][0][j][(l * 10 +j)%m] += dp[i][0][1][k][l];
                            dp[i+1][0][0][j][(l * 10 +j)%m] %= N;
                        }
                        else {
                            dp[i+1][1][0][j][(l * 10 +j)%m] += dp[i][1][1][k][l];
                            dp[i+1][1][0][j][(l * 10 +j)%m] %= N;
                        }
                    }

        }
    for(int i = 0;i < 2;++i)
        for(int j = 0;j < 2;++j)
            for(int k = 0;k < 10;++k){
                ans += dp[ssize][i][j][k][0];
                ans %= N;
            }
    return ans % N;
}
