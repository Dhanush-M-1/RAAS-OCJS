#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e9;
bool cmp(pair<int, int> a, pair<int, int> b) {
  return a.first > b.first || (a.first == b.first && a.second < b.second);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  vector<pair<int, int>> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i].first;
    a[i].second = i;
  }
  sort(a.begin(), a.end(), cmp);
  int m;
  cin >> m;
  for (int i = 0; i < m; i++) {
    int k, pos;
    cin >> k >> pos;
    vector<pair<int, int>> t(k);
    for (int j = 0; j < k; j++) {
      t[j] = {a[j].second, a[j].first};
    }
    sort(t.begin(), t.end());
    cout << t[pos - 1].second << '\n';
  }
  return 0;
}
