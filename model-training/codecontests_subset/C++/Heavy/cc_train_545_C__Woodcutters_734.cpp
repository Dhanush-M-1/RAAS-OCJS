#include <bits/stdc++.h>
using namespace std;
bool sortbysec(const pair<int, int> &a, const pair<int, int> &b) {
  if (a.first == b.first) return (a.second < b.second);
  return (a.first < b.first);
}
vector<long long int> prime(1000005, 1);
void p() {
  long long int i, j;
  for (i = 2; i <= 1000000; i++) {
    if (prime[i] == 1) {
      for (j = 2 * i; j <= 1000000; j += i) prime[j] = 0;
    }
  }
}
void solve() {
  long long int n, i;
  cin >> n;
  vector<long long int> a(n), h(n);
  for (i = 0; i < (n); i++) cin >> a[i] >> h[i];
  vector<long long int> dp(n);
  dp[0] = a[0];
  dp[n - 1] = a[n - 1];
  long long int counter;
  if (n == 1)
    counter = 1;
  else
    counter = 2;
  for (i = 1; i < n - 1; i++) {
    if (dp[i - 1] < a[i] - h[i]) {
      dp[i] = a[i];
      counter++;
    } else if (a[i] + h[i] < a[i + 1]) {
      dp[i] = a[i] + h[i];
      counter++;
    } else {
      dp[i] = a[i];
    }
  }
  cout << counter << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
