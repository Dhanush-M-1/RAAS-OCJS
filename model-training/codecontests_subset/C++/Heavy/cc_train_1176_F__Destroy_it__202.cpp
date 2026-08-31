#include <bits/stdc++.h>
using namespace std;
void use_cio() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
}
template <class L, class R>
ostream &operator<<(ostream &os, pair<L, R> P) {
  return os << "(" << P.first << "," << P.second << ")";
}
template <class T>
ostream &operator<<(ostream &os, vector<T> V) {
  os << "[";
  for (auto x : V) os << x << ", ";
  return os << "]";
}
template <typename... Args>
void dbg(Args... args) {
  ((cerr << args << " "), ...);
  cerr << "\n";
}
long long dp[200010][10];
int main() {
  use_cio();
  int n;
  cin >> n;
  for (int i = 0; i < (10); i++) dp[0][i] = -1;
  dp[0][0] = 0;
  for (int i = 0; i < (n); i++) {
    int k;
    cin >> k;
    vector<long long> cost1, cost2, cost3;
    for (int j = 0; j < (k); j++) {
      long long c, d;
      cin >> c >> d;
      if (c == 1) cost1.push_back(d);
      if (c == 2) cost2.push_back(d);
      if (c == 3) cost3.push_back(d);
    }
    sort(cost1.rbegin(), cost1.rend());
    sort(cost2.rbegin(), cost2.rend());
    sort(cost3.rbegin(), cost3.rend());
    vector<tuple<long long, long long, long long>> vc;
    if (cost1.size()) vc.push_back({1, cost1[0], 2LL * cost1[0]});
    if (cost2.size()) vc.push_back({1, cost2[0], 2LL * cost2[0]});
    if (cost3.size()) vc.push_back({1, cost3[0], 2LL * cost3[0]});
    if (cost1.size() >= 2)
      vc.push_back({2, cost1[0] + cost1[1], 2LL * cost1[0] + cost1[1]});
    if (cost1.size() >= 3)
      vc.push_back({3, cost1[0] + cost1[1] + cost1[2],
                    2LL * cost1[0] + cost1[1] + cost1[2]});
    if (cost1.size() and cost2.size())
      vc.push_back({2, cost1[0] + cost2[0],
                    cost1[0] + cost2[0] + max(cost1[0], cost2[0])});
    for (int j = 0; j < (10); j++) dp[i + 1][j] = dp[i][j];
    for (int j = 0; j < (10); j++) {
      for (auto [nn, d, dd] : vc) {
        int nj = j + nn;
        if (dp[i][j] == -1) continue;
        if (nj >= 10)
          dp[i + 1][nj % 10] = max(dp[i + 1][nj % 10], dp[i][j] + dd);
        else
          dp[i + 1][nj] = max(dp[i + 1][nj], dp[i][j] + d);
      }
    }
  }
  cout << *max_element(dp[n], dp[n] + 10) << "\n";
}
