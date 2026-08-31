#include <bits/stdc++.h>
using namespace std;
int n, m, a[200005], in[200005], tag[200005], sg[200005], sum[200005];
vector<int> Ef[200005], Eb[200005], tt[200005];
queue<int> q;
void tpsort() {
  for (int i = 1; i <= n; i++)
    if (!in[i]) q.push(i), tt[0].push_back(i);
  while (!q.empty()) {
    int x = q.front();
    q.pop();
    for (auto y : Eb[x]) {
      if (!(--in[y])) {
        for (auto z : Ef[y]) tag[sg[z]] = y;
        while (tag[sg[y]] == y) ++sg[y];
        q.push(y);
        tt[sg[y]].push_back(y);
      }
    }
  }
}
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1, u, v; i <= m; i++) {
    scanf("%d %d", &u, &v);
    Ef[u].push_back(v);
    Eb[v].push_back(u);
    ++in[u];
  }
  tpsort();
  for (int i = 0; i <= n; i++) {
    for (auto x : tt[i]) sum[i] ^= a[x];
  }
  for (int i = n; ~i; i--) {
    if (!sum[i]) continue;
    int id = 0;
    for (auto x : tt[i]) {
      if (a[x] > (sum[i] ^ a[x])) {
        id = x;
        break;
      }
    }
    a[id] ^= sum[i];
    for (auto y : Ef[id]) {
      a[y] ^= sum[sg[y]];
      sum[sg[y]] = 0;
    }
    puts("WIN");
    for (int j = 1; j <= n; j++) printf("%d ", a[j]);
    puts("");
    return 0;
  }
  puts("LOSE");
  return 0;
}
