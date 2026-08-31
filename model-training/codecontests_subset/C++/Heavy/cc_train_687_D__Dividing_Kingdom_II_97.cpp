#include <bits/stdc++.h>
using namespace std;
void ga(int N, int *A) {
  for (int i(0); i < N; i++) scanf("%d", A + i);
}
struct DSU {
  int C[(1001)], G[(1001)];
  vector<int> V[(1001)];
  void con(int u, int v) {
    int b = G[u] == G[v], x;
    u = C[u], v = C[v];
    if (V[u].size() < V[v].size()) swap(u, v);
    while (!V[v].empty())
      x = V[v].back(), V[v].pop_back(), G[x] ^= b, C[x] = u, V[u].push_back(x);
  }
  void ini(int N) {
    for (int i(0); i < N; i++)
      V[i].clear(), G[i] = 0, C[i] = i, V[i].push_back(i);
  }
  int gc(int u) { return C[u]; }
  int gp(int u) { return G[u]; }
} D;
struct bs {
  long long A[(7805)];
  void clr() { (memset(A, 0, sizeof(A))); }
  void tr(int H) {
    for (int i(0); i < H >> 6; i++) A[i] = -1;
    for (int k(H - (H & 63)); k < H; k++) ad(k);
  }
  bool is(bs &r) {
    for (int i(0); i < (7805); i++)
      if (A[i] & r.A[i]) return 1;
    return 0;
  }
  void operator|=(bs &r) {
    for (int i(0); i < (7805); i++) A[i] |= r.A[i];
  }
  void operator&=(bs &r) {
    for (int i(0); i < (7805); i++) A[i] &= r.A[i];
  }
  void operator^=(bs &r) {
    for (int i(0); i < (7805); i++) A[i] ^= r.A[i];
  }
  void ad(int u) { A[u >> 6] |= 1ull << (u & 63); }
  void cg(int u) { A[u >> 6] ^= 1ull << (u & 63); }
  bool ct(int v) { return (A[v >> 6] >> (v & 63)) & 1; }
  int bt() {
    int l(0);
    for (int i(0); i < (7805); i++) l += __builtin_popcountll(A[i]);
    return l;
  }
  int xt(int u) {
    while (++u & 63)
      if ((A[u >> 6] >> (u & 63)) & 1) return u;
    while (u < (7805) << 6 && !A[u >> 6]) ++u;
    if (u == (7805) << 6) return -1;
    while (!ct(u)) ++u;
    return u;
  }
} Z;
int M, N, Q, a, b, O[(1001)], B[(499501)], E[(499501)], W[(499501)],
    H[(499501)], I[(499501)];
struct MOQ {
  int b, e, i;
  bool operator<(const MOQ &r) const {
    return b / (666) ^ r.b / (666) ? b / (666) < r.b / (666) : e < r.e;
  }
};
struct MO {
  MOQ T[(1001)];
  int C[(1001)], L, b, e;
  void CLR() { L = 0; }
  void QY(int b, int e) {
    T[L] = {min(b, e), max(b, e), L};
    ++L;
  }
  void GO(int *O) {
    (memset(C, 0, sizeof(C))), st();
    sort(T, T + L), b = T[0].b - 1, e = T[0].b - 1;
    for (int i(0); i < L; i++) {
      while (b >= T[i].b) add(b--);
      while (e < T[i].e) add(++e);
      while (b + 1 < T[i].b) del(++b);
      while (e > T[i].e) del(e--);
      O[T[i].i] = ans();
    }
  }
  void add(int w) { Z.cg(I[w]); }
  void del(int w) { Z.cg(I[w]); }
  int ans() {
    D.ini(N);
    int J = -1, x, y;
    while (666) {
      J = Z.xt(J);
      if (!~J) return -1;
      x = B[H[J]], y = E[H[J]];
      if (D.gc(x) == D.gc(y)) {
        if (D.gp(x) == D.gp(y)) return W[H[J]];
        continue;
      }
      D.con(x, y);
    }
  }
  void st() { Z.clr(); }
} T;
bool cp(int a, int b) { return W[a] > W[b]; }
int main(void) {
  scanf("%d%d%d", &N, &M, &Q), iota(H, H + M, 0), T.CLR();
  for (int i(0); i < M; i++)
    scanf("%d%d%d", B + i, E + i, W + i), --B[i], --E[i];
  sort(H, H + M, cp);
  for (int i(0); i < M; i++) I[H[i]] = i;
  for (int i(0); i < Q; i++) scanf("%d%d", &a, &b), T.QY(--a, --b);
  T.GO(O);
  for (int i(0); i < Q; i++) printf("%d\n", O[i]);
  return 0;
}
