#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  vector<pair<long long, long long> > A(n);
  for (long long i = 0; i < n; i++) {
    cin >> A[i].first >> A[i].second;
  }
  long long sol = 1;
  vector<long long> dp(n);
  for (long long i = 0; i < n - 1; i++) {
    if (i == 0) {
      dp[i] = A[i].first;
      sol++;
    } else {
      if (dp[i - 1] < (A[i].first - A[i].second)) {
        dp[i] = A[i].first;
        sol++;
      } else if ((A[i].first + A[i].second) < A[i + 1].first) {
        dp[i] = A[i].first + A[i].second;
        sol++;
      } else {
        dp[i] = A[i].first;
      }
    }
  }
  cout << sol;
  return 0;
}
