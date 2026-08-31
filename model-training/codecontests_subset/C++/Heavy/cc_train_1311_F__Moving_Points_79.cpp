#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 1;
const int NN = 1e3 + 1;
const long long MOD = 1e9 + 7;
const long long oo = 1e18 + 7;
const int BASE = 10000;
void solve() {
  int n;
  cin >> n;
  vector<int> x(n + 1);
  for (int i = 1; i <= n; i++) {
    cin >> x[i];
  }
  vector<int> v(n + 1);
  for (int i = 1; i <= n; i++) {
    cin >> v[i];
  }
  vector<int> pos(n + 1);
  iota(1 + (pos).begin(), (pos).end(), 1);
  sort(1 + (pos).begin(), (pos).end(),
       [&](int a, int b) { return x[a] < x[b]; });
  vector<int> val = v;
  sort(1 + (val).begin(), (val).end());
  val.resize(unique((val).begin(), (val).end()) - val.begin());
  map<int, int> Pos;
  for (int i = 1; i < val.size(); i++) {
    Pos[val[i]] = i;
  }
  vector<pair<long long, long long> > BIT(val.size());
  auto update = [&](int pos, int _val) {
    for (int i = pos; i < BIT.size(); i += i & -i) {
      BIT[i].first += 1LL * _val;
      BIT[i].second++;
    }
  };
  auto get = [&](int pos) {
    long long res = 0, cnt = 0;
    for (int i = pos; i; i -= i & -i) {
      res += BIT[i].first;
      cnt += BIT[i].second;
    }
    pair<long long, long long> t = {res, cnt};
    return t;
  };
  long long res = 0;
  for (int i = 1; i <= n; i++) {
    pair<long long, long long> cur = get(Pos[v[pos[i]]]);
    res += x[pos[i]] * cur.second - cur.first;
    update(Pos[v[pos[i]]], x[pos[i]]);
  }
  cout << res;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cout.precision(10);
  solve();
  cerr << "Time elapsed: " << 1.0 * clock() / CLOCKS_PER_SEC << " s.\n";
  return 0;
}
