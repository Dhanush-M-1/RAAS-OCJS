#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const int INF = 1 << 30;
const ll LINF = 1LL << 60;
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int T;
  cin >> T;
  while (T--) {
    int n, m;
    cin >> n >> m;
    vector<int> a(n), b(m);
    for (auto &e : a) cin >> e;
    for (auto &e : b) cin >> e;
    map<int, int> cnt;
    for (auto &e : b) cnt[e]++;
    bool ok = false;
    for (auto &e : a) {
      if (cnt.count(e)) {
        cout << "YES"
             << "\n";
        cout << 1 << " " << e << "\n";
        ok = true;
      }
      if (ok) break;
    }
    if (!ok) {
      cout << "NO"
           << "\n";
    }
  }
}
