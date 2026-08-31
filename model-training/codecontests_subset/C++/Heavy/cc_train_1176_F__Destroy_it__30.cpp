#include <bits/stdc++.h>
using namespace std;
vector<long long int> vi[5];
vector<pair<int, long long int> > take;
void init() {
  if (vi[1].size() >= 1) take.push_back(make_pair(1, vi[1][0]));
  if (vi[1].size() >= 2) take.push_back(make_pair(1, vi[1][1]));
  if (vi[1].size() >= 3) take.push_back(make_pair(1, vi[1][2]));
  if (vi[2].size() >= 1) take.push_back(make_pair(2, vi[2][0]));
  if (vi[3].size() >= 1) take.push_back(make_pair(3, vi[3][0]));
}
long long int dp[200200][10];
long long int dp1[5], dp2[5];
int main() {
  int n, i, j, k, x, ans, m, curr;
  long long int y;
  scanf("%d", &n);
  for (i = 0; i < n; i++)
    for (j = 0; j < 10; j++) dp[i][j] = -1e18;
  dp[0][0] = 0;
  int it = 1;
  int temp = n;
  while (n--) {
    scanf("%d", &m);
    for (i = 1; i <= 3; i++) vi[i].clear();
    for (i = 1; i <= m; i++) {
      scanf("%d %lld", &x, &y);
      vi[x].push_back(y);
    }
    for (i = 1; i <= 3; i++)
      sort(vi[i].begin(), vi[i].end(), greater<long long int>());
    take.clear();
    init();
    for (i = 0; i <= 3; i++) {
      dp1[i] = -1e18;
      dp2[i] = -1e18;
    }
    dp1[0] = dp2[0] = 0;
    sort(take.begin(), take.end());
    do {
      int turns = 3;
      long long int maxi = 0;
      long long int sum = 0;
      int play = 0;
      for (auto x : take) {
        if (x.first <= turns) {
          play++;
          turns -= x.first;
          maxi = max(maxi, x.second);
          sum += x.second;
          dp1[play] = max(dp1[play], sum);
          dp2[play] = max(dp2[play], sum + maxi);
        }
      }
    } while (next_permutation(take.begin(), take.end()));
    for (i = 0; i < 10; i++) {
      for (j = 0; j <= 3; j++) {
        int next = (i + j) % 10;
        if (i + j > 9) {
          dp[it][next] = max(dp[it][next], dp[it - 1][i] + dp2[j]);
        } else {
          dp[it][next] = max(dp[it][next], dp[it - 1][i] + dp1[j]);
        }
      }
    }
    it++;
  }
  long long int rose = -1e18;
  for (i = 0; i < 10; i++) rose = max(rose, dp[temp][i]);
  cout << rose << "\n";
  return 0;
}
