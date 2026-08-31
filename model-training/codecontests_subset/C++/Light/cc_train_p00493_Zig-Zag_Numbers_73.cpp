#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

string minusone(string s) {
    for (int i = s.size() - 1; i >= 0; i--) {
        if (s[i] != '0') {
            s[i] = s[i] - 1;
            break;
        } else {
            s[i] = '9';
        }
    }

    return s.substr(s[0] == '0' ? 1 : 0);
}

int solve(string limit, int mod) {
    //mod　今の数-1　厳しくない？厳しい？　減少？増加？未確定？
    vector<vector<vector<vector<int>>>> dp
            (mod, vector<vector<vector<int>>>(
                    11, vector<vector<int>>(
                            2, vector<int>(
                                    3))));
    dp[0][0][true][2] = 1;

    for (int index = 0; index < limit.size(); index++) {
        vector<vector<vector<vector<int>>>> after
                (mod, vector<vector<vector<int>>>(
                        11, vector<vector<int>>(
                                2, vector<int>(
                                        3))));

        for (int backnum = 0; backnum <= 10; backnum++) {
            for (int nownum = backnum == 0 ? 0 : 1; nownum <= 10; nownum++) {
                bool up = backnum < nownum;

                for (int backmod = 0; backmod < mod; backmod++) {
                    int nowmod = (backmod * 10 + max(0, nownum - 1)) % mod;

                    if (backnum == 0) { // no num ->
                        if (nownum == 1) continue; // zero start

                        /* unknown -> unknown */
                        if (index == 0) { // tight ->
                            if (nownum - 1 == limit[index] - '0') { // -> tight
                                after[nowmod][nownum][true][2] += dp[backmod][backnum][true][2];
                            } else if (nownum - 1 < limit[index] - '0') { // -> not tight
                                after[nowmod][nownum][false][2] += dp[backmod][backnum][true][2];
                            }
                        }

                        /* not tight -> not tight */
                        after[nowmod][nownum][false][2] += dp[backmod][backnum][false][2];
                    } else { // num -> num
                        if (nownum == backnum) continue;

                        if (nownum - 1 == limit[index] - '0') { // tight -> tight
                            after[nowmod][nownum][true][up] += dp[backmod][backnum][true][!up];
                            after[nowmod][nownum][true][up] += dp[backmod][backnum][true][2];
                        } else if (nownum - 1 < limit[index] - '0') { // tight -> not tight
                            after[nowmod][nownum][false][up] += dp[backmod][backnum][true][!up];
                            after[nowmod][nownum][false][up] += dp[backmod][backnum][true][2];
                        }

                        /* not tight -> not tight */
                        after[nowmod][nownum][false][up] += dp[backmod][backnum][false][!up];
                        after[nowmod][nownum][false][up] += dp[backmod][backnum][false][2];
                    }

                    for (int tmp = 0; tmp < 2; tmp++) {
                        after[nowmod][nownum][true][tmp] %= 10000;
                        after[nowmod][nownum][false][tmp] %= 10000;
                    }
                }
            }
        }

        dp = after;
    }

    int ret = 0;
    for (int lastnum = 0; lastnum <= 9; lastnum++) {
        for (int tight = 0; tight < 2; tight++) {
            for (int updown = 0; updown < 3; updown++) {
                int x = dp[0][lastnum + 1][tight][updown];
                if (x > 0) {
                    ret += x;
                }
                ret %= 10000;
            }
        }
    }
    return ret;
}

int main() {
    string a, b;
    int mod;
    cin >> a >> b >> mod;

    int ret = solve(b, mod) - solve(minusone(a), mod);
    cout << (ret + 10000) % 10000 << endl;
}

