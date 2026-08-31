#include <bits/stdc++.h>
using namespace std;
int T, N, K, a, b;
int main(int argc, const char *argv[]) {
  cin >> T;
  for (int t = 0; t < T; t++) {
    cin >> N >> K;
    vector<pair<int, pair<int, int>>> minions;
    for (int i = 1; i <= N; i++) {
      cin >> a >> b;
      minions.push_back(make_pair(b, make_pair(a, i)));
    }
    sort(minions.begin(), minions.end());
    int memo[80][80] = {0};
    int choose[80][80] = {0};
    for (int i = 0; i < 80; i++) {
      for (int j = 0; j < 80; j++) {
        memo[i][j] = INT_MIN;
      }
    }
    for (int i = N; i >= 0; i--)
      for (int j = K; j >= 0; j--) {
        if (i == N) {
          memo[i][j] = j == 0 ? 0 : INT_MIN;
          continue;
        }
        if (j > 0) {
          int keep = minions[i].second.first + minions[i].first * (K - j) +
                     memo[i + 1][j - 1];
          if (keep > memo[i][j]) {
            memo[i][j] = keep;
            choose[i][j] = 1;
          }
        }
        int notKeep = minions[i].first * (K - 1) + memo[i + 1][j];
        if (notKeep > memo[i][j]) {
          memo[i][j] = notKeep;
          choose[i][j] = 0;
        }
      }
    vector<int> keep, notKeep;
    int num = K;
    for (int i = 0; i < N; i++) {
      if (choose[i][num] == 1) {
        keep.push_back(minions[i].second.second);
        num--;
      } else {
        notKeep.push_back(minions[i].second.second);
      }
    }
    vector<int> moves;
    for (int i = 0; i < (int)keep.size() - 1; i++) moves.push_back(keep[i]);
    for (int i = 0; i < (int)notKeep.size(); i++) {
      moves.push_back(notKeep[i]);
      moves.push_back(-notKeep[i]);
    }
    if ((int)keep.size() > 0) {
      moves.push_back(keep[(int)keep.size() - 1]);
    }
    cout << moves.size() << endl;
    for (int i = 0; i < (int)moves.size(); i++)
      cout << moves[i] << (i == (int)moves.size() - 1 ? "\n" : " ");
  }
  return 0;
}
