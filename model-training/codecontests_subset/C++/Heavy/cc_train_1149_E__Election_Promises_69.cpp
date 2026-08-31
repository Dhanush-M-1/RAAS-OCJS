#include <bits/stdc++.h>
inline long long gi() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) f ^= ch == '-', ch = getchar();
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  return f ? x : -x;
}
int h[200010], SG[200010], sum[200010];
int fir[200010], nxt[200010], dis[200010], id;
inline void link(int a, int b) { nxt[++id] = fir[a], fir[a] = id, dis[id] = b; }
int que[200010], hd = 1, tl = 1, in[200010];
int c[200010];
int main() {
  int n = gi(), m = gi(), a, b;
  for (int i = 1; i <= n; ++i) h[i] = gi();
  while (m--) a = gi(), b = gi(), link(a, b), ++in[b];
  for (int i = 1; i <= n; ++i)
    if (!in[i]) que[tl++] = i;
  while (hd ^ tl) {
    int x = que[hd++];
    for (int i = fir[x]; i; i = nxt[i])
      if (!--in[dis[i]]) que[tl++] = dis[i];
  }
  for (int o = n, x; o; --o) {
    x = que[o];
    for (int i = fir[x]; i; i = nxt[i]) ++c[SG[dis[i]]];
    while (c[SG[x]]) ++SG[x];
    sum[SG[x]] ^= h[x];
    for (int i = fir[x]; i; i = nxt[i]) --c[SG[dis[i]]];
  }
  for (int i = n, x; ~i; --i)
    if (sum[i]) {
      for (int j = 1; j <= n; ++j)
        if (SG[j] == i && h[j] > (h[j] ^ sum[i])) x = j;
      h[x] ^= sum[i];
      for (int j = fir[x]; j; j = nxt[j])
        h[dis[j]] ^= sum[SG[dis[j]]], sum[SG[dis[j]]] = 0;
      puts("WIN");
      for (int j = 1; j <= n; ++j) printf("%d ", h[j]);
      return 0;
    }
  puts("LOSE");
  return 0;
}
