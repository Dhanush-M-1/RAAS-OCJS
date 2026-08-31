#include <bits/stdc++.h>
using namespace std;
int64_t n, m;
deque<int64_t> d[300001];
int64_t p[300001];
bool mark[300001];
int64_t ans;
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n >> m;
  for (int64_t i = 1; i <= n; i++) {
    int64_t x;
    cin >> x;
    p[x] = i;
  }
  for (int64_t i = 1; i <= m; i++) {
    int64_t x, y;
    cin >> x >> y;
    d[p[x]].push_back(p[y]);
  }
  mark[n] = true;
  for (int64_t i = n - 1; i >= 1; i--) {
    int64_t c = 0;
    for (int64_t j = 0; j < d[i].size(); j++) {
      if (mark[d[i][j]]) c++;
    }
    if (c + ans < n - i)
      mark[i] = true;
    else
      ans++;
  }
  cout << ans;
  return 0;
}
