#include <bits/stdc++.h>
using namespace std;
int i, j, n, m, a, b, c, d, op, mini, mij, ls, ld, ul, timp, k, maxl, rasp;
int dp[1000005], flower[1000005], viz[1000005];
int good[1000005];
priority_queue<pair<int, int>, vector<pair<int, int> >,
               greater<pair<int, int> > >
    q;
int sol[1000005];
vector<pair<int, int> > muchii;
vector<pair<int, int> > v[1000005];
int gm[1000005];
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL);
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    cin >> a >> b;
    muchii.push_back({a, b});
    v[a].push_back({b, i});
    v[b].push_back({a, i});
    gm[i] = 1;
  }
  for (int i = 1; i <= n; i++) {
    dp[i] = v[i].size();
    q.push({dp[i], i});
    good[i] = 1;
  }
  rasp = n;
  while (q.size() && (q.top().first < k || good[q.top().second] == 0)) {
    pair<int, int> now = q.top();
    q.pop();
    if (good[now.second] == 0) continue;
    good[now.second] = 0;
    rasp--;
    for (int i = 0; i < v[now.second].size(); i++) {
      int nxt = v[now.second][i].first;
      dp[nxt]--;
      if (good[nxt]) q.push({dp[nxt], nxt});
    }
  }
  vector<int> sol;
  for (j = m; j; j--) {
    sol.push_back(rasp);
    a = muchii[j - 1].first;
    b = muchii[j - 1].second;
    gm[j] = 0;
    if (good[a] && good[b]) {
      dp[a]--;
      dp[b]--;
      q.push({dp[a], a});
      q.push({dp[b], b});
    }
    while (q.size() && (q.top().first < k || good[q.top().second] == 0)) {
      pair<int, int> now = q.top();
      q.pop();
      if (good[now.second] == 0) continue;
      good[now.second] = 0;
      rasp--;
      for (int i = 0; i < v[now.second].size(); i++) {
        if (gm[v[now.second][i].second]) {
          int nxt = v[now.second][i].first;
          dp[nxt]--;
          if (good[nxt]) q.push({dp[nxt], nxt});
        }
      }
    }
  }
  for (int i = sol.size() - 1; i >= 0; i--) cout << sol[i] << '\n';
  return 0;
}
