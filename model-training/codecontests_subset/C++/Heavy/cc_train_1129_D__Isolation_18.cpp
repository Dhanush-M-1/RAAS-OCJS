#include <bits/stdc++.h>
using namespace std;
int n, m, a[100001], pos[100001], pre[100001], b[100001], dp[100001],
    c[((100001 / 320) + 1)][2 * 320 + 1], s[((100001 / 320) + 1)];
int GetBlockNumber(int i) { return i / 320 + (i % 320 != 0); }
void UpdateBlock(int k) {
  s[k] = 0;
  for (int i = 0; i <= 2 * 320; ++i) {
    c[k][i] = 0;
  }
  int l = (k - 1) * 320 + 1, r = min(n, l + 320 - 1), &x = s[k], y = 320;
  for (int i = r; i >= l; --i) {
    x += b[i];
    y += b[i];
    c[k][y] = (c[k][y] + dp[i - 1]) % 998244353;
  }
  for (int i = 1; i <= 2 * 320; ++i) {
    c[k][i] = (c[k][i] + c[k][i - 1]) % 998244353;
  }
}
void Update(int i, int x, int curBlockNo) {
  if (i == 0) {
    return;
  }
  b[i] = x;
  int iBlockNo = GetBlockNumber(i);
  if (iBlockNo != curBlockNo) {
    UpdateBlock(iBlockNo);
  }
}
int Query(int i) {
  int ans = 0, x = 0, iBlockNo = GetBlockNumber(i);
  int l = (iBlockNo - 1) * 320 + 1;
  for (; i >= l; --i) {
    x += b[i];
    if (x <= m) {
      ans = (ans + dp[i - 1]) % 998244353;
    }
  }
  for (--iBlockNo; iBlockNo > 0; x += s[iBlockNo], --iBlockNo) {
    int y = 320 + m - x;
    if (y < 0) {
      continue;
    }
    y = min(2 * 320, y);
    ans = (ans + c[iBlockNo][y]) % 998244353;
  }
  return ans;
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
  }
  dp[0] = 1;
  for (int i = 1; i <= n; ++i) {
    int iBlockNo = GetBlockNumber(i);
    pre[i] = pos[a[i]];
    Update(pre[pre[i]], 0, iBlockNo);
    Update(pre[i], -1, iBlockNo);
    b[i] = 1;
    dp[i] = Query(i);
    pos[a[i]] = i;
    if (i % 320 == 0) {
      UpdateBlock(iBlockNo);
    }
  }
  printf("%d\n", dp[n]);
  return 0;
}
