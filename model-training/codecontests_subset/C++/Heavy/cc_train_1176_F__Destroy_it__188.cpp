#include <bits/stdc++.h>
using namespace std;
long long dp[212345][10];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = (0); i < (n + 1); ++i)
    for (int j = (0); j < (10); ++j) dp[i][j] = -1;
  dp[0][0] = 0;
  for (int i = (0); i < (n); ++i) {
    int k;
    cin >> k;
    vector<vector<long long> > cards(4);
    for (int j = (0); j < (k); ++j) {
      long long c, d;
      cin >> c >> d;
      cards[c].push_back(d);
    }
    for (int j = (1); j < (4); ++j) {
      sort(cards[j].begin(), cards[j].end());
      reverse(cards[j].begin(), cards[j].end());
    }
    for (int j = (0); j < (10); ++j) {
      if (dp[i][j] == -1) continue;
      dp[i + 1][j] =
          ((dp[i + 1][j]) > (dp[i][j]) ? (dp[i + 1][j]) : (dp[i][j]));
      if ((int)(cards[1]).size()) {
        if (j + 1 >= 10) {
          dp[i + 1][(j + 1) % 10] =
              ((dp[i + 1][(j + 1) % 10]) > (dp[i][j] + 2 * cards[1][0])
                   ? (dp[i + 1][(j + 1) % 10])
                   : (dp[i][j] + 2 * cards[1][0]));
        } else {
          dp[i + 1][j + 1] = ((dp[i + 1][j + 1]) > (dp[i][j] + cards[1][0])
                                  ? (dp[i + 1][j + 1])
                                  : (dp[i][j] + cards[1][0]));
        }
      }
      if ((int)(cards[1]).size() > 1) {
        if (j + 2 >= 10) {
          dp[i + 1][(j + 2) % 10] =
              ((dp[i + 1][(j + 2) % 10]) >
                       (dp[i][j] + 2 * cards[1][0] + cards[1][1])
                   ? (dp[i + 1][(j + 2) % 10])
                   : (dp[i][j] + 2 * cards[1][0] + cards[1][1]));
        } else {
          dp[i + 1][j + 2] =
              ((dp[i + 1][j + 2]) > (dp[i][j] + cards[1][0] + cards[1][1])
                   ? (dp[i + 1][j + 2])
                   : (dp[i][j] + cards[1][0] + cards[1][1]));
        }
      }
      if ((int)(cards[2]).size()) {
        if (j + 1 >= 10) {
          dp[i + 1][(j + 1) % 10] =
              ((dp[i + 1][(j + 1) % 10]) > (dp[i][j] + 2 * cards[2][0])
                   ? (dp[i + 1][(j + 1) % 10])
                   : (dp[i][j] + 2 * cards[2][0]));
        } else {
          dp[i + 1][(j + 1) % 10] =
              ((dp[i + 1][(j + 1) % 10]) > (dp[i][j] + cards[2][0])
                   ? (dp[i + 1][(j + 1) % 10])
                   : (dp[i][j] + cards[2][0]));
        }
      }
      if ((int)(cards[1]).size() > 2) {
        if (j + 3 >= 10) {
          dp[i + 1][(j + 3) % 10] =
              ((dp[i + 1][(j + 3) % 10]) >
                       (dp[i][j] + 2 * cards[1][0] + cards[1][1] + cards[1][2])
                   ? (dp[i + 1][(j + 3) % 10])
                   : (dp[i][j] + 2 * cards[1][0] + cards[1][1] + cards[1][2]));
        } else {
          dp[i + 1][(j + 3) % 10] =
              ((dp[i + 1][(j + 3) % 10]) >
                       (dp[i][j] + cards[1][0] + cards[1][1] + cards[1][2])
                   ? (dp[i + 1][(j + 3) % 10])
                   : (dp[i][j] + cards[1][0] + cards[1][1] + cards[1][2]));
        }
      }
      if ((int)(cards[1]).size() && (int)(cards[2]).size()) {
        if (j + 2 >= 10) {
          dp[i + 1][(j + 2) % 10] =
              ((dp[i + 1][(j + 2) % 10]) >
                       (dp[i][j] +
                        2 * ((cards[1][0]) > (cards[2][0]) ? (cards[1][0])
                                                           : (cards[2][0])) +
                        ((cards[1][0]) < (cards[2][0]) ? (cards[1][0])
                                                       : (cards[2][0])))
                   ? (dp[i + 1][(j + 2) % 10])
                   : (dp[i][j] +
                      2 * ((cards[1][0]) > (cards[2][0]) ? (cards[1][0])
                                                         : (cards[2][0])) +
                      ((cards[1][0]) < (cards[2][0]) ? (cards[1][0])
                                                     : (cards[2][0]))));
        } else {
          dp[i + 1][(j + 2) % 10] =
              ((dp[i + 1][(j + 2) % 10]) >
                       (dp[i][j] +
                        ((cards[1][0]) > (cards[2][0]) ? (cards[1][0])
                                                       : (cards[2][0])) +
                        ((cards[1][0]) < (cards[2][0]) ? (cards[1][0])
                                                       : (cards[2][0])))
                   ? (dp[i + 1][(j + 2) % 10])
                   : (dp[i][j] +
                      ((cards[1][0]) > (cards[2][0]) ? (cards[1][0])
                                                     : (cards[2][0])) +
                      ((cards[1][0]) < (cards[2][0]) ? (cards[1][0])
                                                     : (cards[2][0]))));
        }
      }
      if ((int)(cards[3]).size()) {
        if (j + 1 >= 10) {
          dp[i + 1][(j + 1) % 10] =
              ((dp[i + 1][(j + 1) % 10]) > (dp[i][j] + 2 * cards[3][0])
                   ? (dp[i + 1][(j + 1) % 10])
                   : (dp[i][j] + 2 * cards[3][0]));
        } else {
          dp[i + 1][(j + 1) % 10] =
              ((dp[i + 1][(j + 1) % 10]) > (dp[i][j] + cards[3][0])
                   ? (dp[i + 1][(j + 1) % 10])
                   : (dp[i][j] + cards[3][0]));
        }
      }
    }
  }
  long long ans = 0;
  for (int j = (0); j < (10); ++j) {
    ans = ((ans) > (dp[n][j]) ? (ans) : (dp[n][j]));
  }
  cout << ans << endl;
}
