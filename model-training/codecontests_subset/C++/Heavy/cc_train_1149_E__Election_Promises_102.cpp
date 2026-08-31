#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 50;
int n, m, h[N], f[N];
vector<int> G[N];
int d[N], S[N];
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) scanf("%d", &h[i]);
  for (int i = 1, u, v; i <= m; i++)
    scanf("%d%d", &u, &v), ++d[v], G[u].push_back(v);
  static int q[N];
  int hd = 1, tl = 0;
  for (int i = 1; i <= n; i++)
    if (d[i] == 0) q[++tl] = i;
  while (hd <= tl) {
    int x = q[hd++];
    for (int v : G[x])
      if (--d[v] == 0) q[++tl] = v;
  }
  for (int i = tl, x; i; i--) {
    x = q[i];
    static int ex[N], tim;
    ++tim;
    for (int v : G[x]) ex[f[v]] = tim;
    for (int j = 0;; j++)
      if (ex[j] != tim) {
        f[x] = j;
        break;
      }
    S[f[x]] ^= h[x];
  }
  bool ok = true;
  for (int i = 0; i <= n; i++)
    if (S[i]) ok = false;
  if (ok) return puts("LOSE"), 0;
  for (int i = n; ~i; i--)
    if (S[i]) {
      int x = 0;
      for (int j = 1; j <= n; j++)
        if (f[j] == i && (h[j] ^ S[i]) < h[j]) {
          x = j;
          break;
        }
      h[x] = h[x] ^ S[i], S[i] = 0;
      for (int v : G[x])
        if (S[f[v]]) h[v] ^= S[f[v]], S[f[v]] = 0;
    }
  puts("WIN");
  for (int i = 1; i <= n; i++) cout << h[i] << " ";
  return 0;
}
