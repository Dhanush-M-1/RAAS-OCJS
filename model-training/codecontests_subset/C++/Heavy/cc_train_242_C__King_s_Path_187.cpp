#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long power(long long x, long long y) {
  long long res = 1;
  while (y > 0) {
    if (y & 1) res = res * x;
    y = y >> 1;
    x = x * x;
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  long long n;
  cin >> n;
  long long r, a, b;
  std::map<pair<long long, long long>, long long> dis, m;
  for (long long i = 0; i < n; ++i) {
    cin >> r >> a >> b;
    for (long long j = a; j <= b; j++) m[{r, j}]++;
  }
  set<pair<long long, pair<long long, long long>>> s;
  s.insert({0, {x0, y0}});
  dis[{x0, y0}] = 0;
  long long xx[8] = {0, 1, -1, 0, 1, 1, -1, -1};
  long long yy[8] = {1, 0, 0, -1, 1, -1, 1, -1};
  while (!s.empty()) {
    pair<long long, pair<long long, long long>> itr = *(s.begin());
    long long diss = itr.first;
    long long x = itr.second.first;
    long long y = itr.second.second;
    s.erase(s.begin());
    if (x == x1 && y == y1) break;
    for (long long i = 0; i < 8; ++i) {
      long long xt = x + xx[i];
      long long yt = y + yy[i];
      if (m.find({xt, yt}) != m.end() && dis.find({xt, yt}) == dis.end()) {
        dis[{xt, yt}] = diss + 1;
        s.insert({diss + 1, {xt, yt}});
      }
    }
  }
  if (dis.find({x1, y1}) == dis.end())
    cout << -1 << "\n";
  else
    cout << dis[{x1, y1}] << "\n";
  return 0;
}
