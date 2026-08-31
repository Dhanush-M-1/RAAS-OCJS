#include <bits/stdc++.h>
using namespace std;
bool cmp(pair<int, int> a, pair<int, int> b) {
  if (a.first != b.first) return a.first < b.first;
  return a.second > b.second;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  vector<pair<int, int>> a;
  for (int i = 0; i < n; ++i) {
    int x;
    cin >> x;
    a.emplace_back(x, i);
  }
  sort(a.begin(), a.end(), cmp);
  int m;
  cin >> m;
  for (int i = 0; i < m; ++i) {
    int k, pos;
    cin >> k >> pos;
    vector<pair<int, int>> now;
    for (int i = n - k; i < n; ++i) {
      now.emplace_back(a[i].second, a[i].first);
    }
    sort(now.begin(), now.end());
    cout << now[pos - 1].second << "\n";
  }
}
