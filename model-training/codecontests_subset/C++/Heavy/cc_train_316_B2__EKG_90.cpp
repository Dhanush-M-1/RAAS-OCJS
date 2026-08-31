#include <bits/stdc++.h>
using namespace std;
const long double PI = acosl(-1.0);
bool isSubsetSum(vector<int> set, int n, int sum) {
  bool subset[n + 1][sum + 1];
  for (int i = 0; i <= n; i++) subset[i][0] = true;
  for (int i = 1; i <= sum; i++) subset[0][i] = false;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= sum; j++) {
      if (j < set[i - 1]) subset[i][j] = subset[i - 1][j];
      if (j >= set[i - 1])
        subset[i][j] = subset[i - 1][j] || subset[i - 1][j - set[i - 1]];
    }
  }
  return subset[n][sum];
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, x, t;
  cin >> n >> x;
  vector<pair<int, int> > v(n);
  vector<int> s;
  for (int i = 0; i < n; i++) v[i].second = -1;
  for (int i = 0; i < n; i++) {
    cin >> v[i].first;
    v[i].first--;
    if (v[i].first != -1) v[v[i].first].second = i;
  }
  int cnt, par;
  for (int i = 0; i < n; i++) {
    if (i == x - 1) continue;
    if (v[i].second == -1) {
      bool kp = false;
      cnt = 1;
      par = v[i].first;
      while (par != -1) {
        if (par == x - 1) kp = 1;
        cnt++;
        par = v[par].first;
      }
      if (!kp) s.push_back(cnt);
    }
  }
  sort(s.begin(), s.end());
  int p = 0;
  par = x - 1;
  while (par != -1) {
    p++;
    par = v[par].first;
  }
  vector<int> ans;
  ans.push_back(p);
  for (int i = p + 1; i <= n; i++) {
    if (isSubsetSum(s, s.size(), i - p)) ans.push_back(i);
  }
  for (int i = 0; i < ans.size(); i++) cout << ans[i] << "\n";
  return 0;
}
