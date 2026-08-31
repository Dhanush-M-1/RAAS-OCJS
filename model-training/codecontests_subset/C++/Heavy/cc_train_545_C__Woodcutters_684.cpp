#include <bits/stdc++.h>
#pragma optimization_level 3
#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops,fast-math,O3")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx")
using namespace std;
const int N = 2e6 + 5;
const int mod = 1e9 + 7;
const long long INF = 0x7f7f7f7f7f7f7f7f;
const int INFi = 0x7f7f7f7f;
const int LEVEL = log2(N) + 1;
long long test = 1, n, ans = 0;
vector<pair<long long, long long> > points;
void solve() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int x, h;
    cin >> x >> h;
    points.push_back({x, h});
  }
  points.push_back({INF, 0});
  long long last = -INF;
  sort(points.begin(), points.end());
  for (int i = 0; i < n; i++) {
    if (points[i].first - points[i].second > last) {
      ans++;
      last = points[i].first;
    } else if (points[i].first + points[i].second < points[i + 1].first) {
      ans++;
      last = points[i].first + points[i].second;
    } else
      last = points[i].first;
  }
  cout << ans << "\n";
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cout << fixed;
  cout << setprecision(15);
  ;
  for (int i = 1; i <= test; i++) {
    solve();
  }
}
