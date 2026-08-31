#include <bits/stdc++.h>
using namespace std;
long long int dx[] = {1, -1, 0, 0};
long long int dy[] = {0, 0, -1, 1};
long long int gcd(long long int a, long long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long int power_mod(long long int a, long long int n) {
  long long int res = 1;
  while (n > 0) {
    if (n & 1)
      res = ((res % 998244353) * (a % 998244353)) % 998244353, n--;
    else
      a = ((a % 998244353) * (a % 998244353)) % 998244353, n /= 2;
  }
  return res;
}
long long int nCr(long long int n, long long int r) {
  if (r > n) return 0;
  double res = 1;
  for (long long int i = 1; i <= r; i++) res = (res * (n - r + i)) / i;
  return (long long int)(res + 0.01);
}
long long int power(long long int a, long long int n) {
  long long int res = 1;
  for (long long int i = 0; i < n; i++) res = res * a;
  return res;
}
bool cmp(vector<long long int> a, vector<long long int> b) {
  return a[0] < b[0];
}
bool is_power_of_two(long long int n) {
  for (long long int i = 0; i < 32; i++) {
    if ((1 << i) == n) return true;
  }
  return false;
}
long long int len(long long int n) {
  string s = to_string(n);
  return s.size();
}
void solve() {
  long long int p[21];
  for (long long int i = 0; i < 20; i++) {
    p[i] = power_mod(10, i) % 998244353;
  }
  long long int n;
  cin >> n;
  long long int a[n];
  long long int dp[11];
  for (long long int i = 0; i < 11; i++) dp[i] = 0;
  for (long long int i = 0; i < n; i++) cin >> a[i], dp[len(a[i])]++;
  long long int ans = 0;
  for (long long int i = 0; i < n; i++) {
    string s = to_string(a[i]);
    long long int cnt = 0;
    for (long long int j = s.size() - 1; j >= 0; j--) {
      ans = (ans % 998244353 + ((s[j] - '0') * p[cnt]) % 998244353) % 998244353;
      cnt += 2;
    }
    cnt = 1;
    for (long long int j = s.size() - 1; j >= 0; j--) {
      ans = (ans % 998244353 + ((s[j] - '0') * p[cnt]) % 998244353) % 998244353;
      cnt += 2;
    }
  }
  for (long long int i = 0; i < n; i++) {
    string s = to_string(a[i]);
    long long int l = s.size();
    dp[l]--;
    for (long long int j = 1; j < 11; j++) {
      long long int temp = 0;
      long long int cnt = 0;
      long long int cn = 0;
      for (long long int k = l - 1; k >= 0; k--) {
        temp = (temp % 998244353 + ((s[k] - '0') * p[cnt]) % 998244353) %
               998244353;
        cn++;
        if (cn < j + 1)
          cnt += 2;
        else
          cnt++;
      }
      ans = (ans % 998244353 +
             ((temp % 998244353) * (dp[j] % 998244353)) % 998244353) %
            998244353;
      temp = 0;
      cnt = 1;
      cn = 0;
      for (long long int k = l - 1; k >= 0; k--) {
        temp = (temp % 998244353 + ((s[k] - '0') * p[cnt]) % 998244353) %
               998244353;
        cn++;
        if (cn < j)
          cnt += 2;
        else
          cnt++;
      }
      ans = (ans % 998244353 +
             ((temp % 998244353) * (dp[j] % 998244353)) % 998244353) %
            998244353;
    }
    dp[l]++;
  }
  cout << ans % 998244353;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int t = 1;
  while (t--) {
    solve();
  }
}
