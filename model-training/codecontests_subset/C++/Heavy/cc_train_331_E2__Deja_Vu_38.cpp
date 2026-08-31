#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC optimize("inline", "fast-math", "unroll-loops", \
                     "no-stack-protector")
#pragma GCC target("popcnt,tune=native")
using namespace std;
namespace io {
const int SIZE = (1 << 21) + 1;
char ibuf[SIZE], *iS, *iT, obuf[SIZE], *oS = obuf, *oT = oS + SIZE - 1, c,
                                       qu[55];
int f, qr;
inline void flush() {
  fwrite(obuf, 1, oS - obuf, stdout);
  oS = obuf;
}
inline void putc(char x) {
  *oS++ = x;
  if (oS == oT) flush();
}
template <class T>
inline void getc(T &x) {
  for (c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++);
       !((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') ||
         (c >= 'A' && c <= 'Z'));
       c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++))
    ;
  x = c;
}
template <class I>
inline void rd(I &x) {
  for (f = 1, c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                              (iS == iT ? EOF : *iS++))
                            : *iS++);
       c < '0' || c > '9';
       c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++))
    if (c == '-') f = -1;
  for (x = 0; c <= '9' && c >= '0';
       c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
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
struct Flusher_ {
  ~Flusher_() { flush(); }
} io_flusher_;
}  // namespace io
using io ::getc;
using io ::print;
using io ::putc;
using io ::rd;
const int MAXN = 100 + 5;
const int MOD = 1e9 + 7;
int mo(int x, int y) { return (x + y) >= MOD ? (x + y - MOD) : (x + y); }
int sub(int x, int y) { return x < y ? (x - y + MOD) : (x - y); }
int ksm(int x, int y) {
  int res = 1;
  for (; y; y >>= 1, x = 1ll * x * x % MOD)
    if (y & 1) res = 1ll * res * x % MOD;
  return res;
}
void fix(int &x, const int &v) { x = (x + v) >= MOD ? (x + v - MOD) : (x + v); }
int n, m;
bool vis[MAXN][MAXN];
vector<int> e[MAXN][MAXN];
void add(int x, int y, vector<int> t) {
  vis[x][y] = 1;
  e[x][y] = t;
}
struct Node {
  vector<int> g[MAXN][MAXN];
  vector<int> solvemid() {
    vector<int> nxt, res, now;
    for (int x = 1; x <= n; x++)
      for (int y = 1; y <= n; y++)
        for (int i = 0; i + 1 < e[x][y].size(); i++)
          if (e[x][y][i] == x && e[x][y][i + 1] == y) {
            now.clear();
            nxt = e[x][y];
            bool flag = 1;
            do {
              now = nxt;
              nxt.clear();
              flag = (now.size() <= (2 * n + 1));
              for (int i = 0; i + 1 < now.size() && flag; i++) {
                if (!vis[now[i]][now[i + 1]]) {
                  flag = 0;
                  break;
                }
                nxt.insert(nxt.end(), e[now[i]][now[i + 1]].begin(),
                           e[now[i]][now[i + 1]].end());
              }
            } while (flag && now != nxt);
            if (flag) {
              if (!res.size()) res = nxt;
              g[nxt[0]][nxt.back()].push_back(nxt.size() - 1);
            }
            break;
          }
    return res;
  }
  void solvefront() {
    vector<int> nxt, res, now, Cnt;
    for (int x = 1; x <= n; x++)
      for (int y = 1; y <= n; y++)
        if (e[x][y].size() && e[x][y].back() == x) {
          now.clear();
          nxt.clear();
          nxt.push_back(x);
          bool flag = 1;
          do {
            now = nxt;
            nxt.clear();
            flag = (now.size() <= (2 * n + 1));
            nxt = e[now[0]][y];
            reverse(nxt.begin(), nxt.end());
            for (int i = 0; i + 1 < now.size() && flag; i++) {
              if (!vis[now[i + 1]][now[i]]) {
                flag = 0;
                break;
              }
              nxt.insert(nxt.end(), e[now[i + 1]][now[i]].rbegin(),
                         e[now[i + 1]][now[i]].rend());
            }
          } while (flag && now != nxt);
          if (flag) g[nxt.back()][y].push_back(nxt.size());
        }
  }
  void solveend() {
    vector<int> nxt, res, now, Cnt;
    for (int x = 1; x <= n; x++)
      for (int y = 1; y <= n; y++)
        if (e[x][y].size() && e[x][y][0] == y) {
          now.clear();
          nxt.clear();
          nxt.push_back(y);
          bool flag = 1;
          do {
            now = nxt;
            nxt.clear();
            flag = (now.size() <= (2 * n + 1));
            nxt = e[x][now[0]];
            for (int i = 0; i + 1 < now.size() && flag; i++) {
              if (!vis[now[i]][now[i + 1]]) {
                flag = 0;
                break;
              }
              nxt.insert(nxt.end(), e[now[i]][now[i + 1]].begin(),
                         e[now[i]][now[i + 1]].end());
            }
          } while (flag && now != nxt);
          if (flag) g[x][nxt.back()].push_back(nxt.size());
        }
  }
  int dp[MAXN][MAXN][MAXN];
  void solveA() {
    for (int i = 1; i <= n; i++) dp[i][i][0] = 1;
    for (int i = 0; i <= n * 2; i++)
      for (int s = 1; s <= n; s++)
        for (int l = 1; l <= n; l++)
          for (int r = 1; r <= n; r++)
            for (auto &len : g[l][r])
              if (i + len <= 2 * n + 1) fix(dp[s][r][i + len], dp[s][l][i]);
  }
} A, B, C;
int dp[MAXN][MAXN][MAXN], dp0[MAXN][MAXN][MAXN], ans[MAXN][MAXN];
int main() {
  rd(n);
  rd(m);
  for (int i = 1, a, b, K; i <= m; i++) {
    rd(a);
    rd(b);
    rd(K);
    vector<int> v;
    v.resize(K);
    for (int i = 0; i < K; i++) rd(v[i]);
    add(a, b, v);
  }
  A.solvefront();
  vector<int> res = B.solvemid();
  C.solveend();
  A.solveA();
  for (int i = 0; i <= n * 2; i++)
    for (int s = 1; s <= n; s++)
      for (int l = 1; l <= n; l++)
        for (int r = 1; r <= n; r++)
          for (auto &len : B.g[l][r])
            if (i + len <= 2 * n) fix(dp[s][r][i + len], A.dp[s][l][i]);
  for (int i = 0; i <= n * 2; i++)
    for (int s = 1; s <= n; s++)
      for (int l = 1; l <= n; l++)
        for (int r = 1; r <= n; r++)
          for (auto &len : C.g[l][r])
            if (i + len <= 2 * n) fix(dp[s][r][i + len], dp[s][l][i]);
  for (int l = 1; l <= n; l++)
    for (int mid = 1; mid <= n; mid++)
      if (vis[l][mid] && e[l][mid].empty())
        for (int r = 1; r <= n; r++)
          for (int i = 0; i + 1 <= 2 * n; i++)
            fix(dp0[l][r][i + 1], dp[mid][r][i]);
  for (int l = 1; l <= n; l++)
    for (int r = 1; r <= n; r++)
      for (int len = 1; len <= 2 * n; len++) fix(ans[r][len], dp[l][r][len]);
  for (int i = 1; i <= 2 * n; i++)
    for (int l = 1; l <= n; l++)
      for (int r = 1; r <= n; r++)
        for (int len = 1; len + i <= 2 * n; len++)
          fix(ans[r][len + i], 1ll * ans[l][i] * dp0[l][r][len] % MOD);
  for (int i = 1; i <= 2 * n; i++) {
    int aa = 0;
    for (int s = 1; s <= n; s++) fix(aa, ans[s][i]);
    print(aa);
    putc('\n');
  }
  return 0;
}
