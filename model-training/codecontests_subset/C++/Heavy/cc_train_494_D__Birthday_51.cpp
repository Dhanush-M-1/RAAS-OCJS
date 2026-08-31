#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5, mod = 1e9 + 7;
int zrb(int a, int b) { return (1LL * a * b % mod); }
int jm(int a, int b) {
  int tmp = (a + b) % mod;
  while (tmp < 0) tmp += mod;
  return (tmp);
}
int A[N], D[N << 2], SM[N << 2], SMLZ[N << 2], P[N], ST[N], FT[N], n, st, q,
    RT[N];
struct node {
  int x, id, c;
};
vector<node> ND[N];
void build(int id = 1, int l = 0, int r = n) {
  if (r - l < 2) {
    D[id] = zrb(A[l], A[l]);
    SM[id] = A[l];
    return;
  }
  int mid = ((l + r) >> 1);
  build((id << 1), l, mid);
  build((id << 1 | 1), mid, r);
  D[id] = jm(D[(id << 1)], D[(id << 1 | 1)]);
  SM[id] = jm(SM[(id << 1)], SM[(id << 1 | 1)]);
}
void shift(int id, int l, int r) {
  int ll = (id << 1), rr = (id << 1 | 1), mid = ((l + r) >> 1);
  D[ll] = jm(D[ll], zrb(2, zrb(SM[ll], SMLZ[id])));
  D[rr] = jm(D[rr], zrb(2, zrb(SM[rr], SMLZ[id])));
  D[ll] = jm(D[ll], zrb(mid - l, zrb(SMLZ[id], SMLZ[id])));
  D[rr] = jm(D[rr], zrb(r - mid, zrb(SMLZ[id], SMLZ[id])));
  SMLZ[ll] = jm(SMLZ[ll], SMLZ[id]);
  SMLZ[rr] = jm(SMLZ[rr], SMLZ[id]);
  SM[ll] = jm(SM[ll], zrb(mid - l, SMLZ[id]));
  SM[rr] = jm(SM[rr], zrb(r - mid, SMLZ[id]));
  SMLZ[id] = 0;
}
void add(int s, int e, int d, int id = 1, int l = 0, int r = n) {
  if (s >= e) return;
  if (l >= e || r <= s) return;
  if (l >= s && r <= e) {
    int ln = r - l;
    D[id] = jm(D[id], zrb(ln, zrb(d, d)));
    D[id] = jm(D[id], zrb(2, zrb(SM[id], d)));
    SM[id] = jm(SM[id], zrb(ln, d));
    SMLZ[id] = jm(SMLZ[id], d);
    return;
  }
  int mid = ((l + r) >> 1);
  shift(id, l, r);
  add(s, e, d, (id << 1), l, mid);
  add(s, e, d, (id << 1 | 1), mid, r);
  D[id] = jm(D[(id << 1)], D[(id << 1 | 1)]);
  SM[id] = jm(SM[(id << 1)], SM[(id << 1 | 1)]);
}
int get(int s, int e, int id = 1, int l = 0, int r = n) {
  if (s >= e) return (0);
  if (l >= e || r <= s) return (0);
  if (l >= s && r <= e) return (D[id]);
  int mid = ((l + r) >> 1);
  shift(id, l, r);
  return (jm(get(s, e, (id << 1), l, mid), get(s, e, (id << 1 | 1), mid, r)));
}
vector<pair<int, int> > adj[N];
void prDFS(int u, int p, int d = 0) {
  ST[u] = st;
  A[st++] = d;
  for (pair<int, int> x : adj[u])
    if (x.first ^ p) {
      P[x.first] = x.second;
      prDFS(x.first, u, jm(d, x.second));
    }
  FT[u] = st;
}
void DFS(int u, int p) {
  for (node nd : ND[u]) {
    if (!nd.c) {
      RT[nd.id] = jm(RT[nd.id], get(ST[nd.x], FT[nd.x]));
    } else {
      RT[nd.id] = jm(RT[nd.id], -D[1]);
      RT[nd.id] = jm(RT[nd.id], get(ST[nd.x], FT[nd.x]));
    }
  }
  for (pair<int, int> x : adj[u])
    if (x.first ^ p) {
      add(ST[x.first], FT[x.first], -x.second);
      add(0, ST[x.first], x.second);
      add(FT[x.first], n, x.second);
      DFS(x.first, u);
      add(ST[x.first], FT[x.first], x.second);
      add(0, ST[x.first], -x.second);
      add(FT[x.first], n, -x.second);
    }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    int a, b, c;
    scanf("%d %d %d", &a, &b, &c);
    adj[a].push_back({b, c});
    adj[b].push_back({a, c});
  }
  prDFS(1, 0);
  build();
  scanf("%d", &q);
  for (int Q = 0; Q < q; Q++) {
    int a, b;
    scanf("%d %d", &a, &b);
    node nd = {b, Q, 0};
    ND[a].push_back(nd);
    nd = {b, Q, 1};
    ND[a].push_back(nd);
  }
  DFS(1, 0);
  for (int i = 0; i < q; i++) printf("%d\n", RT[i]);
}
