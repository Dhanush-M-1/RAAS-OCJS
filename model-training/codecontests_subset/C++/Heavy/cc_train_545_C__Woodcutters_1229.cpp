#include <bits/stdc++.h>
using namespace std;
int mini(int a, int b) { return a < b ? a : b; }
unsigned long long lmini(unsigned long long a, unsigned long long b) {
  return a < b ? a : b;
}
int maxi(int a, int b) { return a > b ? a : b; }
unsigned long long lmaxi(unsigned long long a, unsigned long long b) {
  return a > b ? a : b;
}
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
unsigned long long lgcd(unsigned long long a, unsigned long long b) {
  if (b == 0) return a;
  return lgcd(b, a % b);
}
int lcm(int a, int b) { return a * (b / gcd(a, b)); }
unsigned long long llcm(unsigned long long a, unsigned long long b) {
  return (b * (a / lgcd(a, b)));
}
int dp[100001], x[100005], h[100005], n;
int cal(int i, int l, int r) {
  if (i >= n) return 0;
  if (dp[i] != -1) return dp[i];
  int a1 = 0, a2 = 0, a3 = 0, a4;
  if (x[i] - h[i] > l) a1 = 1 + cal(i + 1, x[i], x[i + 2]);
  if (x[i] + h[i] < r) a2 = 1 + cal(i + 1, x[i] + h[i], x[i + 2]);
  a3 = cal(i + 1, x[i], x[i + 2]);
  a4 = maxi(maxi(a1, a2), a3);
  dp[i] = a4;
  return a4;
}
int main() {
  cin >> n;
  int i, ans;
  for (i = 0; i < n; i++) dp[i] = -1;
  for (i = 0; i < n; i++) cin >> x[i] >> h[i];
  x[n + 1] = x[n] = 1e18;
  ans = cal(0, -1e18, x[1]);
  cout << ans << endl;
  return 0;
}
