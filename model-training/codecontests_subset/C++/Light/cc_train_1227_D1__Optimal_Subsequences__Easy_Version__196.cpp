#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    int n, x;
    cin >> n;
    vector<pair<int, int> > a(n);
    for (int i = 0; i < n; i++) {
      cin >> x;
      a[i] = {-x, i};
    }
    sort(a.begin(), a.end());
    int m;
    cin >> m;
    while (m--) {
      int k, pos;
      cin >> k >> pos;
      vector<pair<int, int> > v;
      for (int i = 0; i < k; i++) v.push_back({a[i].second, -a[i].first});
      sort(v.begin(), v.end());
      cout << v[pos - 1].second << "\n";
      v.clear();
    }
    return 0;
  }
}
