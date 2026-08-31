#include <bits/stdc++.h>
#pragma GCC target("avx2")
#pragma GCC optimization("O3")
#pragma GCC optimization("unrolled-loops")
using namespace std;
const long long mod = 1e9 + 7;
const long long INF = 1e16;
int test = 1;
void CNH_Tourist() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
const int N = 200200;
const int D = 3;
int n;
vector<long long> dmg[N][D + 1];
const int MOD = 10;
long long dp[N][MOD];
vector<long long> sort_top_3(const vector<long long>& v) {
  priority_queue<long long, vector<long long>, greater<long long> > q;
  int k = v.size();
  for (int i = 0; i < k; i++) {
    q.push(v[i]);
    if (i >= 3) q.pop();
  }
  vector<long long> res;
  while (!q.empty()) {
    res.push_back(q.top());
    q.pop();
  }
  reverse(res.begin(), res.end());
  return res;
}
void dp_cal(int i, int r, vector<long long> cur_dmg) {
  int s = cur_dmg.size();
  int new_r = (r + s) % MOD;
  sort(cur_dmg.begin(), cur_dmg.end());
  long long sum = 0;
  for (int j = 0; j < cur_dmg.size(); j++) sum += cur_dmg[j];
  long long mx = cur_dmg.back();
  long long new_dmg = sum;
  if (r + s >= MOD) new_dmg += mx;
  dp[i + 1][new_r] = max(dp[i + 1][new_r], dp[i][r] + new_dmg);
}
long long solve() {
  for (int i = 0; i < MOD; i++) dp[0][i] = -INF;
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    vector<long long> d1 = sort_top_3(dmg[i][1]), d2 = sort_top_3(dmg[i][2]),
                      d3 = sort_top_3(dmg[i][3]);
    for (int r = 0; r < MOD; r++) {
      dp[i + 1][r] = dp[i][r];
    }
    for (int r = 0; r < MOD; r++) {
      if (d1.size() >= 3) {
        vector<long long> dd;
        dd.push_back(d1[0]);
        dd.push_back(d1[1]);
        dd.push_back(d1[2]);
        dp_cal(i, r, dd);
      }
      if (d1.size() >= 2) {
        vector<long long> dd;
        dd.push_back(d1[0]);
        dd.push_back(d1[1]);
        dp_cal(i, r, dd);
      }
      if (d1.size() >= 1 && d2.size() >= 1) {
        vector<long long> dd;
        dd.push_back(d1[0]);
        dd.push_back(d2[0]);
        dp_cal(i, r, dd);
      }
      if (d1.size() >= 1) {
        vector<long long> dd;
        dd.push_back(d1[0]);
        dp_cal(i, r, dd);
      }
      if (d2.size() >= 1) {
        vector<long long> dd;
        dd.push_back(d2[0]);
        dp_cal(i, r, dd);
      }
      if (d3.size() >= 1) {
        vector<long long> dd;
        dd.push_back(d3[0]);
        dp_cal(i, r, dd);
      }
    }
  }
  long long result = -INF;
  for (int r = 0; r < MOD; r++) {
    result = max(result, dp[n][r]);
  }
  return result;
}
int32_t main() {
  CNH_Tourist();
  cin >> n;
  for (int i = 0; i < n; i++) {
    int k;
    cin >> k;
    for (int j = 1; j <= k; j++) {
      int c, d;
      cin >> c >> d;
      dmg[i][c].push_back(d);
    }
  }
  long long ans = solve();
  cout << ans << '\n';
}
