#include <bits/stdc++.h>
using namespace std;
const int mod = 998244353, N = 210000;
int n, m, dgr[N], cnt, rev[N], lev[N];
long long a[N], sum[N];
vector<int> to[N], pos[N];
priority_queue<int, vector<int>, greater<int> > que;
inline void addEdg(int x, int y) {
  to[x].push_back(y), ++dgr[y];
  return;
}
void topoSort() {
  queue<int> que;
  for (register int i = 1; i <= n; ++i)
    if (!dgr[i]) que.push(i);
  while (que.size()) {
    int now = que.front();
    que.pop(), rev[++cnt] = now;
    for (auto &v : to[now])
      if (!--dgr[v]) que.push(v);
  }
  return;
}
inline int addMod(int a, int b) { return (a += b) >= mod ? a - mod : a; }
inline long long quickpow(long long base, long long pw) {
  long long ret = 1;
  while (pw) {
    if (pw & 1) ret = ret * base % mod;
    base = base * base % mod, pw >>= 1;
  }
  return ret;
}
template <class T>
inline void read(T &x) {
  x = 0;
  char ch = getchar(), w = 0;
  while (!isdigit(ch)) w = (ch == '-'), ch = getchar();
  while (isdigit(ch)) x = (x << 1) + (x << 3) + (ch ^ 48), ch = getchar();
  x = w ? -x : x;
  return;
}
int main() {
  int x, y;
  read(n), read(m);
  for (register int i = 1; i <= n; ++i) read(a[i]);
  for (register int i = 1; i <= m; ++i) read(x), read(y), addEdg(x, y);
  topoSort();
  for (register int i = n; i; --i) {
    int now = rev[i];
    while (que.size()) que.pop();
    for (auto &v : to[now]) que.push(lev[v]);
    while (que.size()) {
      while (que.size() && que.top() != lev[now]) que.pop();
      if (que.size()) ++lev[now];
    }
    sum[lev[now]] ^= a[now];
    pos[lev[now]].push_back(now);
  }
  for (register int i = n; ~i; --i) {
    if (!sum[i]) continue;
    printf("WIN\n");
    int maxP = 0;
    for (auto &v : pos[i])
      if ((a[v] & sum[i]) >= (a[maxP] & sum[i])) maxP = v;
    a[maxP] ^= sum[i];
    for (auto &v : to[maxP]) a[v] ^= sum[lev[v]], sum[lev[v]] = 0;
    for (register int j = 1; j <= n; ++j) printf("%lld ", a[j]);
    return 0;
  }
  printf("LOSE\n");
  return 0;
}
