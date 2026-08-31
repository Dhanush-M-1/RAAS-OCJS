#include <bits/stdc++.h>
using namespace std;
int n, q, arr[101], sr[101];
vector<int> dp[101];
multiset<int> s;
int main() {
  cin >> n;
  for (long long i = 0; i < n; i++) {
    cin >> arr[i];
    sr[i] = arr[i];
  }
  sort(sr, sr + n, [](int a, int b) { return a > b; });
  for (long long i = 1; i <= n; i++) {
    for (long long j = 0; j < i; j++) {
      s.insert(sr[j]);
    }
    for (long long j = 0; j < n; j++) {
      if (s.count(arr[j])) {
        dp[i].push_back(arr[j]);
        s.erase(s.find(arr[j]));
      }
    }
  }
  cin >> q;
  while (q--) {
    int a, b;
    cin >> a >> b;
    cout << dp[a][b - 1] << endl;
  }
  return 0;
}
