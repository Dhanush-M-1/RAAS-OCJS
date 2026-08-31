#include <bits/stdc++.h>
using namespace std;
int N, K, D, Q, st[200005], Dep[200005], Dis[200005], C[20][20], F[20][200005];
struct Lin {
  int v, c, next;
} E[200005];
struct Nod {
  int A[20];
  Nod() { memset(A, 0, sizeof(A)); }
  Nod operator*(int k) {
    Nod c;
    k = (k + 1000000007) % 1000000007;
    for (int i = 0; i <= K; i++)
      for (int j = i, x = 1; j + 1; j--)
        (c.A[i] += 1ll * x * A[j] % 1000000007 * C[i][j] % 1000000007) %=
            1000000007,
            x = 1ll * x * k % 1000000007;
    return c;
  }
  Nod operator+(const Nod& b) {
    Nod c;
    for (int i = 0; i <= K; i++) c.A[i] = (A[i] + b.A[i]) % 1000000007;
    return c;
  }
  Nod operator-(const Nod& b) {
    Nod c;
    for (int i = 0; i <= K; i++)
      c.A[i] = (A[i] - b.A[i] + 1000000007) % 1000000007;
    return c;
  }
} A[200005], T[200005];
int IN() {
  int x = 0, ch;
  for (; (ch = getchar()) < '0' || ch > '9';)
    ;
  for (; ch >= '0' && ch <= '9'; (ch = getchar())) (x *= 10) += ch - '0';
  return x;
}
void Link(int c = IN(), int v = IN(), int u = IN()) {
  E[++D] = (Lin){v, c, st[u]};
  st[u] = D;
  E[++D] = (Lin){u, c, st[v]};
  st[v] = D;
}
void Pre(int u, int f) {
  T[u].A[0] = 1;
  F[0][u] = f;
  Dep[u] = Dep[f] + 1;
  for (int i = st[u], v; i; i = E[i].next)
    if ((v = E[i].v) ^ f) Pre(v, u), T[u] = T[u] + T[v] * E[i].c;
  A[u] = T[u];
}
void DFS(int u, int f, Nod t) {
  T[u] = T[u] + t;
  for (int i = st[u], v; i; i = E[i].next)
    if ((v = E[i].v) ^ f) {
      Dis[v] = (Dis[u] + E[i].c) % 1000000007;
      DFS(v, u, (T[u] - T[v] * E[i].c) * E[i].c);
    }
}
int LCA(int u, int v) {
  if (Dep[u] > Dep[v]) swap(u, v);
  for (int i = 16, d = Dep[v] - Dep[u]; i + 1; i--)
    if ((1 << i) & d) v = F[i][v];
  if (u == v) return u;
  for (int i = 16; i + 1; i--)
    if (F[i][u] != F[i][v]) u = F[i][u], v = F[i][v];
  return F[0][u];
}
int main() {
  N = IN();
  K = 2;
  for (int i = 2; i <= N; i++) Link();
  for (int i = 0; i <= K; i++) {
    C[i][0] = 1;
    for (int j = 1; j <= i; j++) C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
  }
  Pre(1, 0);
  DFS(1, 0, Nod());
  for (int i = 1; i <= 16; i++)
    for (int j = 1; j <= N; j++) F[i][j] = F[i - 1][F[i - 1][j]];
  for (Q = IN(); Q--;) {
    int u = IN(), v = IN(), x = 2, z = LCA(u, v);
    if (z == v) {
      Nod t = (T[v] - A[v]) * ((Dis[u] + Dis[v] - 2 * Dis[z]) % 1000000007);
      printf("%d\n", (T[u] - t - t).A[x]);
    } else {
      Nod t = A[v] * ((Dis[u] + Dis[v] - 2 * Dis[z]) % 1000000007);
      printf("%d\n", (t + t - T[u]).A[x]);
    }
  }
}
