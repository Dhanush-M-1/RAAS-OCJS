#include <bits/stdc++.h>
using namespace std;
const int N = 100001;
vector<int> a[N], b[N];
int ans, x, y, p1, p2, pos[N], n, m, i, j, q, w;
map<pair<int, int>, int> have;
int main() {
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> q >> w;
    a[q].push_back(w);
    b[w].push_back(q);
    have[make_pair(q, w)] = 1;
  }
  for (i = 0; i < N; i++) {
    sort(a[i].begin(), a[i].end());
    sort(b[i].begin(), b[i].end());
  }
  for (x = 0; x < N; x++)
    for (i = 0; i < a[x].size(); i++) {
      y = a[x][i];
      p1 = i + 1;
      p2 = pos[y] + 1;
      while (p1 < a[x].size() && p2 < b[y].size()) {
        if (a[x][p1] - y == b[y][p2] - x && have[make_pair(b[y][p2], a[x][p1])])
          ans++;
        if (a[x][p1] - y < b[y][p2] - x)
          p1++;
        else
          p2++;
      }
    }
  cout << ans << endl;
}
