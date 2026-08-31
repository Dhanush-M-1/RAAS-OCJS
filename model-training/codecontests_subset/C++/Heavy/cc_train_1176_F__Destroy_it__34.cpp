#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1000000007;
vector<pair<long long int, long long int> > moves[200010];
long long int dp[200010][11];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n, k, c, p;
  cin >> n;
  for (long long int i = 0; i < n + 1; i++)
    for (long long int j = 0; j < 11; j++) dp[i][j] = -1;
  for (long long int i = 0; i < n; i++) {
    cin >> k;
    for (long long int j = 0; j < k; j++) {
      cin >> c >> p;
      moves[i].push_back({c, p});
    }
  }
  dp[0][0] = 0;
  for (long long int i = 0; i < n; i++) {
    vector<long long int> turn_move[3];
    for (auto it : moves[i]) turn_move[(it.first - 1) % 3].push_back(it.second);
    for (long long int j = 0; j < 3; j++)
      sort(turn_move[j].begin(), turn_move[j].end(), greater<long long int>());
    for (long long int j = 0; j <= 3; j++) {
      for (long long int k = 0; k <= 3; k++) {
        for (long long int l = 0; l <= 3; l++) {
          if (j + 2 * k + 3 * l > 3 or turn_move[0].size() < j or
              turn_move[1].size() < k or turn_move[2].size() < l)
            continue;
          vector<long long int> avail;
          long long int sum = 0, card_count = j + k + l;
          for (long long int m = 0; m < j; m++) {
            sum += turn_move[0][m];
            avail.push_back(turn_move[0][m]);
          }
          for (long long int m = 0; m < k; m++) {
            sum += turn_move[1][m];
            avail.push_back(turn_move[1][m]);
          }
          for (long long int m = 0; m < l; m++) {
            sum += turn_move[2][m];
            avail.push_back(turn_move[2][m]);
          }
          sort(avail.begin(), avail.end(), greater<long long int>());
          for (long long int m = 0; m < 10; m++) {
            dp[i][card_count] = max(dp[i][card_count], sum);
            if (i) {
              if (dp[i - 1][m] != -1) {
                if (card_count + m >= 10) {
                  sum += avail[0];
                  avail[0] *= 2;
                }
                dp[i][(card_count + m) % 10] =
                    max(dp[i - 1][m] + sum, dp[i][(card_count + m) % 10]);
                if (card_count + m >= 10) {
                  avail[0] /= 2;
                  sum -= avail[0];
                }
              }
            }
          }
        }
      }
    }
  }
  long long int ans = 0;
  for (long long int j = 0; j < 11; j++) {
    for (long long int i = 0; i < n; i++) {
      ans = max(ans, dp[i][j]);
    }
  }
  cout << ans << endl;
  return 0;
}
