#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, pp, pro = 0;
  cin >> n >> pp;
  vector<int> dp(n);
  for (int i = 0; i < n; i++) cin >> dp[i];
  for (int i = 0; i < n - 1; i++) {
    if (dp[i] - dp[i + 1] - pp > pro) pro = dp[i] - dp[i + 1] - pp;
  }
  cout << pro;
  return 0;
}
