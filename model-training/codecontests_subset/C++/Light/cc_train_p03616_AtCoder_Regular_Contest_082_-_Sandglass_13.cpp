#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int K = 1e5+9;
ll r[K];
inline ll read() {
    ll s = 1, a = 0; char ch = getchar();
    while (ch < '0' || ch > '9') {if (ch == '-') s = -1; ch = getchar();}
    while (ch >= '0' && ch <= '9') {a = a * 10 + ch - '0'; ch = getchar();}
    return s * a;
}
inline void turn(ll &v, ll x) {
    if (v < 0) v = 0;
    if (v > x) v = x;
}
int main() {
    ll x = read(), k = read();
    for (int i = 1; i <= k; i++) r[i] = read();
    ll q = read();
    ll low = 0, mid = 0, upp = x;
    int i = 1, sign = -1;
    while (q--) {
        ll t = read(), a = read();
        while (i <= k && r[i] <= t) {
            ll dta = (r[i] - r[i - 1]) * sign;
            low += dta, upp += dta, mid += dta;
            turn(low, x), turn(upp, x);
            i++, sign *= -1;
        }
        ll res = a + mid;
        ll dta = (t - r[i - 1]) * sign;
        if (res < low) res = low;
        if (res > upp) res = upp;
        res += dta, turn(res, x);
        printf("%lld\n", res);
    }
    return 0;
}