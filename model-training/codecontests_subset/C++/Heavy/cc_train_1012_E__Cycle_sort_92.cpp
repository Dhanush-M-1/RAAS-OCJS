#include <bits/stdc++.h>
using namespace std;
int p[200005], rk[200005];
vector<int> g[200005];
int m;
int a[200005];
int b[200005];
int uq[200005];
bool used[200005];
vector<int> cycles[200005];
void dfs(int u) {
  while (!g[u].empty()) {
    int i = g[u].back();
    g[u].pop_back();
    dfs(a[i]);
    cycles[m].push_back(i);
  }
}
int main() {
  int n, s;
  cin >> n >> s;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    b[i] = a[i];
  }
  sort(b, b + n);
  int k = n;
  for (int i = 0; i < n; i++) uq[i] = b[i];
  k = unique(uq, uq + n) - uq;
  for (int i = 0; i < n; i++) {
    a[i] = lower_bound(uq, uq + k, a[i]) - uq;
    b[i] = lower_bound(uq, uq + k, b[i]) - uq;
  }
  for (int i = 0; i < n; i++) {
    if (a[i] == b[i]) continue;
    g[b[i]].push_back(i);
  }
  for (int i = 0; i < k; i++) {
    dfs(i);
    if (!cycles[m].empty()) m++;
  }
  for (int i = 0; i < m; i++) {
    s -= cycles[i].size();
  }
  if (s < 0) {
    cout << "-1";
    return 0;
  }
  for (int i = 0; i < n; i++) p[i] = i;
  for (int id = 0; id < m; id++) {
    for (int i = 0; i < (int)cycles[id].size(); i++) {
      int v = cycles[id][i], u = cycles[id][(i + 1) % (int)cycles[id].size()];
      p[u] = v;
    }
  }
  s = min(s, m);
  if (s > 1) {
    cout << 2 + m - s << endl;
    cout << s << endl;
    for (int i = 0; i < s; i++) {
      cout << cycles[i][0] + 1 << " ";
    }
    cout << endl;
    for (int i = s - 1; i > 0; i--) swap(p[cycles[i][0]], p[cycles[i - 1][0]]);
  } else
    cout << m << endl;
  for (int i = 0; i < n; i++) {
    if (used[i]) continue;
    if (p[i] == i) {
      used[i] = 1;
      continue;
    }
    vector<int> cur;
    int x = i;
    while (!used[x]) {
      cur.push_back(x);
      used[x] = 1;
      x = p[x];
    }
    printf("%d\n", (int)cur.size());
    for (int z : cur) printf("%d ", z + 1);
    printf("\n");
  }
}
