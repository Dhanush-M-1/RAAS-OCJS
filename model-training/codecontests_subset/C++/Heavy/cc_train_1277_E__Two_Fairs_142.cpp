#include <bits/stdc++.h>
using namespace std;
vector<int> ar[500004 + 2];
int coutn(int s, int bad, int n) {
  int vis[n + 2];
  memset(vis, 0, sizeof vis);
  queue<int> q;
  q.push(s);
  vis[s] = 1;
  int res = 0;
  while (!q.empty()) {
    int f = q.front();
    q.pop();
    res++;
    if (f == bad) continue;
    for (int i = 0; i < ar[f].size(); i++) {
      int x = ar[f][i];
      if (vis[x]) continue;
      vis[x] = 1;
      q.push(x);
    }
  }
  return res;
}
int main() {
  int tc;
  cin >> tc;
  while (tc--) {
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    for (int i = 1; i <= m; i++) {
      int x, y;
      cin >> x >> y;
      ar[x].push_back(y);
      ar[y].push_back(x);
    }
    long long x = n - coutn(a, b, n);
    long long y = n - coutn(b, a, n);
    cout << (x * y) << endl;
    for (int i = 0; i <= n; i++) ar[i].clear();
  }
}
