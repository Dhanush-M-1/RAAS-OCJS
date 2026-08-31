#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n, m, i, j, k, t, tc, a, b, c, d, x, y, q, l, r, x0, y0, x1, y1;
  tc = 1;
  t = 1;
  int xr[] = {1, -1, 0};
  int yr[] = {1, -1, 0};
  while (tc <= t) {
    map<pair<long long int, long long int>, long long int> umap;
    cin >> x0 >> y0 >> x1 >> y1;
    cin >> n;
    umap[make_pair(x0, y0)] = 0;
    umap[make_pair(x1, y1)] = 0;
    for (k = 0; k < n; k++) {
      cin >> r >> a >> b;
      for (i = a; i <= b; i++) {
        umap[make_pair(r, i)] = 0;
      }
    }
    queue<pair<long long int, long long int>> q;
    q.push(make_pair(x0, y0));
    while (!q.empty()) {
      auto u = q.front();
      x = u.first;
      y = u.second;
      d = umap[u];
      q.pop();
      for (i = 0; i < 3; i++) {
        for (j = 0; j < 3; j++) {
          if (!(xr[i] == 0 && yr[j] == 0) &&
              umap.find(make_pair(x + xr[i], y + yr[j])) != umap.end() &&
              umap[make_pair(x + xr[i], y + yr[j])] == 0) {
            umap[make_pair(x + xr[i], y + yr[j])] = d + 1;
            q.push(make_pair(x + xr[i], y + yr[j]));
          }
        }
      }
    }
    if (umap[make_pair(x1, y1)] == 0)
      cout << "-1\n";
    else
      cout << umap[make_pair(x1, y1)] << "\n";
    tc++;
  }
}
