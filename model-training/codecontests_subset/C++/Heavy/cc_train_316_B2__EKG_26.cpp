#include <bits/stdc++.h>
using namespace std;
long long visit[1007], dp[1007], dp1[1007], n, d, chk;
vector<long long> v[1007], v1;
long long solve(long long i, long long l, long long sum) {
  if (i == l) dp[sum] = 1;
  if (dp[sum] != -1) return dp[sum];
}
long long dfs(long long node) {
  visit[node] = 1;
  if (node == d) {
    chk = 1;
    return 1;
  }
  long long res = 1, i, x;
  for (i = 0; i < v[node].size(); i++) {
    x = v[node][i];
    if (!visit[x]) {
      res += dfs(x);
    }
  }
  return res;
}
int main() {
  long long i, x, val, k, tot = 0, sum;
  cin >> n >> d;
  for (i = 1; i <= n; i++) {
    cin >> x;
    v[x].push_back(i);
  }
  for (i = 1; i <= n; i++) visit[i] = 0;
  v1.clear();
  for (i = 0; i < v[0].size(); i++) {
    chk = 0;
    val = dfs(v[0][i]);
    if (chk == 1)
      k = val;
    else {
      v1.push_back(val);
      tot += val;
    }
  }
  for (i = 0; i <= n; i++) dp[i] = 0;
  dp[0] = 1;
  sort(v1.begin(), v1.end());
  for (i = 0; i < v1.size(); i++) {
    for (sum = n; sum >= 0; sum--) {
      if (dp[sum]) dp[sum + v1[i]] = 1;
    }
  }
  for (i = 0; i <= n; i++) {
    if (dp[i] == 1) cout << i + k << endl;
  }
  return 0;
}
