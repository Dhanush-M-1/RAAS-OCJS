#include <bits/stdc++.h>
using namespace std;
mt19937 rnd(time(0));
bool comp(pair<int, int> &a, pair<int, int> &b) {
  return a.first < b.first || (a.first == b.first && a.second > b.second);
}
int main() {
  int n;
  cin >> n;
  vector<int> g(n);
  vector<pair<int, int> > v(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i].first;
    v[i].second = i;
    g[i] = v[i].first;
  }
  sort(v.rbegin(), v.rend(), comp);
  vector<vector<int> > ans;
  vector<int> cur;
  for (int i = 0; i < n; i++) {
    cur.push_back(v[i].second);
    ans.push_back(cur);
  }
  for (int i = 0; i < n; i++) {
    sort(ans[i].begin(), ans[i].end());
  }
  int k;
  cin >> k;
  for (int i = 0; i < k; i++) {
    int a, b;
    cin >> a >> b;
    cout << g[ans[a - 1][b - 1]] << '\n';
  }
  return 0;
}
