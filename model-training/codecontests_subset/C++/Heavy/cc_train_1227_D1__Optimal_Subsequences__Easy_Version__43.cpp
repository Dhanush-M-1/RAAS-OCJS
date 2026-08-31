#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using vi = vector<int>;
using vvi = vector<vi>;
using ii = pair<int, int>;
using vii = vector<ii>;
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  vii a(n);
  for (int i = 0; i < (n); i++) cin >> a[i].first, a[i].second = i;
  int m;
  cin >> m;
  sort(a.begin(), a.end(), [](ii& x, ii& y) {
    if (x.first > y.first)
      return true;
    else if (x.first == y.first && x.second < y.second)
      return true;
    return false;
  });
  while (m--) {
    int k, p;
    cin >> k >> p;
    map<int, int> b;
    for (int i = 0; i < (k); i++) b[a[i].second] = a[i].first;
    auto it = b.begin();
    while (--p) it++;
    cout << it->second << '\n';
  }
  return 0;
}
