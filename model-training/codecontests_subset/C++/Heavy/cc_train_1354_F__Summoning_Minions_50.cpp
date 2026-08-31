#include <bits/stdc++.h>
using namespace std;
const int inf = 2000000000;
char buffer[2000020], *p1, *p2;
template <class T>
void read(T& x) {
  char ch = ((p1 == p2 &&
              (p2 = (p1 = buffer) + fread(buffer, 1, 2000020, stdin), p1 == p2))
                 ? EOF
                 : *p1++);
  x = 0;
  bool f = 1;
  while (!('0' <= ch && ch <= '9') && ch != '-')
    ch = ((p1 == p2 &&
           (p2 = (p1 = buffer) + fread(buffer, 1, 2000020, stdin), p1 == p2))
              ? EOF
              : *p1++);
  if (ch == '-')
    f = 0,
    ch = ((p1 == p2 &&
           (p2 = (p1 = buffer) + fread(buffer, 1, 2000020, stdin), p1 == p2))
              ? EOF
              : *p1++);
  while ('0' <= ch && ch <= '9')
    x = (x << 1) + (x << 3) + ch - '0',
    ch = ((p1 == p2 &&
           (p2 = (p1 = buffer) + fread(buffer, 1, 2000020, stdin), p1 == p2))
              ? EOF
              : *p1++);
  x = (f) ? x : -x;
}
int _num[20];
template <class T>
void write(T x) {
  if (!x) {
    putchar('0'), putchar('\n');
    return;
  }
  if (x < 0) putchar('-'), x = -x;
  int c = 0;
  while (x) _num[++c] = x % 10, x /= 10;
  while (c) putchar('0' + _num[c--]);
  putchar('\n');
}
int n, k, ti;
struct ele {
  int b, a, id;
  ele(int b, int a, int id) : b(b), a(a), id(id) {}
  ele() {}
  bool operator<(const ele y) const { return b < y.b; }
} p[85];
int vis[85][85];
int dp[85][85];
int DP(int pos, int rest) {
  if (pos > n) {
    if (rest == 0)
      return 0;
    else
      return -inf;
  }
  if (vis[pos][rest] == ti) return dp[pos][rest];
  vis[pos][rest] = ti;
  int& ans = dp[pos][rest];
  if (rest)
    return ans = max(DP(pos + 1, rest - 1) + p[pos].a + p[pos].b * (k - rest),
                     DP(pos + 1, rest) + p[pos].b * (k - 1));
  else
    return ans = DP(pos + 1, rest) + p[pos].b * (k - 1);
}
int ans[85];
void find_ans(int pos, int rest) {
  if (pos > n) return;
  if (rest) {
    int A = DP(pos + 1, rest - 1) + p[pos].a + p[pos].b * (k - rest);
    int B = DP(pos + 1, rest) + p[pos].b * (k - 1);
    if (A > B)
      find_ans(pos + 1, rest - 1), ans[pos] = p[pos].id;
    else
      find_ans(pos + 1, rest), ans[pos] = -p[pos].id;
  } else {
    find_ans(pos + 1, rest);
    ans[pos] = -p[pos].id;
  }
}
int main() {
  int T, x, y;
  scanf("%d", &T);
  while (T--) {
    ti++;
    scanf("%d%d", &n, &k);
    for (register int i = 1; i <= n; i++)
      scanf("%d%d", &x, &y), p[i] = ele(y, x, i);
    sort(p + 1, p + 1 + n);
    DP(1, k), find_ans(1, k);
    int num = n;
    for (register int i = 1; i <= n; i++)
      if (ans[i] < 0) num++;
    printf("%d\n", num);
    for (register int i = 1; i <= n; i++) {
      if (k > 1 && ans[i] > 0) printf("%d ", ans[i]), k--;
    }
    for (register int i = 1; i <= n; i++) {
      if (ans[i] < 0) printf("%d %d ", -ans[i], ans[i]);
    }
    for (register int i = n; i >= 1; i--) {
      if (ans[i] > 0) {
        printf("%d\n", ans[i]);
        break;
      }
    }
  }
  return 0;
}
