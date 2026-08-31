#include <bits/stdc++.h>
using namespace std;
vector<int> h;
vector<int> c;
long long int n;
long long int dp[100004][3];
long long int max1(int cu, int pos) {
  if (cu == n - 1) return 1;
  if (dp[cu][pos] > -1) return dp[cu][pos];
  long long int opt1 = INT_MIN;
  long long int opt2 = INT_MIN;
  long long int opt3 = INT_MIN;
  if (pos == 0 || pos == 2) {
    if (c[cu] - h[cu] > c[cu - 1]) opt1 = 1 + max1(cu + 1, 0);
    if (c[cu] + h[cu] < c[cu + 1]) opt2 = 1 + max1(cu + 1, 1);
    opt3 = max1(cu + 1, 2);
  }
  if (pos == 1) {
    if (c[cu] - h[cu] > c[cu - 1] + h[cu - 1]) opt1 = 1 + max1(cu + 1, 0);
    if (c[cu] + h[cu] < c[cu + 1]) opt2 = 1 + max1(cu + 1, 1);
    opt3 = max1(cu + 1, 2);
  }
  return dp[cu][pos] = max(opt1, max(opt2, opt3));
}
int main() {
  cin >> n;
  memset(dp, -1, sizeof(dp));
  for (int i = 0; i < n; i++) {
    long long int a;
    long long int b;
    cin >> a;
    cin >> b;
    c.push_back(a);
    h.push_back(b);
  }
  if (n == 1) {
    cout << 1 << endl;
    return 0;
  }
  long long int opt1 = INT_MIN;
  long long int opt2 = INT_MIN;
  if (c[0] + h[0] < c[1]) opt1 = 1 + max1(1, 1);
  opt2 = 1 + max1(1, 0);
  long long int ans = max(opt1, max(opt2, max1(1, 2)));
  cout << ans << endl;
  return 0;
}
