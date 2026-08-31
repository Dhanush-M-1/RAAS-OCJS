#include <bits/stdc++.h>
using namespace std;
struct edge {
  int u, v;
};
int n, m, k, f[1000000 + 1], ans[1000000 + 1], q[1000000 + 1], lq = 0, rq = -1,
                                                               cur;
edge b[1000000 + 1];
vector<int> a[1000000 + 1], e[1000000 + 1];
bool remoed[1000000 + 1], removeti[1000000 + 1];
void removequeue() {
  int x, y;
  while (lq <= rq) {
    x = q[lq];
    lq++;
    cur--;
    for (int i = 0; i < a[x].size(); i++) {
      y = a[x][i];
      if (remoed[e[x][i]] == false) {
        remoed[e[x][i]] = true;
        f[y]--;
        if (f[y] < k && removeti[y] == false) {
          rq++;
          q[rq] = y;
          removeti[y] = true;
        }
      }
    }
  }
}
void removemany() {
  for (int i = 1; i <= n; i++) {
    if (f[i] < k) {
      rq++;
      q[rq] = i;
      removeti[i] = true;
    }
  }
  removequeue();
}
void solve() {
  removemany();
  for (int i = m - 1; i >= 0; i--) {
    ans[i] = cur;
    if (remoed[i] == false) {
      remoed[i] = true;
      f[b[i].u]--;
      f[b[i].v]--;
      if (f[b[i].u] < k && removeti[b[i].u] == false) {
        rq++;
        q[rq] = b[i].u;
        removeti[b[i].u] = true;
      }
      if (f[b[i].v] < k && removeti[b[i].v] == false) {
        rq++;
        q[rq] = b[i].v;
        removeti[b[i].v] = true;
      }
    }
    removequeue();
  }
  for (int i = 0; i < m; i++) cout << ans[i] << "\n";
}
void readit() {
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    cin >> b[i].u >> b[i].v;
    a[b[i].u].push_back(b[i].v);
    a[b[i].v].push_back(b[i].u);
    e[b[i].u].push_back(i);
    e[b[i].v].push_back(i);
    f[b[i].u]++;
    f[b[i].v]++;
  }
  cur = n;
}
int main() {
  readit();
  solve();
  return 0;
}
