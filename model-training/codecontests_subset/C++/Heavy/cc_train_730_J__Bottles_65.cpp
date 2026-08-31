#include <bits/stdc++.h>
using namespace std;
int dp[101][101 * 101];
int data[101];
int s[101];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  int sum = 0;
  vector<pair<int, int> > v;
  for (int i = 1; i <= n; i++) cin >> data[i], sum += data[i];
  for (int i = 1; i <= n; i++) {
    int a;
    cin >> a;
    v.push_back(pair<int, int>(a, data[i]));
  }
  sort(v.begin(), v.end(), greater<pair<int, int> >());
  for (int i = 1; i <= n; i++) s[i] = s[i - 1] + v[i - 1].first;
  int idx = lower_bound(s + 1, s + n + 1, sum) - s;
  memset(dp, 192, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = i; j > 0; j--) {
      for (int k = v[i - 1].second; k <= sum; k++)
        dp[j][k] =
            max(dp[j][k], dp[j - 1][k - v[i - 1].second] + v[i - 1].first);
    }
  }
  cout << idx << ' ';
  for (int i = sum; i >= 0; i--) {
    if (dp[idx][i] >= sum) {
      cout << sum - i << "\n";
      break;
    }
  }
  return 0;
}
