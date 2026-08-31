#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e17;
void solve() {
  int n;
  cin >> n;
  vector<long long> dp(10, -inf);
  dp[0] = 0;
  while (n--) {
    int k;
    cin >> k;
    vector<vector<long long>> store(4);
    for (int i = 0; i < k; i++) {
      int c, d;
      cin >> c >> d;
      store[c].push_back(d);
    }
    for (int i = 1; i <= 3; i++)
      sort(store[i].begin(), store[i].end(), greater<long long>());
    vector<long long> ndp = dp;
    for (int rem = 0; rem <= 9; rem++) {
      int mul = (rem == 9) ? 2 : 1;
      if (store[1].size())
        ndp[(rem + 1) % 10] =
            max(ndp[(rem + 1) % 10], dp[rem] + mul * store[1][0]);
      if (store[2].size())
        ndp[(rem + 1) % 10] =
            max(ndp[(rem + 1) % 10], dp[rem] + mul * store[2][0]);
      if (store[3].size())
        ndp[(rem + 1) % 10] =
            max(ndp[(rem + 1) % 10], dp[rem] + mul * store[3][0]);
      mul = (rem == 8 || rem == 9) ? 2 : 1;
      if (store[1].size() > 1)
        ndp[(rem + 2) % 10] =
            max(ndp[(rem + 2) % 10], dp[rem] + mul * store[1][0] + store[1][1]);
      if (store[1].size() && store[2].size())
        ndp[(rem + 2) % 10] =
            max(ndp[(rem + 2) % 10], dp[rem] + mul * store[1][0] + store[2][0]);
      if (store[1].size() && store[2].size())
        ndp[(rem + 2) % 10] =
            max(ndp[(rem + 2) % 10], dp[rem] + mul * store[2][0] + store[1][0]);
      mul = (rem >= 7 && rem <= 9) ? 2 : 1;
      if (store[1].size() > 2)
        ndp[(rem + 3) % 10] =
            max(ndp[(rem + 3) % 10],
                dp[rem] + mul * store[1][0] + store[1][1] + store[1][2]);
    }
    dp.swap(ndp);
  }
  cout << *max_element(dp.begin(), dp.end()) << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  cout << fixed << setprecision(20);
  ;
  int t = 1;
  for (int i = 1; i <= t; i++) {
    solve();
  }
}
