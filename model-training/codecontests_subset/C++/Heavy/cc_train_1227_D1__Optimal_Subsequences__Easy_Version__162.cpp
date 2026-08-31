#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ull = unsigned long long;
using ld = long double;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
int getrnd(int l, int r) { return uniform_int_distribution<int>(l, r)(rng); }
template <typename T1, typename T2>
bool relax(T1& a, const T2& b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
template <typename T1, typename T2>
bool strain(T1& a, const T2& b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
void solve() {
  int n;
  cin >> n;
  vector<int> a(n), b(n);
  for (int i = 0; i < n; ++i) cin >> a[i], b[i] = a[i];
  sort(b.rbegin(), b.rend());
  int q;
  cin >> q;
  while (q--) {
    int k, pos;
    cin >> k >> pos;
    --pos;
    vector<int> was(n, 0);
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < k; ++j) {
        if (a[i] == b[j]) was[i] = 1;
      }
    }
    int c = 1;
    for (int i = k - 2; i >= 0; --i) {
      if (b[i] == b[i + 1])
        ++c;
      else
        break;
    }
    vector<int> temp;
    for (int i = 0; i < n; ++i) {
      if (a[i] == b[k - 1]) {
        if (c > 0 && was[i]) {
          temp.emplace_back(a[i]);
          --c;
        }
      } else if (was[i]) {
        temp.emplace_back(a[i]);
      }
    }
    cout << temp[pos] << '\n';
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(nullptr);
  cout.tie(nullptr);
  srand(time(0));
  int t = 1;
  while (t--) solve();
  return 0;
}
