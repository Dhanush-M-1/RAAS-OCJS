#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, f = 1;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = (x << 3) + (x << 1) + (c ^ 48);
    c = getchar();
  }
  return f == 1 ? x : -x;
}
inline void print(int x) {
  if (x < 0) putchar('-'), x = ~x + 1;
  if (x > 10) print(x / 10);
  putchar((x % 10) | 48);
}
int dp[80][80][2];
int T;
int n, k;
struct node {
  pair<int, int> s;
  int id;
  bool operator<(const node &x) const { return s > x.s; }
} a[100];
int m;
vector<int> op1, op2, op3;
void dfs(int x, int j, int op) {
  if (x == n + 1) return;
  if (op) {
    if (dp[x][j][op] == dp[x + 1][j][op] + a[x].s.first * (k - 1)) {
      op2.push_back(x);
      dfs(x + 1, j, op);
    } else if (dp[x][j][op] ==
               dp[x + 1][j][0] + a[x].s.first * (k - 1) + a[x].s.second) {
      op3.push_back(x);
      dfs(x + 1, j, 0);
    } else if (j && dp[x][j][op] == dp[x + 1][j - 1][op] +
                                        a[x].s.first * (j - 1) +
                                        a[x].s.second) {
      dfs(x + 1, j - 1, op);
      op1.push_back(x);
    }
  } else {
    if (dp[x][j][0] == dp[x + 1][j][0] + a[x].s.first * (k - 1)) {
      op2.push_back(x);
      dfs(x + 1, j, 0);
    } else if (j && dp[x][j][0] == dp[x + 1][j - 1][0] +
                                       a[x].s.first * (j - 1) + a[x].s.second) {
      dfs(x + 1, j - 1, 0);
      op1.push_back(x);
    }
  }
}
vector<int> ans;
int main() {
  T = read();
  while (T--) {
    op1.clear(), op2.clear(), op3.clear();
    n = read(), k = read();
    for (int i = 1; i <= n; ++i)
      a[i].s.second = read(), a[i].s.first = read(), a[i].id = i;
    sort(a + 1, a + n + 1);
    memset(dp, -0x3f, sizeof(dp));
    dp[n + 1][0][0] = 0;
    int ans = 0;
    for (int i = n; i >= 1; --i) {
      for (int j = 0; j <= (n - i + 1) && j < k; ++j) {
        dp[i][j][0] = dp[i + 1][j][0] + a[i].s.first * (k - 1);
        dp[i][j][1] =
            max(dp[i + 1][j][1] + a[i].s.first * (k - 1),
                dp[i + 1][j][0] + a[i].s.first * (k - 1) + a[i].s.second);
        if (j) {
          dp[i][j][0] =
              max(dp[i][j][0],
                  dp[i + 1][j - 1][0] + a[i].s.first * (j - 1) + a[i].s.second);
          dp[i][j][1] =
              max(dp[i][j][1],
                  dp[i + 1][j - 1][1] + a[i].s.first * (j - 1) + a[i].s.second);
        }
      }
    }
    dfs(1, k - 1, 1);
    printf("%d\n", op1.size() + op2.size() * 2 + 1);
    for (int i = 0; i < op1.size(); ++i) {
      printf("%d ", a[op1[i]].id);
    }
    for (int i = 0; i < op2.size(); ++i)
      printf("%d %d ", a[op2[i]].id, -a[op2[i]].id);
    printf("%d\n", a[op3[0]].id);
  }
  return 0;
}
