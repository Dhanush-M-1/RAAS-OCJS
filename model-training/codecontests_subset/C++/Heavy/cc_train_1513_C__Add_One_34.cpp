#include <bits/stdc++.h>
using namespace std;

template<typename A, typename B> ostream& operator<<(ostream &os, const pair<A, B> &p) { return os << '(' << p.first << ", " << p.second << ')'; } template<typename T_container, typename T = typename enable_if<!is_same<T_container, string>::value, typename T_container::value_type>::type> ostream& operator<<(ostream &os, const T_container &v) { os << '{'; string sep; for (const T &x : v) os << sep << x, sep = ", "; return os << '}'; }
void dbg_out() { cerr << endl; }
template<typename Head, typename... Tail> void dbg_out(Head H, Tail... T) { cerr << "  " << H; dbg_out(T...); }

#ifdef SMIE
#define debug(args...) cerr << "(" << #args << "):", dbg_out(args)
#else
#define debug(args...)
#endif

const int mxm = 2e5 + 20;
const int MOD = 1e9 + 7;

int one[mxm], zero[mxm], dp[mxm];

int main() {
    ios_base::sync_with_stdio(false);   //DON'T mix C and C++ I/O
    //cin.tie(NULL);                      //DON'T use for interactive problem

    dp[0] = 1, zero[0] = 1;
    for (int i = 1; i < mxm; i++) {
        if (i >= 10) {
            one[i] += zero[i - 10];
            one[i] %= MOD;
            zero[i] += zero[i - 10];
            zero[i] %= MOD;
        }
        if (i >= 9) {
            one[i] += one[i - 9];
            one[i] %= MOD;
            zero[i] += one[i - 9];
            zero[i] %= MOD;
        }
        dp[i] = (dp[i - 1] + one[i]) % MOD;
    }

    int tests = 1, testno = 0;
    cin >> tests;
    while (tests--) {
        int n, m;

        cin >> n >> m;

        int ans = 0;
        while (n > 0) {
            ans = (ans + dp[n % 10 + m]) % MOD;
            n /= 10;
        }

        cout << ans << '\n';
    }
}

