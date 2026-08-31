#include <bits/stdc++.h>
using namespace std;
int n, k, unit, tot;
int be[(100005)], st[(100005)], en[(100005)], a[(100005)], sum[2055][2055],
    f[(100005)], pre[(100005)], now[(100005)], lazy[(100005)], S[(100005)];
const int P = 998244353;
template <typename T>
void read(T& t) {
  t = 0;
  bool fl = true;
  char p = getchar();
  while (!isdigit(p)) {
    if (p == '-') fl = false;
    p = getchar();
  }
  do {
    (t *= 10) += p - 48;
    p = getchar();
  } while (isdigit(p));
  if (!fl) t = -t;
}
inline int Inc(int a, int b) { return (a + b >= P) ? (a + b - P) : (a + b); }
void reset(int u) {
  for (int i = st[u]; i <= en[u]; i++) S[i] += lazy[u];
  lazy[u] = 0;
  int minn = S[st[u]];
  for (int i = st[u]; i <= en[u]; i++) minn = min(minn, S[i]);
  for (int i = st[u]; i <= en[u]; i++) S[i] -= minn;
  memset(sum[u], 0, sizeof(sum[u]));
  for (int i = st[u]; i <= en[u]; i++) sum[u][S[i]] = Inc(sum[u][S[i]], f[i]);
  for (int i = unit - 1; i >= 0; i--) sum[u][i] = Inc(sum[u][i], sum[u][i + 1]);
  lazy[u] = minn;
}
void change(int L, int R, int data) {
  if (be[L] == be[R]) {
    for (int i = L; i <= R; i++) S[i] += data;
    reset(be[L]);
  } else {
    for (int i = be[L] + 1; i <= be[R] - 1; i++) lazy[i] += data;
    for (int i = L; i <= en[be[L]]; i++) S[i] += data;
    reset(be[L]);
    for (int i = st[be[R]]; i <= R; i++) S[i] += data;
    reset(be[R]);
  }
}
int query(int R, int lim) {
  if (R == 0) return 0;
  int ret = 0;
  for (int i = 1; i < be[R]; i++) {
    if (lim - lazy[i] > unit) continue;
    ret = Inc(ret, sum[i][max(lim - lazy[i], 0)]);
  }
  for (int i = st[be[R]]; i <= R; i++) {
    if (S[i] + lazy[be[i]] >= lim) ret = Inc(ret, f[i]);
  }
  return ret;
}
int main() {
  read(n), read(k);
  unit = sqrt(n);
  for (int i = 1; i <= n; i++) {
    read(a[i]);
    pre[i] = now[a[i]];
    now[a[i]] = i;
  }
  for (int i = 1; i <= n; i++) {
    be[i] = (i - 1) / unit + 1;
    if (be[i] != be[i - 1]) {
      en[be[i - 1]] = i - 1;
      st[be[i]] = i;
    }
  }
  tot = be[n];
  en[tot] = n;
  f[0] = 1;
  S[0] = 0;
  for (int i = 1; i <= n; i++) {
    if (be[i - 1] != be[i])
      S[i] = S[i - 1] + 1 + lazy[be[i - 1]];
    else
      S[i] = S[i - 1] + 1;
    if (pre[pre[i]]) change(pre[pre[i]], i, 1);
    if (pre[i]) change(pre[i], i, -2);
    f[i] = query(i - 1, S[i] + lazy[be[i]] - k);
    if (S[i] + lazy[be[i]] <= k) f[i]++;
    if (i == en[be[i]]) reset(be[i]);
  }
  printf("%d", f[n]);
  return 0;
}
