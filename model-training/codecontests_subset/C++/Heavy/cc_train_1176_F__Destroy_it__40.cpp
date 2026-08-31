#include <bits/stdc++.h>
using namespace std;
template <class T>
void PVecPrint(vector<T>& v) {
  for (int i = 0; i < (int)v.size(); i++)
    cout << v[i].first << "," << v[i].second << ' ';
  cout << '\n';
}
template <class T>
void VecPrint(vector<T>& v) {
  for (int i = 0; i < v.size(); i++) cout << v[i] << ' ';
  cout << '\n';
}
vector<pair<long long int, long long int> > func(vector<pair<int, int> >& c) {
  vector<pair<long long int, long long int> > ans;
  vector<vector<int> > v(4);
  for (int i = 0; i < c.size(); i++) v[c[i].first].push_back(c[i].second);
  for (int i = 1; i < 4; i++) sort(v[i].begin(), v[i].end(), greater<int>());
  long long int p1 = 0 * 1LL;
  for (int i = 1; i < 4; i++) {
    if (v[i].size() > 0) p1 = max(p1, v[i][0] * 1LL);
  }
  ans.push_back({p1, 2 * 1LL * p1});
  vector<int> t;
  for (int i = 0; i < min(2, (int)v[1].size()); i++) t.push_back(v[1][i]);
  if (v[2].size() > 0) t.push_back(v[2][0]);
  if (t.size() > 1) {
    sort(t.begin(), t.end(), greater<int>());
    long long int p2 = t[0] * 1LL + t[1], p21 = 2 * 1LL * t[0] + t[1];
    ans.push_back({p2, p21});
  } else
    ans.push_back({-1, -1});
  if (v[1].size() > 2) {
    long long int p3 = v[1][0] * 1LL + v[1][1] + v[1][2];
    long long int p31 = 2 * 1LL * v[1][0] + v[1][1] + v[1][2];
    ans.push_back({p3, p31});
  } else
    ans.push_back({-1, -1});
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int n;
  cin >> n;
  vector<vector<pair<int, int> > > v(n);
  for (int i = 0; i < n; i++) {
    int k;
    cin >> k;
    v[i].resize(k);
    for (int j = 0; j < k; j++) cin >> v[i][j].first >> v[i][j].second;
  }
  vector<vector<pair<long long int, long long int> > > imp(n);
  for (int i = 0; i < n; i++) imp[i] = func(v[i]);
  long long int dp[n + 1][10];
  for (int i = 0; i <= n; i++)
    for (int j = 0; j < 10; j++) dp[i][j] = -1;
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j < 10; j++) {
      if (dp[i - 1][j] == -1) continue;
      for (int k = 0; k < imp[i - 1].size(); k++) {
        if (imp[i - 1][k].first == -1) continue;
        long long int t = j + k + 1 >= 10 ? dp[i - 1][j] + imp[i - 1][k].second
                                          : dp[i - 1][j] + imp[i - 1][k].first;
        int ind = (j + k + 1) % 10;
        dp[i][ind] = max(dp[i][ind], t);
      }
    }
    for (int j = 0; j < 10; j++) dp[i][j] = max(dp[i][j], dp[i - 1][j]);
  }
  long long int ans = 0;
  for (int i = 0; i < 10; i++) ans = max(ans, dp[n][i]);
  cout << ans << '\n';
}
