#include <bits/stdc++.h>
using namespace std;
long long int power(long long int x, long long int y, long long int p) {
  long long int r = 1;
  x = x % p;
  while (y) {
    if (y & 1) r = r * x % p;
    y = y >> 1;
    x = x * x % p;
  }
  return r;
}
const int N = 1e5 + 99;
vector<pair<int, int> > Points(N);
unordered_set<int> X[N], Y[N];
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> Points[i].first >> Points[i].second;
    X[Points[i].first].insert(Points[i].second);
    Y[Points[i].second].insert(Points[i].first);
  }
  long long int ans = 0;
  for (int i = 0; i < n; i++) {
    int x = Points[i].first, y = Points[i].second;
    if (X[x].size() <= Y[y].size()) {
      for (auto yy : X[x]) {
        if (yy - y <= 0) continue;
        int ss = yy - y;
        if (Y[yy].count(x + ss) && Y[y].count(x + ss)) ans++;
      }
      continue;
    }
    for (auto xx : Y[y]) {
      if (xx - x <= 0) continue;
      int ss = xx - x;
      if (X[xx].count(y + ss) && X[x].count(y + ss)) ans++;
    }
  }
  cout << ans << '\n';
}
