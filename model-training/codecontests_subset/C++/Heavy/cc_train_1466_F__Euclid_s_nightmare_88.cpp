#include <bits/stdc++.h>
using namespace std;

template <int mod> struct Modular {
    int value;
    Modular(int64_t v = 0) { value = v % mod; if (value < 0) value += mod; }

    Modular& operator+=(Modular const& b) { value += b.value; if (value >= mod) value -= mod; return *this; }
    Modular& operator-=(Modular const& b) { value -= b.value; if (value < 0) value += mod; return *this; }
    Modular& operator*=(Modular const& b) { value = (int64_t) value * b.value % mod; return *this; }
    Modular& operator/=(Modular const& b) { return *this *= inverse(b); }

    friend Modular power(Modular a, int64_t e) {
        Modular res = 1; for (; e; e >>= 1, a *= a) if (e & 1) res *= a;
        return res;
    }
    friend Modular inverse(Modular a) { return power(a, mod - 2); }

    friend Modular operator+(Modular a, Modular const b) { return a += b; }
    friend Modular operator-(Modular a, Modular const b) { return a -= b; }
    friend Modular operator-(Modular const a) { return 0 - a; }
    friend Modular operator*(Modular a, Modular const b) { return a *= b; }
    friend Modular operator/(Modular a, Modular const b) { return a /= b; }

    friend bool operator==(Modular const& a, Modular const& b) { return a.value == b.value; }
    friend bool operator!=(Modular const& a, Modular const& b) { return a.value != b.value; }

    friend ostream& operator<<(ostream& os, Modular const& a) { return os << a.value; }
};

using Mint = Modular<int(1e9) + 7>;

struct DSU {
    vector<int> p;
    DSU(int n) : p(n) {
        iota(p.begin(), p.end(), 0);
    }
    int find(int i) {
        if (i == p[i]) return i;
        return p[i] = find(p[i]);
    }
    bool merge(int x, int y) {
        x = find(x), y = find(y);
        if (x == y) return false;
        p[x] = y;
        return true;
    }
};

int main() {
    int n, m;
    cin >> n >> m;

    Mint ans = 1;
    vector<int> a;
    DSU dsu(m + 2);
    for (int i = 1; i <= n; i++) {
        int k;
        cin >> k;
        if (k == 1) {
            int x;
            cin >> x;
            if (dsu.merge(x, m + 1)) {
                a.push_back(i);
                ans *= 2;
            }
        } else {
            int x, y;
            cin >> x >> y;
            if (dsu.merge(x, y)) {
                a.push_back(i);
                ans *= 2;
            }
        }
    }
    cout << ans << ' ' << a.size() << '\n';
    for (int i = 0; i < a.size(); i++) {
        cout << a[i] << " \n"[i == a.size() - 1];
    }
}