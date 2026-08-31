#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ull = unsigned long long;
using uint = unsigned int;
const double PI =
    3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862;
const int inf_int = 1e9 + 5;
const ll inf_ll = 1e18 + 5;
const int NMax = 1e5 + 5;
bool valid(map<ll, vector<pair<ll, bool>>>& sm, ll r, ll c) {
  const vector<pair<ll, bool>>& v = sm[r];
  ll N = v.size();
  if (N == 0) {
    return false;
  }
  ll pos = -1;
  for (ll e = 30; e >= 0; --e) {
    if (pos + (1 << e) < N && v[pos + (1 << e)].first <= c) {
      pos += (1 << e);
    }
  }
  if (pos == -1) {
    return false;
  }
  if (c == v[pos].first || v[pos].second) {
    return true;
  }
  return false;
}
bool cmp(const pair<ll, bool>& a, const pair<ll, bool>& b) {
  if (a.first == b.first) {
    return a.second > b.second;
  }
  return a.first < b.first;
}
int main() {
  cin.sync_with_stdio(false);
  cin.tie(0);
  ll x0, y0, x1, y1, N;
  cin >> x0 >> y0 >> x1 >> y1 >> N;
  map<ll, vector<pair<ll, bool>>> fm;
  for (ll i = 1; i <= N; ++i) {
    ll r, a, b;
    cin >> r >> a >> b;
    fm[r].push_back({a, true});
    fm[r].push_back({b, false});
  }
  map<ll, vector<pair<ll, bool>>> sm;
  for (auto& it : fm) {
    ll r = it.first;
    vector<pair<ll, bool>>& v = it.second;
    sort(v.begin(), v.end(), cmp);
    ll start = -1, num = 0;
    for (auto p : v) {
      if (p.second == true) {
        ++num;
        if (num == 1) {
          start = p.first;
        }
      } else {
        --num;
        if (num == 0) {
          assert(start != -1);
          sm[r].push_back({start, true});
          sm[r].push_back({p.first, false});
          start = -1;
        }
      }
    }
    assert(num == 0);
  }
  struct elem {
    ll x, y, steps;
  };
  const ll dx[8] = {-1, -1, -1, 0, 0, +1, +1, +1};
  const ll dy[8] = {-1, 0, +1, -1, +1, -1, 0, +1};
  queue<elem> Q;
  map<pair<ll, ll>, bool> vis;
  vis[{x0, y0}] = true;
  Q.push({x0, y0, 0});
  while (Q.size()) {
    auto e = Q.front();
    Q.pop();
    if (e.x == x1 && e.y == y1) {
      cout << e.steps << '\n';
      return 0;
    }
    for (ll k = 0; k < 8; ++k) {
      ll nx = e.x + dx[k];
      ll ny = e.y + dy[k];
      if (!valid(sm, nx, ny) || vis[{nx, ny}]) {
        continue;
      }
      vis[{nx, ny}] = true;
      Q.push({nx, ny, e.steps + 1});
    }
  }
  cout << "-1\n";
  return 0;
}
