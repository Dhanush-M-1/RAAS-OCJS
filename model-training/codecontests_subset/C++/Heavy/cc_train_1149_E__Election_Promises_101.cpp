#include <bits/stdc++.h>
using namespace std;
template <typename T1, typename T2>
inline T1 max(T1 a, T2 b) {
  return a < b ? b : a;
}
template <typename T1, typename T2>
inline T1 min(T1 a, T2 b) {
  return a < b ? a : b;
}
const char lf = '\n';
namespace ae86 {
const int bufl = 1 << 15;
char buf[bufl], *s = buf, *t = buf;
inline int fetch() {
  if (s == t) {
    t = (s = buf) + fread(buf, 1, bufl, stdin);
    if (s == t) return EOF;
  }
  return *s++;
}
inline long long ty() {
  long long a = 0;
  int b = 1, c = fetch();
  while (!isdigit(c)) b ^= c == '-', c = fetch();
  while (isdigit(c)) a = a * 10 + c - 48, c = fetch();
  return b ? a : -a;
}
}  // namespace ae86
using ae86::ty;
const int _ = 200007;
vector<int> e[_];
int n, m, sg[_], mxsg = 0;
long long val[_] = {0}, sval[_] = {0};
void dfs(int x) {
  if (sg[x] >= 0) return;
  unordered_set<int> got;
  for (auto b : e[x]) dfs(b), got.emplace(sg[b]);
  sg[x] = 0;
  while (got.count(sg[x])) sg[x]++;
  mxsg = max(mxsg, sg[x]), sval[sg[x]] ^= val[x];
}
int main() {
  ios::sync_with_stdio(0), cout.tie(nullptr);
  n = ty(), m = ty();
  for (int i = 1; i <= n; i++) val[i] = ty();
  for (int i = 1, a, b; i <= m; i++) a = ty(), b = ty(), e[a].emplace_back(b);
  memset(sg, -1, sizeof(sg));
  for (int i = 1; i <= n; i++) dfs(i);
  for (int i = mxsg; i >= 0; i--) {
    if (!sval[i]) continue;
    cout << "WIN" << lf;
    for (int j = 1; j <= n; j++) {
      if (sg[j] == i && (val[j] ^ sval[i]) < val[j]) {
        val[j] ^= sval[i], sval[i] = 0;
        for (auto b : e[j])
          if (sval[sg[b]]) val[b] ^= sval[sg[b]], sval[sg[b]] = 0;
        break;
      }
    }
    for (int j = 1; j <= n; j++) cout << val[j] << " \n"[j == n];
    return 0;
  }
  cout << "LOSE" << lf;
  return 0;
}
