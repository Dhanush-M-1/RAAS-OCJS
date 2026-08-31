#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10, mod = 1e9 + 7;
int a[N];
vector<pair<int, int> > vec;
bool cmp(pair<int, int> a, pair<int, int> b) {
  if (a.first != b.first)
    return a.first > b.first;
  else
    return a.second < b.second;
}
void solve() {
  int k, pos;
  cin >> k >> pos;
  vector<int> ans;
  for (int i = 0; i < k; i++) {
    ans.push_back(vec[i].second);
  }
  sort(ans.begin(), ans.end());
  cout << a[ans[pos - 1]] << endl;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    vec.push_back({a[i], i});
  }
  int m;
  cin >> m;
  sort(vec.begin(), vec.end(), cmp);
  while (m--) solve();
}
