#include <bits/stdc++.h>
using namespace std;
int n, totalC, turnIndex[200000];
long long turns[200000][2], dp[200000][10], best[200000][5];
vector<int> incl[200000];
vector<int> turnCtr, scratch;
int main() {
  scanf("%d", &n);
  turnCtr.assign(n, 0);
  int cur = 0;
  for (int i = 0; i < n; i++) {
    scanf("%d", &turnCtr[i]);
    priority_queue<long long> maxVals[4];
    for (int j = 0; j < turnCtr[i]; j++) {
      scanf("%lld %lld", &turns[cur][0], &turns[cur][1]);
      maxVals[turns[cur][0]].push(turns[cur][1]);
      turnIndex[cur++] = i;
    }
    for (int j = 0; j < 5; j++) {
      best[i][j] = 0;
    }
    if (maxVals[3].size() > 0) {
      best[i][4] = maxVals[3].top();
    }
    if (maxVals[2].size() > 0) {
      best[i][3] = maxVals[2].top();
    }
    for (int j = 0; !maxVals[1].empty() && j < 3; j++) {
      best[i][j] = maxVals[1].top();
      maxVals[1].pop();
    }
    if (i > 0) {
      turnCtr[i] += turnCtr[i - 1];
    }
  }
  totalC = turnCtr[n - 1];
  for (int turn = totalC - 1; turn >= 0; turn--) {
    for (int soFar = 0; soFar < 10; soFar++) {
      long long &temp = dp[turn][soFar];
      if (turn == n - 1) {
        temp = 0;
        if (best[turn][4]) {
          temp = max(temp, best[turn][4] * (soFar == 0 ? 2LL : 1LL));
        }
        if (best[turn][3] && best[turn][0]) {
          temp = max(temp,
                     best[turn][3] + best[turn][0] +
                         (soFar <= 1 ? max(best[turn][3], best[turn][0]) : 0));
        }
        if (best[turn][3]) {
          temp = max(temp, best[turn][3] + (soFar == 0 ? best[turn][3] : 0));
        }
        for (int mask = 0; mask < (1 << 3); mask++) {
          long long additional = 0LL;
          long long tempTotal = 0LL;
          int on = 0;
          for (int i = 0; i < 3; i++) {
            if (mask & (1 << i)) {
              on++;
              additional = max(additional, best[turn][i]);
              tempTotal += best[turn][i];
            }
          }
          if (soFar - on < 0) {
            tempTotal += additional;
          }
          temp = max(temp, tempTotal);
        }
      } else {
        temp = dp[turn + 1][soFar];
        if (best[turn][4]) {
          temp = max(temp, dp[turn + 1][(soFar + 9) % 10] +
                               best[turn][4] * (soFar == 0 ? 2LL : 1LL));
        }
        if (best[turn][3] && best[turn][0]) {
          temp = max(temp,
                     dp[turn + 1][(soFar + 8) % 10] + best[turn][3] +
                         best[turn][0] +
                         (soFar <= 1 ? max(best[turn][3], best[turn][0]) : 0));
        }
        if (best[turn][3]) {
          temp = max(temp, dp[turn + 1][(soFar + 9) % 10] + best[turn][3] +
                               (soFar == 0 ? best[turn][3] : 0));
        }
        for (int mask = 0; mask < (1 << 3); mask++) {
          long long additional = 0LL;
          long long tempTotal = 0LL;
          int on = 0;
          bool poss = true;
          for (int i = 0; poss && i < 3; i++) {
            if ((mask & (1 << i))) {
              if (!best[turn][i]) {
                poss = false;
              } else {
                on++;
                additional = max(additional, best[turn][i]);
                tempTotal += best[turn][i];
              }
            }
          }
          if (poss) {
            if (soFar - on < 0) {
              tempTotal += additional;
            }
            temp = max(temp, dp[turn + 1][(soFar + 10 - on) % 10] + tempTotal);
          }
        }
      }
    }
  }
  printf("%lld\n", dp[0][9]);
}
