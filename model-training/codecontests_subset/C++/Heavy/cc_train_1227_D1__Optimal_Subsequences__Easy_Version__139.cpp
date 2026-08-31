#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
mt19937 rnd(time(0));
const long long INF = 1e9;
struct Point {
  Point() {
    cin >> x;
    cin >> y;
  }
  Point(long double x, long double y) : x(x), y(y) {}
  long double x, y;
};
void solve() {
  int n, m, k, pos;
  cin >> n;
  vector<int> v(n), b(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i];
    b[i] = v[i];
  }
  sort(b.begin(), b.end());
  cin >> m;
  while (m-- > 0) {
    cin >> k >> pos;
    int needDEL = n - k;
    map<int, int> mp;
    for (int i = 0; i < needDEL; i++) {
      mp[b[i]]++;
    }
    vector<bool> used(n, 0);
    for (int i = n - 1; i >= 0 && needDEL != 0; i--) {
      if (mp[v[i]] != 0) {
        mp[v[i]]--;
        used[i] = 1;
        needDEL--;
      }
    }
    vector<int> newV;
    for (int i = 0; i < n; i++) {
      if (!used[i]) {
        newV.push_back(v[i]);
      }
    }
    cout << newV[pos - 1] << '\n';
  }
}
void jafdj(int aijf, int akfka) {
  cout << "0" << '\n';
  long double o = 1 * 10;
  long long p = (int)o << 2;
  return;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
