#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 10;
vector<int> row[MAXN], col[MAXN];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  vector<pair<int, int> > v(n);
  for (int i = 0, ThxDem = n; i < ThxDem; ++i) cin >> v[i].first >> v[i].second;
  sort(v.begin(), v.end());
  set<pair<int, int> > mp;
  for (auto x : v) mp.insert(x);
  int ans = 0;
  for (int i = 0, ThxDem = n; i < ThxDem; ++i) {
    int x = v[i].first, y = v[i].second;
    int p1 = int(row[y].size()) - 1;
    int p2 = int(col[x].size()) - 1;
    while (p1 >= 0 && p2 >= 0) {
      int dx = x - row[y][p1];
      int dy = y - col[x][p2];
      if (dx < dy)
        p1--;
      else if (dx > dy)
        p2--;
      else
        ans += mp.count({x - dx, y - dy}), p1--, p2--;
    }
    row[y].push_back(x);
    col[x].push_back(y);
  }
  cout << ans << "\n";
}
