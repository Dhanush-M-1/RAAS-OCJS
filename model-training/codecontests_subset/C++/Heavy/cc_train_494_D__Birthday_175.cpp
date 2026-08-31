#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline void read(T &first) {
  char c;
  bool neg = 0;
  while ((!isdigit(c = getchar())) && (c != '-'))
    ;
  if (c == '-') neg = 1, c = getchar();
  first = c - 48;
  while (isdigit(c = getchar())) first = first * 10 + c - 48;
  if (neg) first = -first;
}
template <typename T>
inline void write(T first) {
  if (first < 0) putchar('-'), first = -first;
  if (first > 9) write(first / 10);
  putchar(first % 10 + 48);
}
const long long N = 1e5, mod = 1e9 + 7;
long long n, q, Tin[N + 2], Tout[N + 2], cnt, A[N + 2], D0[N + 2], D1[N + 2],
    L[4 * N + 2], Res[N + 2];
vector<pair<long long, long long> > Z[N + 2];
pair<long long, long long> T[4 * N + 2];
vector<pair<long long, long long> > g[N + 2];
void dfs(long long u, long long dad, long long S0, long long S1) {
  Tin[u] = ++cnt;
  A[cnt] = u;
  D0[u] = S0;
  D1[u] = S1;
  for (auto &ed : g[u]) {
    long long v = ed.first;
    if (v == dad) continue;
    long long w = ed.second;
    dfs(v, u, (S0 + w) % mod, (S1 + 2 * S0 * w + w * w) % mod);
  }
  Tout[u] = cnt;
}
pair<long long, long long> operator+(const pair<long long, long long> &a,
                                     const pair<long long, long long> &b) {
  return {(a.first + b.first) % mod, (a.second + b.second) % mod};
}
void build(long long id, long long l, long long r) {
  if (l == r) {
    T[id] = {D0[A[l]], D1[A[l]]};
    return;
  }
  build((id << 1), l, ((l + r) >> 1));
  build((id << 1 | 1), ((l + r) >> 1) + 1, r);
  T[id] = T[(id << 1)] + T[(id << 1 | 1)];
}
void down(long long id, long long l, long long r) {
  if (!L[id]) return;
  long long w = L[id];
  L[id] = 0;
  T[(id << 1)].second =
      (T[(id << 1)].second + 2 * w * T[(id << 1)].first % mod +
       w * w % mod * (((l + r) >> 1) - l + 1) % mod) %
      mod;
  T[(id << 1)].first =
      (T[(id << 1)].first + w * (((l + r) >> 1) - l + 1)) % mod;
  T[(id << 1 | 1)].second =
      (T[(id << 1 | 1)].second + 2 * w * T[(id << 1 | 1)].first % mod +
       w * w % mod * (r - ((l + r) >> 1)) % mod) %
      mod;
  T[(id << 1 | 1)].first =
      (T[(id << 1 | 1)].first + w * (r - ((l + r) >> 1))) % mod;
  L[(id << 1)] = (L[(id << 1)] + w) % mod;
  L[(id << 1 | 1)] = (L[(id << 1 | 1)] + w) % mod;
}
void update(long long id, long long l, long long r, long long u, long long v,
            long long w) {
  if (l > v || r < u) return;
  if (l >= u && r <= v) {
    T[id].second =
        (T[id].second + 2 * w * T[id].first + (w * w % mod) * (r - l + 1)) %
        mod;
    T[id].first = (T[id].first + w * (r - l + 1)) % mod;
    L[id] = (L[id] + w) % mod;
    return;
  }
  down(id, l, r);
  update((id << 1), l, ((l + r) >> 1), u, v, w);
  update((id << 1 | 1), ((l + r) >> 1) + 1, r, u, v, w);
  T[id] = T[(id << 1)] + T[(id << 1 | 1)];
}
long long get(long long id, long long l, long long r, long long u,
              long long v) {
  if (l > v || r < u) return 0;
  if (l >= u && r <= v) return T[id].second;
  down(id, l, r);
  return get((id << 1), l, ((l + r) >> 1), u, v) +
         get((id << 1 | 1), ((l + r) >> 1) + 1, r, u, v);
}
void dfsto(long long u, long long dad) {
  for (auto &qu : Z[u])
    Res[qu.first] =
        2 * get(1, 1, n, Tin[qu.second], Tout[qu.second]) - get(1, 1, n, 1, n);
  for (auto &ed : g[u]) {
    long long v = ed.first;
    if (v == dad) continue;
    long long w = ed.second;
    update(1, 1, n, Tin[v], Tout[v], -w);
    update(1, 1, n, 1, Tin[v] - 1, w);
    update(1, 1, n, Tout[v] + 1, n, w);
    dfsto(v, u);
    update(1, 1, n, Tin[v], Tout[v], w);
    update(1, 1, n, 1, Tin[v] - 1, -w);
    update(1, 1, n, Tout[v] + 1, n, -w);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  read(n);
  for (long long i = (1); i <= (n - 1); ++i) {
    long long u, v, w;
    read(u);
    read(v);
    read(w);
    g[u].push_back({v, w});
    g[v].push_back({u, w});
  }
  dfs(1, 1, 0, 0);
  build(1, 1, n);
  read(q);
  for (long long i = (1); i <= (q); ++i) {
    long long u, v;
    read(u);
    read(v);
    Z[u].push_back({i, v});
  }
  dfsto(1, 1);
  for (long long i = (1); i <= (q); ++i)
    write(((Res[i] % mod) + mod) % mod), putchar('\n');
  return 0;
}
