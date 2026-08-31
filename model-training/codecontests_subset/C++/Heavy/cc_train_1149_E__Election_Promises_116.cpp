#include <bits/stdc++.h>
#pragma optimize("unroll-loops,no-stack-protector")
using namespace std;
namespace io {
struct eof {
  eof() {}
};
const int L = (1 << 21) | 5;
char ibuf[L], *iS, *iT, obuf[L], *oS = obuf, *oT = obuf + L - 1, c, qu[55];
int f, qr;
inline void flush() { fwrite(obuf, 1, oS - obuf, stdout), oS = obuf; }
inline void putc(char x) {
  *oS++ = x;
  if (oS == oT) flush();
}
template <class I>
inline void gi(I &x) {
  for (f = 1, c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, L, stdin),
                              (iS == iT ? EOF : *iS++))
                            : *iS++);
       (c < '0' || c > '9') && (c != EOF);
       c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, L, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++))
    if (c == '-') f = -1;
  if (c == EOF) throw eof();
  for (x = 0; c <= '9' && c >= '0';
       c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, L, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++))
    x = x * 10 + (c & 15);
  x *= f;
}
template <class I>
inline void print(I x) {
  if (!x) putc('0');
  if (x < 0) putc('-'), x = -x;
  while (x) qu[++qr] = x % 10 + '0', x /= 10;
  while (qr) putc(qu[qr--]);
}
inline void ps(const char *s) {
  int l = strlen(s), x;
  for (x = 0; x < l; x++) putc(s[x]);
}
struct IOC {
  ~IOC() { flush(); }
} ioc;
inline double readld() {
  double x = 0, y = 1;
  for (c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, L, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++);
       c < '0' || c > '9';
       c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, L, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++))
    if (c == '-') y = -1;
  assert(c != '.');
  for (; c <= '9' && c >= '0';
       c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, L, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++))
    x = x * 10 + (c & 15);
  x *= y;
  assert(c != 'e');
  if (c == '.')
    for (c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, L, stdin),
                         (iS == iT ? EOF : *iS++))
                       : *iS++);
         c <= '9' && c >= '0';
         c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, L, stdin),
                         (iS == iT ? EOF : *iS++))
                       : *iS++))
      y *= 0.1, x += y * (c & 15);
  return x;
}
inline void printld(double x, int y) {
  if (x < 0) putc('-'), x = -x;
  x += .5 * pow(.1, y);
  print((unsigned long long)x), putc('.');
  for (x -= (unsigned long long)x; y; --y)
    x *= 10, putc((int)x + '0'), x -= (int)x;
}
}  // namespace io
using io::gi;
using io::print;
using io::putc;
template <class T>
int ctz(T a) {
  return sizeof(T) > 4 ? __builtin_ctzll(a) : __builtin_ctz(a);
}
template <class T>
inline T gcd(T a, T b) {
  int shift = ctz(a | b);
  for (b >>= ctz(b), a >>= ctz(a); a; a -= b, a >>= ctz(a))
    if (a < b) swap(a, b);
  return b << shift;
}
template <class T>
void exgcd(T a, T b, T &x, T &y) {
  if (!b) return (void)(x = 1, y = 0);
  exgcd(b, a % b, y, x), y -= a / b * x;
}
template <class T>
T Inv(T a, T p) {
  T x, y;
  exgcd(a, p, x, y);
  return (x % p + p) % p;
}
inline int fpow(int a, int t, int p) {
  static int r;
  for (r = 1; t; a = (long long)a * a % p, t >>= 1)
    if (t & 1) r = (long long)r * a % p;
  return r;
}
string to_string(string s) { return '"' + s + '"'; };
string to_string(const char *s) { return to_string(string(s)); }
string to_string(bool f) { return f ? "true" : "false"; }
template <class A, class B>
string to_string(pair<A, B> p) {
  return "(" + to_string(p.first) + ", " + to_string(p.second) + ")";
}
template <class T>
string to_string(T v) {
  string s = "{", e = "";
  for (auto &x : v) s += e + to_string(x), e = ", ";
  s += "}";
  return s;
}
void debug_out() { cerr << endl; }
template <class A, class... B>
void debug_out(A x, B... y) {
  cerr << " " << to_string(x), debug_out(y...);
}
void scan() {}
template <class A, class... B>
void scan(A &a, B &...b) {
  gi(a), scan(b...);
}
template <class T>
void read(T first, T last) {
  for (; first != last; ++first) gi(*first);
}
template <class T>
void write(T first, T last) {
  for (; first != last; putc(++first == last ? '\n' : ' ')) print(*first);
}
template <class T>
void show(T x) {
  print(x), putc('\n');
}
template <class A, class... B>
void show(A a, B... b) {
  print(a), putc(' '), show(b...);
}
template <class T>
inline T abs(T x) {
  return x < 0 ? -x : x;
}
template <class T>
bool chkmin(T &x, T y) {
  return y < x ? x = y, true : false;
}
template <class T>
bool chkmax(T &x, T y) {
  return x < y ? x = y, true : false;
}
const int N = 2e5 + 5;
int n, m, in[N], sg[N];
long long h[N], layer[N];
vector<int> adj[N];
int main() {
  int u, v;
  scan(n, m);
  read(h + 1, h + n + 1);
  queue<int> q;
  vector<int> topo;
  for (int i = 1; i <= m; ++i) scan(u, v), adj[u].emplace_back(v), in[v]++;
  for (int i = 1; i <= n; ++i)
    if (!in[i]) q.push(i);
  while (q.size()) {
    u = q.front();
    topo.emplace_back(u);
    q.pop();
    for (int v : adj[u])
      if (!--in[v]) q.push(v);
  }
  reverse(topo.begin(), topo.end());
  for (int x : topo) {
    set<int> nxt;
    for (int y : adj[x]) nxt.insert(sg[y]);
    while (nxt.count(sg[x])) ++sg[x];
    layer[sg[x]] ^= h[x];
  }
  for (u = n; u >= 0; --u)
    if (layer[u]) {
      puts("WIN");
      for (v = 1; v <= n; ++v)
        if (sg[v] == u && (h[v] ^ layer[u]) < h[v]) break;
      h[v] ^= layer[u];
      layer[u] = 0;
      for (int x : adj[v]) h[x] ^= layer[sg[x]], layer[sg[x]] = 0;
      write(h + 1, h + n + 1);
      exit(0);
    }
  puts("LOSE");
}
