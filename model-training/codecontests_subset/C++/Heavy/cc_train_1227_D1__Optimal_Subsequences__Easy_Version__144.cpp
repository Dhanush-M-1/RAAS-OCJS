#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const int N = 1e5 + 7;
const int inf = INT_MAX / 2;
const long long INF = LLONG_MAX / 3;
const int MOD = 1e9 + 7;
const double eps = 1e-6;
const string cars[] = {"🚗", "🚕", "🚙"};
signed main() {
  cout << fixed << setprecision(4);
  ios::sync_with_stdio(false);
  cin.tie();
  cout.tie();
  int n;
  cin >> n;
  vector<int> a(n);
  for (int& x : a) {
    cin >> x;
  }
  auto b = a;
  sort(a.rbegin(), a.rend());
  int q;
  cin >> q;
  while (q--) {
    int k, d;
    cin >> k >> d;
    multiset<int> s;
    for (int i = 0; i < k; i++) {
      s.insert(s.begin(), a[i]);
    }
    int l = 0;
    for (int i = 0; i < n; i++) {
      if (s.find(b[i]) != s.end()) {
        if (++l == d) {
          cout << b[i] << "\n";
          break;
        }
        s.erase(s.find(b[i]));
      }
    }
  }
  return 0;
}
