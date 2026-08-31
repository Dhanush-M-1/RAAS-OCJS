#include <bits/stdc++.h>
using namespace std;
struct solution {
  int t, n{0};
  vector<int> a{};
  void get_data() { cin >> t; }
  void solve() {
    while (t--) {
      cin >> n;
      a.clear();
      a.resize(n);
      for (auto &el : a) cin >> el;
      auto f = a[0];
      auto s = a[1];
      bool printed = false;
      for (auto i = 2; i < a.size(); ++i) {
        if ((f + s) <= a[i]) {
          cout << 1 << " " << 2 << " " << i + 1 << "\n";
          printed = true;
          break;
        }
      }
      if (!printed) cout << "-1\n";
    }
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  solution s;
  s.get_data();
  s.solve();
  return 0;
}
