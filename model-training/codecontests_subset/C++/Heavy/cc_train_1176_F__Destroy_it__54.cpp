#include <bits/stdc++.h>
using namespace std;
const int d4i[4] = {-1, 0, 1, 0}, d4j[4] = {0, 1, 0, -1};
const int d8i[8] = {-1, -1, 0, 1, 1, 1, 0, -1},
          d8j[8] = {0, 1, 1, 1, 0, -1, -1, -1};
void DBG() { cout << "]" << endl; }
template <class H, class... T>
void DBG(H h, T... t) {
  cout << to_string(h);
  if (sizeof...(t)) cout << ", ";
  DBG(t...);
}
template <class T>
bool umin(T& a, const T& b) {
  return b < a ? a = b, 1 : 0;
}
template <class T>
bool umax(T& a, const T& b) {
  return a < b ? a = b, 1 : 0;
}
int n;
vector<pair<long long, long long>> cards[(long long)(200002)],
    need[(long long)(200002)];
vector<array<long long, 3>> valid[(long long)(200002)];
void prepare() {
  for (int i = (1), _c = (n); i <= _c; ++i) {
    vector<int> cnt(4, 0);
    sort((cards[i]).begin(), (cards[i]).end(),
         [](pair<long long, long long> a, pair<long long, long long> b) {
           return a.first < b.first ||
                  (a.first == b.first && a.second > b.second);
         });
    for (auto j : cards[i]) {
      if (j.first == 1 && cnt[j.first] >= 3) continue;
      if (j.first == 2 && cnt[j.first] >= 1) continue;
      if (j.first == 3 && cnt[j.first] >= 1) continue;
      need[i].push_back(j);
      ++cnt[j.first];
    }
  }
  for (int i = (1), _c = (n); i <= _c; ++i) {
    for (int j = (0), _c = ((1ll << (((int)((need[i]).size())))) - 1); j <= _c;
         ++j) {
      long long cost = 0, ma = 0, dame = 0;
      for (int k = (0), _c = (((int)((need[i]).size())) - 1); k <= _c; ++k) {
        if ((((j) >> (k)) & 1ll)) {
          cost += need[i][k].first;
          dame += need[i][k].second;
          umax(ma, need[i][k].second);
        }
      }
      if (cost <= 3) {
        int bonus = __builtin_popcountll(j);
        valid[i].push_back({bonus, dame, ma});
      }
    }
  }
}
long long dp[(long long)(200002)][11];
void test_case() {
  cin >> n;
  for (int i = (1), _c = (n); i <= _c; ++i) {
    int k;
    cin >> k;
    cards[i].assign(k, {0, 0});
    for (int j = (0), _c = (k - 1); j <= _c; ++j)
      cin >> cards[i][j].first >> cards[i][j].second;
  }
  prepare();
  for (auto i : valid[1]) umax(dp[1][i[0]], i[1]);
  for (int i = (1), _c = (n - 1); i <= _c; ++i)
    for (int j = (0), _c = (10); j <= _c; ++j)
      if (dp[i][j] || j == 0) {
        for (auto k : valid[i + 1]) {
          int nxtNum = j + k[0];
          if (nxtNum < 10)
            umax(dp[i + 1][nxtNum], dp[i][j] + k[1]);
          else
            umax(dp[i + 1][nxtNum % 10], dp[i][j] + k[1] + k[2]);
        }
      }
  long long ans = 0;
  for (int i = (0), _c = (10); i <= _c; ++i) umax(ans, dp[n][i]);
  cout << ans << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  auto time = clock();
  int test = 1;
  while (test--) {
    test_case();
  }
  cerr << "[It took " << fixed << setprecision(3)
       << double(clock() - time) / CLOCKS_PER_SEC << "s]"
       << "\n";
  return 0;
}
