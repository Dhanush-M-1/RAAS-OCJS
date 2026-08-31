#include <bits/stdc++.h>
using namespace std;
int a[101];
bool comp(pair<int, int> x, pair<int, int> y) {
  if (x.first == y.first) {
    return x.second < y.second;
  }
  return x.first > y.first;
}
bool comp2(pair<int, int> x, pair<int, int> y) { return x.second < y.second; }
int d[101][101];
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  cout.tie(NULL);
  int n;
  cin >> n;
  vector<pair<int, int>> v;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    v.push_back({a[i], i});
  }
  sort(v.begin(), v.end(), comp);
  int m;
  cin >> m;
  while (m--) {
    int x, y;
    cin >> x >> y;
    vector<pair<int, int>> v2;
    for (int i = 0; i < x; i++) {
      v2.push_back(v[i]);
    }
    sort(v2.begin(), v2.end(), comp2);
    cout << v2[y - 1].first << '\n';
  }
}
