#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

template <class T>
std::vector<T> vec(int len, T elem) { return std::vector<T>(len, elem); }

constexpr int MOD = 10000;

void decr(std::string& s) {
    std::reverse(s.begin(), s.end());
    for (auto& c : s) {
        if (c != '0') {
            --c;
            break;
        } else {
            c = '9';
        }
    }
    std::reverse(s.begin(), s.end());
}

int calc(std::string s, int m) {
    std::reverse(s.begin(), s.end());

    auto dp = vec(2, vec(2, vec(10, vec(m, 0))));
    {
        char c = s.front();
        int dmax = c - '0';

        for (int ch = 0; ch <= 1; ++ch) {
            for (int d = 0; d <= 9; ++d) {
                dp[0][ch][d][d % m] = 1;
                if (d <= dmax) {
                    dp[1][ch][d][d % m] = 1;
                }
            }
        }

        s.erase(s.begin());
    }

    int ret = 0, ten = 10 % m;
    bool first = true;
    for (char c : s) {
        for (int ch = 0; ch <= 1; ++ch) {
            if (first && ch == 1) continue;
            for (int d = 1; d <= 9; ++d) {
                (ret += dp[0][ch][d][0]) %= MOD;
            }
        }
        first = false;

        int dmax = c - '0';
        auto ndp = vec(2, vec(2, vec(10, vec(m, 0))));

        for (int ch = 0; ch <= 1; ++ch) {
            for (int pd = 0; pd <= 9; ++pd) {
                for (int r = 0; r < m; ++r) {
                    int lpval = dp[0][ch][pd][r],
                        tpval = dp[1][ch][pd][r];

                    for (int d = 0; d <= 9; ++d) {
                        if ((ch == 0 && pd >= d) || (ch == 1 && pd <= d)) continue;

                        int nr = (r + ten * d) % m;

                        // loose -> loose
                        (ndp[0][1 - ch][d][nr] += lpval) %= MOD;

                        // loose -> tight
                        if (d < dmax) {
                            (ndp[1][1 - ch][d][nr] += lpval) %= MOD;
                        }

                        // tight -> tight
                        if (d == dmax) {
                            (ndp[1][1 - ch][d][nr] += tpval) %= MOD;
                        }
                    }
                }
            }
        }
        dp = ndp;

        (ten *= 10) %= m;
    }

    for (int ch = 0; ch <= 1; ++ch) {
        if (first && ch == 1) continue;
        for (int d = 1; d <= 9; ++d) {
            (ret += dp[1][ch][d][0]) %= MOD;
        }
    }

    return ret;
}

void solve() {
    std::string a, b;
    int m;
    std::cin >> a >> b >> m;
    decr(a);
    std::cout << (calc(b, m) - calc(a, m) + MOD) % MOD << "\n";
}

int main() {
    std::cin.tie(nullptr);
    std::ios::sync_with_stdio(false);

    solve();

    return 0;
}

