#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    std::vector<int> gra[n + 1], grb[n + 1];
    for (int i = 0; i < m; i++) {
      int l, r;
      cin >> l >> r;
      if ((l == a or r == a) and (l == b or r == b))
        continue;
      else if (l == a or r == a) {
        gra[l].push_back(r);
        gra[r].push_back(l);
      } else if (l == b or r == b) {
        grb[l].push_back(r);
        grb[r].push_back(l);
      } else {
        gra[l].push_back(r);
        gra[r].push_back(l);
        grb[l].push_back(r);
        grb[r].push_back(l);
      }
    }
    int vis[n + 1];
    memset(vis, 0, sizeof(vis));
    queue<int> q;
    q.push(a);
    vis[a] = 1;
    long long int ca = 0;
    while (q.size()) {
      int i = q.front();
      ca++;
      q.pop();
      for (auto j : gra[i]) {
        if (!vis[j]) {
          vis[j] = 1;
          q.push(j);
        }
      }
    }
    memset(vis, 0, sizeof(vis));
    q.push(b);
    vis[b] = 1;
    long long int cb = 0;
    while (q.size()) {
      int i = q.front();
      cb++;
      q.pop();
      for (auto j : grb[i]) {
        if (!vis[j]) {
          vis[j] = 1;
          q.push(j);
        }
      }
    }
    ca = n - ca - 1;
    cb = n - cb - 1;
    ca *= cb;
    cout << ca << '\n';
  }
  return 0;
}
