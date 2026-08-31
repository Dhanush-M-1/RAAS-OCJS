#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
const ll LINF = (ll)(1e18) + (ll)(1e9);
ll start_x, start_y;
ll finish_x, finish_y;
ll cntN;
int dx[] = {1, -1, -1, 1, 0, 0, -1, 1};
int dy[] = {1, 1, -1, -1, 1, -1, 0, 0};
map<pair<ll, ll>, ll> dpi;
bool get_norm_position(ll x, ll y) {
  return (1 <= x && x <= 1e9 && 1 <= y && y <= 1e9 && dpi[{x, y}]);
}
ll bfs() {
  map<pair<ll, ll>, ll> minlen;
  minlen[{start_x, start_y}] = 1;
  queue<pair<ll, ll>> que;
  que.push({start_x, start_y});
  while (!que.empty()) {
    pair<ll, ll> top = que.front();
    que.pop();
    ll ui = top.first;
    ll uj = top.second;
    for (int k = 0; k < 8; ++k) {
      ll ito = ui + dx[k];
      ll jto = uj + dy[k];
      if (get_norm_position(ito, jto)) {
        if (minlen[{ito, jto}] == 0 ||
            minlen[{ito, jto}] > minlen[{ui, uj}] + 1) {
          minlen[{ito, jto}] = minlen[{ui, uj}] + 1;
          que.push({ito, jto});
        }
      }
    }
  }
  if (minlen[{finish_x, finish_y}] == 0)
    return -1;
  else
    return minlen[{finish_x, finish_y}] - 1;
}
int main() {
  scanf("%lld%lld%lld%lld%lld", &start_x, &start_y, &finish_x, &finish_y,
        &cntN);
  while (cntN--) {
    ll r, a, b;
    scanf("%lld%lld%lld", &r, &a, &b);
    for (ll j = a; j <= b; ++j) dpi[{r, j}] = 1;
  }
  cout << bfs();
  return 0;
}
