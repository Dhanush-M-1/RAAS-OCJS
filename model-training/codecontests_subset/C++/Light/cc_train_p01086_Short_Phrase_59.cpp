#include <bits/stdc++.h>

using namespace std;

#define all(c) (c).begin(), (c).end()
#define rep(i, n) for (int i = 0; i < (int)(n); i++)

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int n;
string w[50];
bool ok(int idx) {
    int now = 0;
    vector<int> vec{5, 7, 5, 7, 7};
    rep(i, n) if (idx <= i) {
        vec[now] -= w[i].size();
        if (vec[now] == 0) {
            now++;
            if (now == vec.size()) return true;
        }
        if (vec[now] < 0) {
            break;
        }
    }
    return false;
}
void solve() {
    rep(i, n) {
        if (ok(i)) {
            cout << i + 1 << endl;
            break;
        }
    }
}
int main() {
    while (cin >> n, n) {
        rep(i, n) cin >> w[i];
        solve();
    }

    return 0;
}