#include <bits/stdc++.h>
using namespace std;
pair<int, int> cards[200010];
long long dp[200010][10];
int main(void) {
  int N;
  cin >> N;
  for (int i = 1; i < 10; i++) dp[0][i] = -1;
  for (int t = 0; t < N; t++) {
    int K;
    cin >> K;
    for (int i = 0; i < K; i++) {
      int c, d;
      cin >> c >> d;
      cards[i] = make_pair(d, c);
    }
    sort(cards, cards + K);
    int one = cards[K - 1].first;
    int twoflag = -1;
    pair<int, int> two = make_pair(-1, -1);
    int three[3];
    three[0] = -1;
    three[1] = -1;
    three[2] = -1;
    for (int i = K - 1; i >= 0; i--) {
      if (cards[i].second == 3) continue;
      if (cards[i].second == 2 && twoflag < 0) twoflag = 1;
      if (twoflag < 0) twoflag = 0;
      if (two.first == -1)
        two.first = cards[i].first;
      else if (two.second == -1 && (!twoflag || cards[i].second == 1))
        two.second = cards[i].first;
      if (cards[i].second != 1) continue;
      if (three[0] == -1)
        three[0] = cards[i].first;
      else if (three[1] == -1)
        three[1] = cards[i].first;
      else if (three[2] == -1)
        three[2] = cards[i].first;
    }
    for (int i = 0; i < 10; i++) dp[t + 1][i] = -1;
    for (int i = 0; i < 10; i++) {
      if (dp[t][i] == -1) continue;
      dp[t + 1][i] = max(dp[t + 1][i], dp[t][i]);
      if (i < 9)
        dp[t + 1][i + 1] = max(dp[t + 1][i + 1], dp[t][i] + one);
      else
        dp[t + 1][0] = max(dp[t + 1][0], dp[t][i] + one * 2);
      if (two.second != -1) {
        if (i < 8)
          dp[t + 1][i + 2] =
              max(dp[t + 1][i + 2], dp[t][i] + two.first + two.second);
        else
          dp[t + 1][i - 8] =
              max(dp[t + 1][i - 8], dp[t][i] + two.first * 2 + two.second);
      }
      if (three[2] != -1) {
        if (i < 7)
          dp[t + 1][i + 3] =
              max(dp[t + 1][i + 3], dp[t][i] + three[0] + three[1] + three[2]);
        else
          dp[t + 1][i - 7] = max(dp[t + 1][i - 7],
                                 dp[t][i] + three[0] * 2 + three[1] + three[2]);
      }
    }
  }
  long long ans = 0;
  for (int i = 0; i < 10; i++) ans = max(ans, dp[N][i]);
  cout << ans << endl;
  return 0;
}
