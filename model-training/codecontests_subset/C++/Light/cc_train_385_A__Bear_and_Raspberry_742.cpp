#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int lcm(int a, int b) { return (a * b) / gcd(a, b); }
int divisors(int n) {
  int cnt = 0;
  for (int x = 1; x * x <= n; x++) {
    if (n % x == 0) {
      cnt++;
      if (n / x != x) cnt++;
    }
  }
  return cnt;
}
void solve() {
  int n, c;
  cin >> n >> c;
  int arr[n];
  int m = 0;
  int x;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  for (int i = 1; i < n; i++) {
    m = max(arr[i - 1] - arr[i] - c, m);
  }
  cout << m << endl;
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
}
