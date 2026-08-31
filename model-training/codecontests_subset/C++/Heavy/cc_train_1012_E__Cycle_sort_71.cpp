#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
struct fastio {
  char s[100000];
  int it, len;
  fastio() { it = len = 0; }
  inline char get() {
    if (it < len) return s[it++];
    it = 0;
    len = fread(s, 1, 100000, stdin);
    if (len == 0)
      return EOF;
    else
      return s[it++];
  }
  bool notend() {
    char c = get();
    while (c == ' ' || c == '\n') c = get();
    if (it > 0) it--;
    return c != EOF;
  }
} _buff;
inline long long getnum() {
  long long r = 0;
  bool ng = 0;
  char c;
  c = _buff.get();
  while (c != '-' && (c < '0' || c > '9')) c = _buff.get();
  if (c == '-') ng = 1, c = _buff.get();
  while (c >= '0' && c <= '9') r = r * 10 + c - '0', c = _buff.get();
  return ng ? -r : r;
}
template <class T>
inline void putnum(T x) {
  if (x < 0) putchar('-'), x = -x;
  register short a[20] = {}, sz = 0;
  while (x) a[sz++] = x % 10, x /= 10;
  if (sz == 0) putchar('0');
  for (int i = sz - 1; i >= 0; i--) putchar('0' + a[i]);
}
inline char getreal() {
  char c = _buff.get();
  while (c <= 32) c = _buff.get();
  return c;
}
long long qpow(long long x, long long k) {
  return k == 0 ? 1
                : 1ll * qpow(1ll * x * x % mod, k >> 1) * (k & 1 ? x : 1) % mod;
}
const int maxn = 200111;
int n, m, tot;
int a[maxn], b[maxn], it[maxn];
map<int, int> mpid;
vector<pair<int, int>> con[maxn];
vector<vector<int>> cyc, ans;
vector<int> cur;
void dfs(int x) {
  for (int &i = it[x]; i < con[x].size();) {
    int u = con[x][i].first, id = con[x][i].second;
    i++;
    dfs(u);
    cur.push_back(id);
  }
}
int main() {
  n = getnum(), m = getnum();
  for (int i = 1; i <= n; i++) {
    a[i] = getnum();
    b[i] = a[i];
  }
  sort(b + 1, b + n + 1);
  for (int i = 1; i <= n; i++) {
    int &id = mpid[b[i]];
    if (id == 0) id = ++tot;
    b[i] = id;
  }
  for (int i = 1; i <= n; i++) a[i] = mpid[a[i]];
  for (int i = 1; i <= n; i++) {
    if (a[i] == b[i]) continue;
    con[a[i]].push_back(make_pair(b[i], i));
  }
  for (int i = 1; i <= tot; i++) it[i] = 0;
  int sum = 0;
  for (int i = 1; i <= tot; i++) {
    if (con[i].size() > 0 && it[i] < con[i].size()) {
      cur.clear();
      dfs(i);
      cyc.push_back(cur);
      sum += cur.size();
    }
  }
  if (sum > m) {
    puts("-1");
    return 0;
  }
  int mx = -1;
  for (int i = 1; i < cyc.size(); i++) {
    if (sum + 1 + i <= m) {
      mx = i;
    }
  }
  if (mx != -1) {
    vector<int> v;
    for (int i = 0; i <= mx; i++) {
      for (int j = 0; j < cyc[i].size(); j++) {
        v.push_back(cyc[i][j]);
      }
    }
    ans.push_back(v);
    v.clear();
    for (int i = 0; i <= mx; i++) v.push_back(cyc[i][0]);
    reverse(v.begin(), v.end());
    ans.push_back(v);
  } else {
    for (int i = 0; i <= mx; i++) ans.push_back(cyc[i]);
  }
  for (int i = mx + 1; i < cyc.size(); i++) ans.push_back(cyc[i]);
  putnum(ans.size()), putchar('\n');
  for (int i = 0; i < ans.size(); i++) {
    putnum(ans[i].size()), putchar('\n');
    for (auto x : ans[i]) putnum(x), putchar(' ');
    puts("");
  }
  return 0;
}
