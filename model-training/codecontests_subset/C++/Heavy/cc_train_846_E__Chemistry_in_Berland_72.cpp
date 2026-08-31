#include <bits/stdc++.h>
using namespace std;
long long gcd(long long n1, long long n2) {
  if (!n1) return n2;
  if (!n2) return n1;
  if (n1 % n2 == 0) return n2;
  return gcd(n2, n1 % n2);
}
long long powmod(long long base, long long exponent) {
  base %= 1000000007;
  long long ans = 1;
  while (exponent) {
    if (exponent & 1) ans = (ans * base) % 1000000007;
    base = (base * base) % 1000000007;
    exponent /= 2;
  }
  ans %= 1000000007;
  return ans;
}
long long b[200100 + 1];
long long a[200100 + 1];
long long arr[200100 + 1];
long long dp[200100 + 1];
vector<pair<int, int> > child[200100 + 1];
int x[200100 + 1];
int k[200100 + 1];
bool f = true;
void dfs(int node) {
  if (!f) return;
  for (int i = 0; i < child[node].size(); i++) {
    dfs(child[node][i].first);
    if (dp[child[node][i].first] >= 0) {
      dp[node] += dp[child[node][i].first];
    } else {
      long long temp = (1000000000000000100 / child[node][i].second);
      if (temp + dp[child[node][i].first] < 0) f = false;
      dp[node] += dp[child[node][i].first] * child[node][i].second;
      if (dp[node] + 1000000000000000100 < 0) f = false;
    }
  }
}
int main() {
  int n, i, j;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) scanf("%lld", &b[i]);
  for (i = 1; i <= n; i++) {
    scanf("%lld", &a[i]);
    arr[i] = b[i] - a[i];
    dp[i] = arr[i];
  }
  for (i = 2; i <= n; i++) {
    scanf("%d", &x[i]);
    scanf("%d", &k[i]);
    child[x[i]].push_back(make_pair(i, k[i]));
  }
  dfs(1);
  f &= (dp[1] >= 0);
  if (f)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
