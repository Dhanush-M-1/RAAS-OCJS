#include <bits/stdc++.h>
using namespace std;
inline long long getint() {
  long long ssum = 0, ff = 1;
  char ch;
  for (ch = getchar(); !isdigit(ch) && ch != '-'; ch = getchar())
    ;
  if (ch == '-') ff = -1, ch = getchar();
  for (; isdigit(ch); ch = getchar()) ssum = ssum * 10 + ch - '0';
  return ssum * ff;
}
const long long M = 2505, N = 105, mod = 1e9 + 7;
long long n, m, cnt, x[M], y[M], c[M], l[M], ty[M], Head[M], G1[N][N], G2[N][N];
long long f[N][N][2];
vector<long long> Ve[M];
queue<long long> Qu1, Qu2;
long long etot, head[M], go[M], nex[M], w[M];
bool s[M], e[M];
inline void Addedge(long long u, long long v, long long len, bool ha,
                    bool haha) {
  nex[++etot] = head[u];
  head[u] = etot;
  go[etot] = v;
  w[etot] = len;
  s[etot] = ha;
  e[etot] = haha;
}
signed main() {
  cin >> n >> m;
  for (long long i = 1; i <= m; i++) {
    l[i] = -1;
    x[i] = getint(), y[i] = getint(), c[i] = getint();
    for (long long j = 1; j <= c[i]; j++) {
      long long u = getint();
      Ve[i].push_back(u);
    }
    G1[x[i]][y[i]] = i;
    G2[y[i]][x[i]] = i;
    for (long long j = 0; j < c[i] - 1; j++)
      if (Ve[i][j] == x[i] && Ve[i][j + 1] == y[i]) l[i] = j;
    if (l[i] != -1) {
      ty[i] = 1;
      goto END1;
    }
    for (long long j = 0; j < c[i]; j++)
      if (Ve[i][j] == x[i]) l[i] = j;
    if (l[i] != -1) ty[i] = 2;
    l[i] = -1;
    for (long long j = 0; j < c[i]; j++)
      if (Ve[i][j] == y[i]) l[i] = j;
    if (l[i] != -1) {
      if (ty[i] == 2)
        ty[i] == 4;
      else
        ty[i] = 3;
      goto END1;
    }
  END1:;
  }
  for (long long i = 1; i <= m; i++) {
    long long S, E;
    if (ty[i] == 1) {
      long long tmp_len = 1;
      while (!Qu1.empty()) Qu1.pop();
      while (!Qu2.empty()) Qu2.pop();
      for (long long j = l[i] - 1; ~j; j--) Qu1.push(Ve[i][j]);
      for (long long j = l[i] + 2; j < Ve[i].size(); j++) Qu2.push(Ve[i][j]);
      S = x[i];
      while (!Qu1.empty()) {
        long long u = Qu1.front();
        Qu1.pop();
        tmp_len++;
        if (tmp_len > 2 * n) goto END2;
        if (!G2[S][u]) goto END2;
        for (vector<long long>::reverse_iterator it = Ve[G2[S][u]].rbegin();
             it != Ve[G2[S][u]].rend(); it++)
          Qu1.push(*it);
        S = u;
      }
      E = y[i];
      while (!Qu2.empty()) {
        long long u = Qu2.front();
        Qu2.pop();
        tmp_len++;
        if (tmp_len > 2 * n) goto END2;
        if (!G1[E][u]) goto END2;
        for (vector<long long>::iterator it = Ve[G1[E][u]].begin();
             it != Ve[G1[E][u]].end(); it++)
          Qu2.push(*it);
        E = u;
      }
      Addedge(S, E, tmp_len, 1, 1);
    }
    if ((ty[i] == 2 || ty[i] == 4) && *Ve[i].rbegin() == x[i]) {
      long long tmp_len = 1;
      while (!Qu1.empty()) Qu1.pop();
      for (long long j = (long long)Ve[i].size() - 2; ~j; j--) {
        Qu1.push(Ve[i][j]);
      }
      S = x[i], E = y[i];
      while (!Qu1.empty()) {
        long long u = Qu1.front();
        Qu1.pop();
        tmp_len++;
        if (tmp_len > 2 * n) goto GG;
        if (!G2[S][u]) goto GG;
        for (vector<long long>::reverse_iterator it = Ve[G2[S][u]].rbegin();
             it != Ve[G2[S][u]].rend(); it++)
          Qu1.push(*it);
        S = u;
      }
      Addedge(S, E, tmp_len, 1, 0);
    }
  GG:
    if ((ty[i] == 3 || ty[i] == 4) && *Ve[i].begin() == y[i]) {
      long long tmp_len = 1;
      while (!Qu2.empty()) Qu2.pop();
      for (long long j = 1; j < Ve[i].size(); j++) Qu2.push(Ve[i][j]);
      S = x[i], E = y[i];
      while (!Qu2.empty()) {
        long long u = Qu2.front();
        Qu2.pop();
        tmp_len++;
        if (tmp_len > 2 * n) goto END2;
        if (!G1[E][u]) goto END2;
        for (vector<long long>::iterator it = Ve[G1[E][u]].begin();
             it != Ve[G1[E][u]].end(); it++)
          Qu2.push(*it);
        E = u;
      }
      Addedge(S, E, tmp_len, 0, 1);
    }
    if (!Ve[i].size()) Addedge(x[i], y[i], 1, 0, 0);
  END2:;
  }
  for (long long i = 1; i <= n; i++) f[0][i][0] = 1;
  for (long long l = 0; l <= 2 * n; l++) {
    for (long long u = 1; u <= n; u++) {
      for (long long i = head[u]; i; i = nex[i]) {
        (f[l + w[i]][go[i]][e[i]] += f[l][u][s[i] ^ 1]) %= mod;
      }
    }
  }
  for (long long i = 1; i <= 2 * n; i++) {
    long long ans = 0;
    for (long long j = 1; j <= n; j++) (ans += f[i][j][1]) %= mod;
    cout << ans << "\n";
  }
  return 0;
}
