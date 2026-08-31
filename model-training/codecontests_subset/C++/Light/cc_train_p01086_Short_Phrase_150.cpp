#include <bits/stdc++.h>
using namespace std;
#define rep(i, n) for (int i = 0; i < int(n); ++i)

int solve(int n, const vector<string>& w) {
    vector<int> five(n + 1, -1), seven(n + 1, -1);
    rep(i, n) {
        for (int j = i, l = 0; j < n && l < 7; ++j) {
            l += w[j].size();
            if (l == 5) five[i] = j;
            if (l == 7) seven[i] = j;
        }
    }
    rep (i, n) {
        int k = i;
        bool ok = true;
        rep(j, 5) {
            k = (j == 0 || j == 2 ? five[k] : seven[k]) + 1;
            if (k == 0) {
                ok = false;
                break;
            }
        }
        if (ok) return i + 1;
    }
    return -1;
}

int main() {
    for (int n; cin >> n, n;) {
        vector<string> w(n);
        for (auto& e : w) cin >> e;
        cout << solve(n, w) << endl;
    }
}