#include <bits/stdc++.h>
using namespace std;
const int maxn = 111111;
const long long MAX = 10ll * 10000 * 10000 * 10000 * 10000;
long long A[maxn];
int fir[maxn], nxt[maxn], to[maxn], D[maxn], tot;
void add_edge(int x, int y, int z) {
  nxt[++tot] = fir[x], to[fir[x] = tot] = y, D[tot] = z;
}
int weishu(long long x) {
  int op = 0;
  long long uuu = 1;
  while (x >= uuu) ++op, uuu *= 10;
  return op;
}
long long dfs(int x) {
  long long uuu = A[x];
  for (int i = fir[x], v = to[i]; i; i = nxt[i], v = to[i]) {
    long long op = dfs(v);
    if (op == -MAX) return -MAX;
    if (op >= 0) {
      uuu += op;
      if (uuu >= MAX) return -MAX;
    } else {
      if (weishu(-op) + weishu(D[i]) > 17) return -MAX;
      uuu += op * D[i];
      if (uuu <= -MAX) return -MAX;
    }
  }
  return uuu;
}
int main() {
  int N;
  scanf("%d", &N);
  for (int i = 1; i <= N; ++i) scanf("%I64d", A + i);
  for (int i = 1; i <= N; ++i) scanf("%I64d", A), A[i] -= A[0];
  for (int i = 2; i <= N; ++i) {
    int a, b;
    scanf("%d%d", &a, &b);
    add_edge(a, i, b);
  }
  puts(dfs(1) < 0 ? "NO" : "YES");
  return 0;
}
