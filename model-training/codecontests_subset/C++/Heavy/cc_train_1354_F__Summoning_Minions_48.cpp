#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using Vi = vector<int>;
using Pii = pair<int, int>;
int uplg(int n) { return 32 - __builtin_clz(n); }
int uplg(ll n) { return 64 - __builtin_clzll(n); }
void run();
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  cout << fixed << setprecision(18);
  run();
  return 0;
}
ll dp[80][80];
bool take[80][80];
ll check(int k, const vector<Pii>& elems) {
  for (int i = (0); i < (80); i++)
    for (int j = (0); j < (80); j++) dp[i][j] = -1e12;
  dp[0][0] = 0;
  for (int pref = (1); pref < (int((elems).size()) + 1); pref++) {
    auto e = elems[pref - 1];
    for (int taken = (0); taken < (k + 1); taken++) {
      dp[pref][taken] = dp[pref - 1][taken] + k * e.second;
      take[pref][taken] = 0;
      if (taken > 0) {
        ll alt = dp[pref - 1][taken - 1] + e.first + (taken - 1) * e.second;
        if (alt > dp[pref][taken]) {
          dp[pref][taken] = alt;
          take[pref][taken] = 1;
        }
      }
      if (dp[pref][taken] < 0) {
        dp[pref][taken] = -1e12;
      }
    }
  }
  return dp[int((elems).size())][k];
}
void solve() {
  int n, k;
  cin >> n >> k;
  vector<pair<Pii, int>> elems(n);
  for (int i = (0); i < (n); i++) elems[i].second = i;
  for (auto& e : (elems)) cin >> e.first.first >> e.first.second;
  sort((elems).begin(), (elems).end(), [](pair<Pii, int> l, pair<Pii, int> r) {
    return l.first.second < r.first.second;
  });
  vector<Pii> tmp;
  int bestI = -1;
  ll ans = -1;
  for (int i = (0); i < (n); i++) {
    tmp.clear();
    for (int j = (0); j < (n); j++)
      if (j != i) tmp.push_back(elems[j].first);
    ll alt = check(k - 1, tmp);
    alt += elems[i].first.first + elems[i].first.second * (k - 1);
    if (alt > ans) {
      ans = alt;
      bestI = i;
    }
  }
  Vi ind;
  tmp.clear();
  for (int j = (0); j < (n); j++)
    if (j != bestI)
      tmp.push_back(elems[j].first), ind.push_back(elems[j].second);
  ll alt = check(k - 1, tmp);
  alt += elems[bestI].first.first + elems[bestI].first.second * (k - 1);
  assert(alt == ans);
  Vi toTake, toDel;
  int pref = int((tmp).size()), taken = k - 1;
  while (pref > 0) {
    if (take[pref][taken]) {
      toTake.push_back(ind[pref - 1]);
      taken--;
    } else {
      toDel.push_back(ind[pref - 1]);
    }
    pref--;
  }
  reverse((toTake).begin(), (toTake).end());
  reverse((toDel).begin(), (toDel).end());
  Vi moves;
  for (auto& t : (toTake)) moves.push_back(t + 1);
  for (auto& t : (toDel)) {
    moves.push_back(t + 1);
    moves.push_back(-t - 1);
  }
  moves.push_back(elems[bestI].second + 1);
  cout << int((moves).size()) << '\n';
  for (auto& e : (moves)) cout << e << ' ';
  cout << '\n';
}
void run() {
  int t;
  cin >> t;
  while (t--) solve();
}
