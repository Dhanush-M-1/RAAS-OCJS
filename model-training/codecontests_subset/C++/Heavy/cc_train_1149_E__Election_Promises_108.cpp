#include <bits/stdc++.h>
using namespace std;
int n, m, h[200205];
int info[200205], Prev[200205], to[200205], cnt_e;
void Node(int u, int v) {
  Prev[++cnt_e] = info[u], info[u] = cnt_e, to[cnt_e] = v;
}
int in[200205], Q[200205], L, R, SG[200205], S[200205];
int vis[200205], tim, Mx;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &h[i]);
  for (int i = 1, u, v; i <= m; i++) scanf("%d%d", &u, &v), Node(u, v), in[v]++;
  for (int i = 1; i <= n; i++)
    if (!in[i]) Q[R++] = i;
  for (int now; L < R;) {
    now = Q[L++];
    for (int i = info[now]; i; i = Prev[i]) {
      in[to[i]]--;
      if (!in[to[i]]) Q[R++] = to[i];
    }
  }
  for (int i = R - 1; i >= 0; i--) {
    tim++;
    int u = Q[i];
    for (int j = info[u]; j; j = Prev[j]) vis[SG[to[j]]] = tim;
    for (SG[u] = 0; vis[SG[u]] == tim; SG[u]++)
      ;
    S[SG[u]] ^= h[u];
  }
  bool flg = 0;
  for (int i = 0; i <= n; i++)
    if (S[i] != 0) flg = 1;
  if (!flg)
    puts("LOSE");
  else {
    puts("WIN");
    int loc = 0, Maxloc = 0;
    for (int i = n; i >= 0; i--)
      if (S[i] != 0) {
        loc = i;
        break;
      }
    for (int i = 1; i <= n; i++)
      if (SG[i] == loc && (S[loc] ^ h[i]) < h[i]) Maxloc = i;
    h[Maxloc] ^= S[loc];
    for (int i = info[Maxloc]; i; i = Prev[i])
      h[to[i]] ^= S[SG[to[i]]], S[SG[to[i]]] = 0;
    for (int i = 1; i <= n; i++) printf("%d%c", h[i], i == n ? '\n' : ' ');
  }
}
