#include <bits/stdc++.h>
using namespace std;
namespace zyt {
template <typename T>
inline bool read(T &x) {
  char c;
  bool f = false;
  x = 0;
  do c = getchar();
  while (c != EOF && c != '-' && !isdigit(c));
  if (c == EOF) return false;
  if (c == '-') f = true, c = getchar();
  do x = x * 10 + c - '0', c = getchar();
  while (isdigit(c));
  if (f) x = -x;
  return true;
}
template <typename T>
inline void write(T x) {
  static char buf[20];
  char *pos = buf;
  if (x < 0) putchar('-'), x = -x;
  do *pos++ = x % 10 + '0';
  while (x /= 10);
  while (pos > buf) putchar(*--pos);
}
const int N = 1e5 + 10, S = 320, P = 998244353;
int n, k, _sum[S][S << 1], *sum[S], dp[N], pre[N], last[N];
int block, blnum, begin[S], belong[N], w[N], tot[S];
void add(int &a, const int b) { a = (a + b) % P; }
void change(const int pos, const int x) {
  if (!pos) return;
  int b = belong[pos];
  w[pos] = x;
  int tmp = 0;
  for (int i = -block; i <= block; i++) sum[b][i] = 0;
  for (int i = begin[b + 1] - 1; i >= begin[b]; i--) {
    tmp += w[i];
    add(sum[b][tmp], dp[i - 1]);
  }
  tot[b] = tmp;
  for (int i = -block + 1; i <= block; i++) add(sum[b][i], sum[b][i - 1]);
}
int work() {
  read(n), read(k);
  block = sqrt(n), blnum = ceil(double(n) / block);
  dp[0] = 1;
  for (int i = 1; i <= n; i++) belong[i] = (i - 1) / block + 1;
  for (int i = 1; i <= blnum; i++)
    begin[i] = (i - 1) * block + 1, sum[i] = _sum[i] + block + 1;
  begin[blnum + 1] = n + 1;
  for (int i = 1; i <= n; i++) {
    int a, tmp = 0;
    read(a);
    change(pre[last[a]], 0);
    change(pre[i] = last[a], -1);
    change(last[a] = i, 1);
    dp[i] = 0;
    for (int j = i; j >= begin[belong[i]]; j--)
      if ((tmp += w[j]) <= k) add(dp[i], dp[j - 1]);
    for (int j = belong[i] - 1; j > 0; j--) {
      if (k - tmp >= -block) add(dp[i], sum[j][min(block, k - tmp)]);
      tmp += tot[j];
    }
  }
  write(dp[n]);
  return 0;
}
}  // namespace zyt
int main() { return zyt::work(); }
