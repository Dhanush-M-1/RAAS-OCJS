#include <bits/stdc++.h>
using namespace std;
bool comp(pair<int, int> a, pair<int, int> b) {
  if (a.first == b.first) return a.second > b.second;
  return a.first < b.first;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m;
  cin >> n;
  vector<int> a_f(n);
  vector<pair<int, int>> a(n);
  for (int i = 0; i < n; i++)
    cin >> a[i].first, a[i].second = i, a_f[i] = a[i].first;
  sort(a.begin(), a.end(), comp);
  cin >> m;
  vector<vector<int>> tmp(n);
  vector<bool> used(n);
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j < n - i; j++) used[a[j].second] = true;
    for (int j = 0; j < n; j++) {
      if (used[j]) continue;
      tmp[i - 1].push_back(a_f[j]);
    }
    used.assign(n, false);
  }
  while (m--) {
    int j, pos;
    cin >> j >> pos;
    cout << tmp[j - 1][pos - 1] << '\n';
  }
  return 0;
}
