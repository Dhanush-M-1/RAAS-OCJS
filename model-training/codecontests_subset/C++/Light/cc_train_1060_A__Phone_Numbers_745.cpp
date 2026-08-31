#include <bits/stdc++.h>
using namespace std;
signed main() {
  long long int n;
  cin >> n;
  string s;
  cin >> s;
  long long int k = 0;
  for (long long int i = 0; i < n; i++) {
    if (s[i] == '8') k++;
  }
  long long int ans = 0, ans1 = 0;
  ans = n / 11;
  ans1 = min(ans, k);
  cout << ans1;
  return 0;
}
