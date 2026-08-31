#include <bits/stdc++.h>
#define REP(i,n) for(int i=0; i<(int)(n); ++i)

using namespace std;
const int MOD = 10000;
inline void add(unsigned short& x, unsigned short y){ x = (x + y) % MOD; }

int calc(string s, int M){
    int N = s.size();
    vector<int> a(N);
    REP(i, N) a[i] = s[i] - '0';
    // [i-th][mod][last][zeros, first, down, up][low or not]
    static unsigned short dp[502][502][10][4][2] = {};
    memset(dp, 0, sizeof(dp));
    dp[0][0][0][0][0] = 1;
    unsigned short pow_10[502] = {};
    pow_10[0] = 1;
    for(int i = 1; i < N; i++){
        pow_10[i] = pow_10[i - 1] * 10 % M;
    }
    for(int i = 0; i < N; i++)
    for(int mod = 0; mod < M; mod++)
    for(int last = 0; last < 10; last++)
    for(int type = 0; type < 4; type++)
    for(int islow = 0; islow < 2; islow++)
    for(int next = 0; next < 10; next++){
        const int& cur = dp[i][mod][last][type][islow];
        if(cur == 0) continue;
        if(!islow && a[i] < next) continue;
        int nlow = islow || (next < a[i]);
        int nmod = (mod + next * pow_10[N - 1 - i]) % M;
        if(type == 0){
            int ntype = (next == 0 ? 0 : 1);
            add(dp[i + 1][nmod][next][ntype][nlow], cur);
        }else if(type == 1 && last != next){
            int ntype = (last < next ? 3 : 2);
            add(dp[i + 1][nmod][next][ntype][nlow], cur);
        }else if(type == 2 && last < next){
            int ntype = 3;
            add(dp[i + 1][nmod][next][ntype][nlow], cur);
        }else if(type == 3 && last > next){
            int ntype = 2;
            add(dp[i + 1][nmod][next][ntype][nlow], cur);
        }
    }
    unsigned short ans = 0;
    for(int last = 0; last < 10; last++)
    for(int type = 0; type < 4; type++)
    for(int islow = 0; islow < 2; islow++){
        add(ans, dp[N][0][last][type][islow]);
    }
    return ans;
}
string dec(string s){
    for(int i = s.size() - 1; i >= 0; i--){
        if(s[i] != '0'){
            s[i] --;
            break;
        }else{
            s[i] = '9';
        }
    }
    return s;
}

int main(){
    string A, B;
    while(cin >> A >> B){
        int M;
        cin >> M;
        cout << (calc(B, M) - calc(dec(A), M) + MOD) % MOD << endl;
    }
    return 0;
}