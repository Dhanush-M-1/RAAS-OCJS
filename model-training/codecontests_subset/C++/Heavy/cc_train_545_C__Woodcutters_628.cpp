#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 5;
const long long inf = 0x3f;
int dp[maxn][3];
struct Tree {
  long long x, h;
} arr[maxn];
int transfer(int a, int b, int id) {
  int v = 0;
  if (arr[id].x < a) {
    v = max(dp[id][0], dp[id][1]);
  }
  if (arr[id].x + arr[id].h < a) {
    v = max(v, dp[id][2]);
  }
  return v;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    arr[i].x = u, arr[i].h = v;
  }
  arr[0].x = arr[0].h = -inf;
  for (int i = 1; i <= n; i++) {
    dp[i][0] = transfer(arr[i].x, arr[i].x, i - 1);
    dp[i][1] = transfer(arr[i].x - arr[i].h, arr[i].x, i - 1) + 1;
    dp[i][2] = transfer(arr[i].x, arr[i].x + arr[i].h, i - 1) + 1;
  }
  printf("%d\n", max(dp[n][0], max(dp[n][1], dp[n][2])));
  return 0;
}
