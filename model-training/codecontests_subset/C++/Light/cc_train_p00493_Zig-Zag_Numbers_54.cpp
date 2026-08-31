#include <iostream>
#include <cstdio>
#include <cmath>
#include <vector>
#include <map>
#include <stack>
#include <queue>
#include <algorithm>
#include <set>
#include <cstring>

#define FOR(i,a,b) for(int i=(a);i<(b);i++)
#define REP(i,j) FOR(i,0,j)
#define mp std::make_pair

const int INF = 1 << 24;
const int dx[8] = {0, 0, 1, -1, 1, 1, -1, -1}, dy[8] = {1, -1, 0, 0, 1, -1, 1, -1};

typedef unsigned long long ull;
typedef std::pair<int,int> P;

std::string A, B;
int M;

int dp[501][501][10][3][2];

bool zigzag(const std::string &s){
    for(int i=0;i+2<s.size();i++){
        if(s[i+1]-s[i] > 0 && s[i+2]-s[i+1] < 0);
        else if(s[i+1]-s[i] < 0 && s[i+2]-s[i+1] > 0);
        else{return false;}
    }
    return true;
}

int rec(std::string &s, int d, int r, int prev_n, int updown, int nine){
    if(d == s.size()){return r == 0;}
    if(dp[d][r][prev_n][updown][nine] != -1){
        return dp[d][r][prev_n][updown][nine];
    }
    
    int n = s[d]-'0', res = 0;

    for(int i=0;i<=(nine?9:n);i++){
        // 増加しない
        if(updown == 0 && prev_n <= i)continue;
        // 減少しない
        if(updown == 1 && prev_n >= i)continue;
        // 一つ前が0でない または 0以外の先頭桁が決まっていて，次がその桁の数と同じ(増加も減少もしない)
        if(updown == 2 && prev_n && prev_n == i)continue;

        int dd;
        if(updown == 2){
            if(prev_n == 0){ // 0でいく
                dd = 2;
            }else if(prev_n > i){ // 減少する
                dd = 1;
            }else { // 増加する
                dd = 0;
            }
        } else dd = !updown; // 反転

        res = (res + rec(s, d+1, (r*10+i)%M, i, dd, nine|(i!=n))) % 10000;
    }
    
    return dp[d][r][prev_n][updown][nine] = res;
}

int main(){
    std::cin >> A >> B;
    std::cin >> M;

    int an, bn;

    memset(dp, -1, sizeof(dp));
    bn = rec(B, 0, 0, 0, 2, 0);

    memset(dp, -1, sizeof(dp));
    an = rec(A, 0, 0, 0, 2, 0);

    std::cout << (bn - an + 10000 + zigzag(A)) % 10000 << std::endl;
}