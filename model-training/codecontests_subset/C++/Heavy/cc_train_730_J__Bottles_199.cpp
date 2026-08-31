#include <bits/stdc++.h>
using namespace std;
struct node {
  int x, y;
} A[105];
int dp[10005][105];
bool cmp(node h, node g) { return h.y > g.y; }
bool cmm(node h, node g) { return h.x > g.x; }
int main() {
  int n, m, i, j, sum = 0, cnt = 0, ans = 0, q, ans2 = 0;
  cin >> n;
  for (i = 1; i <= n; i++) {
    scanf("%d", &A[i].x);
    sum += A[i].x;
  }
  for (i = 1; i <= n; i++) {
    scanf("%d", &A[i].y);
  }
  sort(A + 1, A + n + 1, cmp);
  for (i = 1; i < n; i++) {
    cnt += A[i].y;
    if (cnt >= sum) break;
  }
  int k = i;
  for (i = i + 1; i <= n; i++) {
    ans += A[i].x;
  }
  sort(A + 1, A + n + 1, cmm);
  for (i = 0; i <= 10000; i++) {
    for (j = 0; j <= 100; j++) {
      dp[i][j] = -1;
    }
  }
  dp[0][0] = 0;
  for (i = 1; i <= n; i++) {
    for (j = k - 1; j >= 0; j--) {
      for (q = cnt; q >= 0; q--) {
        if (q + A[i].y > cnt) continue;
        if (dp[q][j] != -1) {
          dp[q + A[i].y][j + 1] = max(dp[q + A[i].y][j + 1], dp[q][j] + A[i].x);
        }
      }
    }
  }
  for (i = sum; i <= cnt; i++) {
    if (sum - dp[i][k] < ans) {
      ans = sum - dp[i][k];
    }
  }
  printf("%d %d", k, ans);
  return 0;
}
