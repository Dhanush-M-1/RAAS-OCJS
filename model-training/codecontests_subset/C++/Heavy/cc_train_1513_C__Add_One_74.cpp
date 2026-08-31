#include <bits/stdc++.h>
#define PI 3.14159265359
#define lp(i, n) for (size_t i = 0; i < n; i++)
typedef long long ll;
typedef long double ld;

using namespace std;

const char nl = '\n';

const ll MOD = (ll)1e9 + 7;

vector<ll> lenDigit(int d, int m) {
    ll occ[10] = {0};
    occ[d] = 1;
    vector<ll> v;
    v.push_back(1);
    while (m--) {
        ll nine = occ[9];
        for (int i = 9; i > 0; i--) {
            occ[i] = occ[i - 1];
        }
        occ[0] = nine;
        occ[1] += nine;
        occ[1] %= MOD;
        v.push_back((v.back() + nine) % MOD);
    }
    return v;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t;
    cin >> t;
    vector<ll> res[10];
    for (int i = 0; i < 10; i++) {
        res[i] = lenDigit(i, 2 * (int)1e5);
    }
    while (t--) {
        ll n;
        int m;
        cin >> n >> m;
        ll ret = 0;
        while (n) {
            ret += res[n % 10][m];
            ret %= MOD;
            n /= 10;
        }
        cout << ret << nl;
    }
    return 0;
}
