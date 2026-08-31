#include <bits/stdc++.h>
using namespace std;
template <class S>
inline void read(S& arg) {
  cin >> arg;
}
template <class S>
inline void readA(S Lptr, S Rptr) {
  while (Lptr != Rptr) {
    read(*Lptr);
    Lptr++;
  }
}
template <class S, class... T>
inline void read(S& arg, T&... rest) {
  read(arg);
  read(rest...);
}
char delimiter = ' ';
template <class S>
inline void write(S arg) {
  cout << arg << '\n';
}
template <class S, class... T>
inline void write(S arg, T... rest) {
  cout << arg << delimiter;
  write(rest...);
}
template <class S>
inline void writeA(S Lptr, S Rptr) {
  while (Lptr != Rptr) {
    cout << *Lptr;
    Lptr++;
    if (Lptr != Rptr) cout << delimiter;
  }
  cout << '\n';
}
template <class T, class S>
inline bool smin(T& a, S b) {
  return (T)b < a ? a = b, 1 : 0;
}
template <class T, class S>
inline bool smax(T& a, S b) {
  return a < (T)b ? a = b, 1 : 0;
}
constexpr long long MOD = 1e9 + 7;
constexpr long long N = 1e5 + 10;
template <typename T>
inline T mod(T& v) {
  return v = (v % MOD + MOD) % MOD;
}
template <typename T>
inline long long dom(T v) {
  return (v % MOD + MOD) % MOD;
}
template <typename S, typename T>
inline S add(S& l, T r) {
  return mod(l += r);
}
long long po(long long v, long long u) {
  return u ? po(v * v % MOD, u >> 1) * (u & 1 ? v : 1) % MOD : 1;
}
long long n, a[N], b[N], A[N], B[N], q;
long long c[N], res[N];
vector<long long> adj[N], qu[N];
long long mul[N << 2], sum[N << 2], lazy[N << 2];
void shift(long long id, long long len) {
  add(mul[id], 2 * lazy[id] * sum[id] + dom(lazy[id] * lazy[id]) * len);
  add(sum[id], lazy[id] * len);
  if (len == 1) return lazy[id] = 0, void();
  add(lazy[id << 1], lazy[id]);
  add(lazy[id << 1 | 1], lazy[id]);
  lazy[id] = 0;
}
void segAdd(long long s, long long t, long long val, long long l = 0,
            long long r = n, long long id = 1) {
  shift(id, r - l);
  if (l >= t || r <= s) return;
  if (l >= s && r <= t) {
    add(lazy[id], val);
    shift(id, r - l);
    return;
  }
  long long mid = l + r >> 1;
  segAdd(s, t, val, l, mid, id << 1);
  segAdd(s, t, val, mid, r, id << 1 | 1);
  mul[id] = dom(mul[id << 1] + mul[id << 1 | 1]);
  sum[id] = dom(sum[id << 1] + sum[id << 1 | 1]);
}
long long segGet(long long s, long long t, long long l = 0, long long r = n,
                 long long id = 1) {
  shift(id, r - l);
  if (l >= t || r <= s) return 0;
  if (l >= s && r <= t) return mul[id];
  long long mid = l + r >> 1;
  return dom(segGet(s, t, l, mid, id << 1) + segGet(s, t, mid, r, id << 1 | 1));
}
long long st[N], en[N], TM;
long long d[N];
void dfs1(long long v = 0, long long par = 0) {
  st[v] = TM++;
  for (auto e : adj[v]) {
    long long u = a[e] ^ b[e] ^ v;
    if (u ^ par) {
      segAdd(TM, TM + 1, d[v] + c[e]);
      add(d[u], d[v] + c[e]);
      dfs1(u, v);
    }
  }
  en[v] = TM;
}
void dfs2(long long v = 0, long long par = 0) {
  for (auto e : qu[v]) {
    long long u = B[e];
    add(res[e], -segGet(0, n) + 2 * segGet(st[u], en[u]));
  }
  for (auto e : adj[v]) {
    long long u = a[e] ^ b[e] ^ v;
    if (u ^ par) {
      segAdd(0, n, c[e]);
      segAdd(st[u], en[u], MOD - 2 * c[e]);
      dfs2(u, v);
      segAdd(0, n, MOD - c[e]);
      segAdd(st[u], en[u], 2 * c[e]);
    }
  }
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  read(n);
  for (long long i = 1; i < (long long)n; i++) {
    read(a[i], b[i], c[i]);
    a[i]--, b[i]--;
    adj[a[i]].push_back(i);
    adj[b[i]].push_back(i);
  }
  read(q);
  for (long long i = 0; i < (long long)q; i++) {
    read(A[i], B[i]);
    A[i]--, B[i]--;
    qu[A[i]].push_back(i);
  }
  dfs1();
  dfs2();
  delimiter = '\n';
  writeA(res, res + q);
  return 0;
}
