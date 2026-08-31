#include <bits/stdc++.h>
using namespace std;
const int N = 5e3 + 2, mod = 1e9 + 7;
void solve() {
  int n;
  cin >> n;
  vector<pair<int, int> > a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i].first;
    a[i].second = i;
  }
  sort(a.begin(), a.end(), [](pair<int, int> i, pair<int, int> j) {
    if (i.first == j.first) return i.second < j.second;
    return i.first > j.first;
  });
  int m;
  cin >> m;
  while (m--) {
    int k, pos;
    cin >> k >> pos;
    vector<pair<int, int> > v(a.begin(), a.begin() + k);
    sort(v.begin(), v.end(), [](pair<int, int> i, pair<int, int> j) {
      return i.second < j.second;
    });
    cout << v[pos - 1].first << '\n';
  }
}
int main() {
  int tt = 1;
  for (int tc = 1; tc <= tt; tc++) {
    solve();
  }
}
