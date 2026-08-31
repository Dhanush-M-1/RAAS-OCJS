#include <bits/stdc++.h>
using namespace std;
namespace IO {
const int sz = 1 << 15;
char inbuf[sz], outbuf[sz];
char *pinbuf = inbuf + sz;
char *poutbuf = outbuf;
inline char _getchar() {
  if (pinbuf == inbuf + sz) fread(inbuf, 1, sz, stdin), pinbuf = inbuf;
  return *(pinbuf++);
}
inline void _putchar(char x) {
  if (poutbuf == outbuf + sz) fwrite(outbuf, 1, sz, stdout), poutbuf = outbuf;
  *(poutbuf++) = x;
}
inline void flush() {
  if (poutbuf != outbuf)
    fwrite(outbuf, 1, poutbuf - outbuf, stdout), poutbuf = outbuf;
}
}  // namespace IO
inline int read() {
  int v = 0, f = 1;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    v = v * 10 + c - '0';
    c = getchar();
  }
  return v * f;
}
const int Maxn = 12567;
int n, m;
vector<int> G[Maxn];
int R[Maxn], F[Maxn];
vector<pair<pair<int, int>, int> > Ans;
int main() {
  n = read();
  m = read();
  for (int i = 0; i < m; i++) {
    int a, b;
    a = read();
    b = read();
    if (a > b) swap(a, b);
    G[b].push_back(a);
    R[a]++;
    R[b]++;
  }
  for (int i = 2; i <= n; i++) {
    set<int> S;
    int l = 0, r = 0;
    for (int j = 0; j < G[i].size(); j++) {
      int x = G[i][j];
      S.insert(R[x]);
      if (F[x])
        r++;
      else
        l++;
    }
    int t = -114514;
    for (int j = -l; j <= r; j++) {
      if (S.find(j + R[i]) == S.end()) {
        t = j;
        break;
      }
    }
    assert(t != -114514);
    int TT = t;
    for (int j = 0; j < G[i].size(); j++) {
      int x = G[i][j];
      if (F[x]) {
        if (t > 0) {
          F[x] = 0;
          Ans.push_back(make_pair(make_pair(i, x), 2));
          t--;
        } else
          Ans.push_back(make_pair(make_pair(i, x), 1));
      } else {
        if (t < 0) {
          F[x] = 1;
          Ans.push_back(make_pair(make_pair(i, x), 0));
          t++;
        } else
          Ans.push_back(make_pair(make_pair(i, x), 1));
      }
    }
    R[i] += TT;
  }
  int s = 0;
  for (int i = 1; i <= n; i++) s += F[i];
  printf("%d\n", s);
  for (int i = 1; i <= n; i++) {
    if (F[i]) {
      printf("%d ", i);
    }
  }
  printf("\n");
  for (int i = 0; i < Ans.size(); i++) {
    printf("%d %d %d\n", Ans[i].first.first, Ans[i].first.second,
           Ans[i].second);
  }
  return 0;
}
