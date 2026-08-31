#include <bits/stdc++.h>
using namespace std;
const long long inf = 1.1e9 * 1LL * 1.1e9;
const int MX = 1e7;
int main() {
  int n;
  cin >> n;
  vector<vector<long long>> dp(n + 1, vector<long long>(10, -inf));
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    int k;
    cin >> k;
    vector<pair<int, int>> bst(k);
    for (auto &x : bst) cin >> x.first >> x.second;
    sort(bst.begin(), bst.end());
    vector<vector<vector<long long>>> pd(
        2, vector<vector<long long>>(4, vector<long long>(4, -inf)));
    pd[0][0][0] = 0;
    for (auto [c, d] : bst) {
      auto pd2 = pd;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (j + c <= 3) {
            if (pd[0][i][j] != -inf) {
              pd2[0][i + 1][j + c] = max(pd2[0][i + 1][j + c], pd[0][i][j] + d);
              pd2[1][i + 1][j + c] =
                  max(pd2[1][i + 1][j + c], pd[0][i][j] + 2 * d);
            }
            if (pd[1][i][j] != -inf) {
              pd2[1][i + 1][j + c] = max(pd2[1][i + 1][j + c], pd[1][i][j] + d);
            }
          }
        }
      }
      pd = pd2;
    }
    for (int ost = 0; ost < 10; ost++) {
      for (int cnt = 0; cnt <= 3; cnt++) {
        for (int qq = 0; qq <= 3; qq++) {
          dp[i + 1][(ost + cnt) % 10] =
              max(dp[i + 1][(ost + cnt) % 10],
                  dp[i][ost] + pd[ost + cnt >= 10][cnt][qq]);
        }
      }
    }
  }
  cout << *max_element(dp[n].begin(), dp[n].end()) << endl;
}
