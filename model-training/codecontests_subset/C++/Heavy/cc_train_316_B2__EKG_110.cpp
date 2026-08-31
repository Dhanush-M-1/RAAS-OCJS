#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e3 + 5;
long long n, m;
int a[maxn];
int rankm;
stack<int> s[maxn];
int to[maxn];
int tot = 1;
bool vis[maxn];
int cnt = 0;
int dp[10005];
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    if (a[i] == 0) {
      s[tot].push(i);
      to[i] = tot++;
      cnt++;
      if (m == i) {
        rankm = s[to[i]].size();
      }
    }
  }
  while (cnt < n) {
    for (int i = 1; i <= n; i++) {
      if (to[a[i]] && !to[i]) {
        s[to[a[i]]].push(i);
        to[i] = to[a[i]];
        cnt++;
        if (m == i) {
          rankm = s[to[i]].size();
        }
      }
    }
  }
  int sum = 0;
  for (int i = 1; i < tot; i++) {
    if (i == to[m]) continue;
    sum += s[i].size();
  }
  dp[0] = 1;
  for (int i = 1; i < tot; i++) {
    if (i == to[m]) continue;
    int len = s[i].size();
    for (int j = sum; j >= len; j--) {
      if (dp[j - len]) {
        dp[j] = 1;
      }
    }
  }
  for (int i = 0; i <= sum; i++) {
    if (dp[i]) {
      printf("%d\n", i + rankm);
    }
  }
  return 0;
}
