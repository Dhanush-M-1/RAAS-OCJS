#include <bits/stdc++.h>
using namespace std;
bool csort(pair<int, int> a, pair<int, int> b) {
  if (a.first < b.first)
    return 1;
  else if (a.first == b.first && a.second < b.second)
    return 1;
  return 0;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, i, nr = 0;
  cin >> n;
  vector<pair<int, int>> c(n);
  for (i = 0; i < n; i++) cin >> c[i].first >> c[i].second;
  sort(c.begin(), c.end(), csort);
  if (n == 1)
    nr = 1;
  else
    nr = 2;
  for (i = 1; i < n - 1; i++) {
    if (c[i - 1].first < c[i].first - c[i].second)
      nr++;
    else if (c[i + 1].first > c[i].first + c[i].second) {
      c[i].first = c[i].first + c[i].second;
      nr++;
    }
  }
  cout << nr;
  return 0;
}
