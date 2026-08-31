#include <bits/stdc++.h>
using namespace std;
int n, m;
bool cmp(pair<int, int> a, pair<int, int> b) {
  if (a.first != b.first) return a.first > b.first;
  return a.second < b.second;
}
bool cmp2(pair<int, int> a, pair<int, int> b) { return a.second < b.second; }
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  vector<pair<int, int> > v;
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    v.push_back({x, i});
  }
  sort(v.begin(), v.end(), cmp);
  cin >> m;
  while (m--) {
    int k, pos;
    cin >> k >> pos;
    vector<pair<int, int> > res;
    for (int i = 0; i < k; i++) {
      res.push_back(v[i]);
    }
    sort(res.begin(), res.end(), cmp2);
    cout << res[pos - 1].first << '\n';
  }
  return 0;
}
