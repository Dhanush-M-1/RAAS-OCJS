#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const long long INF = 0x3f3f3f3f3f3f3f3fLL;
const double pi = acos(-1.0);
const int maxn = 200000 + 10;
const int mod = 1e9 + 7;
inline char _getchar() {
  static const int BUFSIZE = 100001;
  static char buf[BUFSIZE];
  static char *psta = buf, *pend = buf;
  if (psta >= pend) {
    psta = buf;
    pend = buf + fread(buf, 1, BUFSIZE, stdin);
    if (psta >= pend) return -1;
  }
  return *psta++;
}
inline int read(int &x) {
  x = 0;
  int f = 1;
  char ch = _getchar();
  while ((ch < '0' || ch > '9') && ~ch) {
    if (ch == '-') f = -1;
    ch = _getchar();
  }
  if (ch == -1) return -1;
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = _getchar();
  }
  x *= f;
  return 1;
}
inline int read(long long &x) {
  x = 0;
  int f = 1;
  char ch = _getchar();
  while ((ch < '0' || ch > '9') && ~ch) {
    if (ch == '-') f = -1;
    ch = _getchar();
  }
  if (ch == -1) return -1;
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = _getchar();
  }
  x *= f;
  return 1;
}
inline int read(double &x) {
  char in;
  double Dec = 0.1;
  bool IsN = false, IsD = false;
  in = _getchar();
  if (in == EOF) return -1;
  while (in != '-' && in != '.' && (in < '0' || in > '9')) in = _getchar();
  if (in == '-') {
    IsN = true;
    x = 0;
  } else if (in == '.') {
    IsD = true;
    x = 0;
  } else
    x = in - '0';
  if (!IsD) {
    while (in = _getchar(), in >= '0' && in <= '9') {
      x *= 10;
      x += in - '0';
    }
  }
  if (in != '.') {
    if (IsN) x = -x;
    return 1;
  } else {
    while (in = _getchar(), in >= '0' && in <= '9') {
      x += Dec * (in - '0');
      Dec *= 0.1;
    }
  }
  if (IsN) x = -x;
  return 1;
}
inline int read(float &x) {
  char in;
  double Dec = 0.1;
  bool IsN = false, IsD = false;
  in = _getchar();
  if (in == EOF) return -1;
  while (in != '-' && in != '.' && (in < '0' || in > '9')) in = _getchar();
  if (in == '-') {
    IsN = true;
    x = 0;
  } else if (in == '.') {
    IsD = true;
    x = 0;
  } else
    x = in - '0';
  if (!IsD) {
    while (in = _getchar(), in >= '0' && in <= '9') {
      x *= 10;
      x += in - '0';
    }
  }
  if (in != '.') {
    if (IsN) x = -x;
    return 1;
  } else {
    while (in = _getchar(), in >= '0' && in <= '9') {
      x += Dec * (in - '0');
      Dec *= 0.1;
    }
  }
  if (IsN) x = -x;
  return 1;
}
inline int read(char *x) {
  char *tmp = x;
  char in = _getchar();
  while (in <= ' ' && in != EOF) in = _getchar();
  if (in == -1) return -1;
  while (in > ' ') *(tmp++) = in, in = _getchar();
  *tmp = '\0';
  return 1;
}
int l[maxn], r[maxn];
vector<int> nt[maxn];
vector<int> pt[maxn];
int cnt[maxn];
int vis[maxn];
int tot;
int ans[maxn];
int ok[maxn];
int n, m, k;
queue<int> q;
void Count() {
  while (!q.empty()) {
    int x = q.front();
    q.pop();
    tot--;
    for (int i = 0; i < nt[x].size(); i++) {
      int nx = nt[x][i];
      if (!vis[nx]) {
        if (!ok[pt[x][i]]) cnt[nx]--;
        if (cnt[nx] < k) q.push(nx), vis[nx] = 1;
      }
      ok[pt[x][i]] = 1;
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i < m; i++) {
    scanf("%d%d", l + i, r + i);
    nt[l[i]].push_back(r[i]), nt[r[i]].push_back(l[i]);
    pt[l[i]].push_back(i), pt[r[i]].push_back(i);
    cnt[l[i]]++, cnt[r[i]]++;
  }
  tot = n;
  for (int i = 1; i <= n; i++)
    if (cnt[i] < k) q.push(i), vis[i] = 1;
  Count();
  for (int i = m - 1; i >= 0; i--) {
    ans[i] = tot;
    ok[i] = 1;
    if ((!vis[l[i]]) && (!vis[r[i]])) {
      cnt[l[i]]--, cnt[r[i]]--;
      if (cnt[l[i]] < k) q.push(l[i]), vis[l[i]] = 1;
      if (cnt[r[i]] < k) q.push(r[i]), vis[r[i]] = 1;
      Count();
    }
  }
  for (int i = 0; i < m; i++) {
    printf("%d\n", ans[i]);
  }
  return 0;
}
