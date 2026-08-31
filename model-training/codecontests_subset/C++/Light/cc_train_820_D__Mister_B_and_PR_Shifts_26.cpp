#include <bits/stdc++.h>
using namespace std;
long long dp[2000004], a[1000004];
int main() {
  ios_base::sync_with_stdio;
  long long n, m, i, j, k = 0, l = 0;
  cin >> n;
  long long sum = 0;
  for (i = 1; i <= n; i++) {
    cin >> j;
    a[i] = j;
    if (j > i) {
      dp[j - i]++;
      l++;
    } else
      k++;
    sum += abs(i - j);
  }
  int ans = 0;
  long long anssum = sum;
  for (i = 1; i <= n - 1; i++) {
    sum = sum - abs(a[n - i + 1] - n) + abs(a[n - i + 1] - 1) - l + k - 1;
    if (a[n - i + 1] > 1) {
      dp[i + a[n - i + 1] - 1]++;
      l++;
      k--;
    }
    if (sum < anssum) {
      ans = i;
      anssum = sum;
    }
    k += dp[i];
    l -= dp[i];
    dp[i] = 0;
  }
  cout << anssum << " " << ans;
  return 0;
}
