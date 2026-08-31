#include <bits/stdc++.h>
using namespace std;
int n, k;
int dp[80][80];
bool included[80];
pair<pair<int, int>, int> A[80];
vector<int> ans;
bool byfise(pair<pair<int, int>, int> i, pair<pair<int, int>, int> j) {
  return i.first.second < j.first.second;
}
void backtrack() {
  int x = n, y = k;
  while (x) {
    if (y &&
        dp[x - 1][y - 1] + A[x].first.first + (y - 1) * A[x].first.second ==
            dp[x][y]) {
      y--;
      included[x] = 1;
    }
    x--;
  }
}
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    memset(included, 0, sizeof included);
    memset(dp, -1, sizeof dp);
    ans.clear();
    scanf("%d %d", &n, &k);
    for (int i = 1; i <= n; i++) {
      scanf("%d %d", &A[i].first.first, &A[i].first.second);
      A[i].second = i;
    }
    sort(A + 1, A + 1 + n, byfise);
    dp[0][0] = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (dp[i][j] == -1) continue;
        dp[i + 1][j] =
            max(dp[i + 1][j], dp[i][j] + (k - 1) * A[i + 1].first.second);
        dp[i + 1][j + 1] =
            max(dp[i + 1][j + 1],
                dp[i][j] + A[i + 1].first.first + j * A[i + 1].first.second);
      }
    }
    backtrack();
    for (int i = 1; i <= n; i++)
      if (included[i]) {
        ans.push_back(A[i].second);
      }
    int temp = ans.back();
    ans.pop_back();
    for (int i = 1; i <= n; i++) {
      if (!included[i]) {
        ans.push_back(A[i].second);
        ans.push_back(-A[i].second);
      }
    }
    ans.push_back(temp);
    printf("%lu\n", ans.size());
    for (int i = 0; i < ans.size(); i++)
      printf("%d%c", ans[i], (i == ans.size() - 1) ? '\n' : ' ');
  }
}
