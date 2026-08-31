#include <bits/stdc++.h>
using namespace std;
const long long INF = (long long)1 << 62;
const long long MOD = 1e9 + 7;
const int iINF = 1 << 30;
const double PI = 3.14159265359;
int main() {
  int n;
  vector<pair<int, int> > a;
  cin >> n;
  a.assign(n, {0, 0});
  for (int i = 0; i < n; i++) {
    cin >> a[i].first;
    a[i].second = -i;
  }
  sort(a.rbegin(), a.rend());
  int m;
  cin >> m;
  for (int i = 0; i < m; i++) {
    int k, pos;
    cin >> k >> pos;
    vector<pair<int, int> > tmp;
    for (int j = 0; j < k; j++) {
      tmp.push_back({-a[j].second, a[j].first});
    }
    sort(tmp.begin(), tmp.end());
    cout << tmp[pos - 1].second << "\n";
  }
  return 0;
}
