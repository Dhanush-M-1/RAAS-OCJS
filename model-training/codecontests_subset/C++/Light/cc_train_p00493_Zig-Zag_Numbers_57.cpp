#include <iostream>
#include <algorithm>
#include <string>
#include <cstring>

const int MOD = 10000;

std::string a, b; // <=1e500
int m; // <=500
int dp[2][2][510][510][15][3];

char Ch(int i) {
    return '0' + i;
}

int func(bool lower, bool upper, int mod, int idx, int prev, int stat) {// stat: 0: zero, 1: ?¢???????, 2: ??????
    if(idx >= a.size()) {
        if(lower && upper && mod % m == 0) {
            return true;
        }else {
            return false;
        }
    }

    if(dp[lower][upper][mod][idx][prev][stat] != -1) {
        return dp[lower][upper][mod][idx][prev][stat];
    }

    mod *= 10;

    int ans = 0;
    for(int i = 0; i <= 9; ++i) {
        int nm = (mod + i) % m;
        char c = '0' + i;
        bool newLower;
        bool newUpper;
        int newStat;

        if(lower) {
            newLower = lower;
        }else {
            if(b[idx] < c) {
                continue;
            }

            if(b[idx] == c && idx != a.size() - 1) {
                newLower = false;
            }else {
                newLower = true;
            }
        }

        if(upper) {
            newUpper = true;
        }else {
            if(a[idx] > c) {
                continue;
            }

            if(a[idx] == c && idx != a.size() - 1) {
                newUpper = false;
            }else {
                newUpper = true;
            }
        }

        if(stat == 0) {
            if(prev == 0) {
                newStat = 0;
            }else if(prev > i){
                newStat = 1;
            }else if(prev < i) {
                newStat = 2;
            }else {
                continue;
            }
        }else if(stat == 1) {
            if(i <= prev) {
                continue;
            }

            newStat = 2;
        }else {
            if(i >= prev) {
                continue;
            }

            newStat = 1;
        }

        ans += func(newLower, newUpper, nm, idx + 1, i, newStat);
        ans %= MOD;
    }

    return dp[lower][upper][mod / 10][idx][prev][stat] = ans;
}

int main() {
    std::cin >> a >> b >> m;

    while(a.size() < b.size()) {
        a = std::string("0") + a;
    }

    memset(dp, -1, sizeof(dp));

    std::cout << func(false, false, 0, 0, 0, 0) << std::endl;
}