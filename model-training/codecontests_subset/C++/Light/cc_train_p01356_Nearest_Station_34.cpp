#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>
#include <utility>

#define show(x) cerr << #x << " = " << x << endl

using namespace std;
using ld = long double;
using ll = long long;

template <typename T>
ostream& operator<<(ostream& os, const vector<T>& v)
{
    os << "[";
    for (const auto& e : v) {
        os << e << ",";
    }
    os << "] ";
    os << "size = " << v.size() << endl;
    return os;
}

int main()
{
    ll n, m, a, b, p, q;
    cin >> n >> m >> a >> b >> p >> q;

    if (p + q > m) {
        cout << min(m, p + q - m) << endl;
    } else if (a == 1 and b == 1) {
        ll nearest = m / (p + q);
        if (m - (p + q) * nearest > (p + q) * (nearest + 1) - m) {
            nearest++;
        }
        if (nearest > n) {
            cout << m - (p + q) * n << endl;
        } else {
            cout << (p + q) * nearest - m << endl;
        }


    } else {
        ll k = 0;
        ll A = 1;
        ll B = 1;
        vector<ll> value;
        for (; p * A + q * B <= m and k < n; k++) {
            value.push_back(p * A + q * B);
            A *= a;
            B *= b;
        }
        n = k;
        const ll former = n / 2;
        const ll latter = n - former;
        const ll fmax = 1 << former;
        const ll lmax = 1 << latter;

        vector<ll> fsum(fmax, 0LL);
        for (ll i = 0; i < fmax; i++) {
            for (ll j = 0; j < former; j++) {
                if (i & (1LL << j)) {
                    fsum[i] = fsum[i - (1LL << j)] + value[j];
                    break;
                }
            }
        }
        vector<ll> lsum(lmax, 0LL);
        for (ll i = 0; i < lmax; i++) {
            for (ll j = 0; j < latter; j++) {
                if (i & (1LL << j)) {
                    lsum[i] = lsum[i - (1LL << j)] + value[former + j];
                    break;
                }
            }
        }
        sort(lsum.begin(), lsum.end());
        constexpr ll INF = 1LL << 60;
        ll error = INF;
        for (ll f : fsum) {
            const ll res = m - f;
            if (res <= 0) {
                error = min(error, -res);
            } else {
                auto it = lower_bound(lsum.begin(), lsum.end(), res);
                if (it != lsum.end()) {
                    error = min(error, abs(res - (*it)));
                }
                it--;
                error = min(error, abs(res - (*it)));
            }
        }
        cout << error << endl;
    }
    return 0;
}