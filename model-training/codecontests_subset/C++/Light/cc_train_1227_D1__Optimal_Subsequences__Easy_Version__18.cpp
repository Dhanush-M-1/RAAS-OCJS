#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int>> v;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    v.push_back({-a[i], i});
  }
  sort(v.begin(), v.end());
  int m;
  cin >> m;
  for (int i = 0; i < m; i++) {
    int k, p;
    cin >> k >> p;
    vector<pair<int, int>> tmp;
    for (int j = 0; j < k; j++) {
      tmp.push_back({v[j].second, -v[j].first});
    }
    sort(tmp.begin(), tmp.end());
    cout << tmp[p - 1].second << '\n';
  }
  return 0;
}
