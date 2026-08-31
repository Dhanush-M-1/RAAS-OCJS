#include <bits/stdc++.h>
using namespace std;
bool comp(const pair<int, int>& a, const pair<int, int>& b) {
  if (a.first == b.first)
    return a.second > b.second;
  else
    return a.first < b.first;
}
int main() {
  int n;
  cin >> n;
  vector<pair<int, int>> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i].first;
    a[i].second = i;
  }
  sort(a.begin(), a.end(), comp);
  reverse(a.begin(), a.end());
  int m;
  cin >> m;
  for (int i = 0; i < m; i++) {
    int k, pos;
    cin >> k >> pos;
    vector<pair<int, int>> t(k);
    for (int j = 0; j < k; j++) {
      t[j].first = a[j].second;
      t[j].second = a[j].first;
    }
    sort(t.begin(), t.end());
    cout << t[pos - 1].second << '\n';
  }
}
