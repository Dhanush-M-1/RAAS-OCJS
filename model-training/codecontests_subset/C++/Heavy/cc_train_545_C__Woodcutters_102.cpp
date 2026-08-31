#include <bits/stdc++.h>
const long long int mod = 1000000007;
const long long int AM = 2e6 + 5;
using namespace std;
long long int powm(long long int a, long long int b, long long int n) {
  long long int x = 1, y = a;
  while (b > 0) {
    if (b % 2 == 1) {
      x = (x * y) % n;
    }
    y = (y * y) % n;
    b /= 2;
  }
  return x % n;
}
long long int pow(long long int x, long long int y) {
  long long int res = 1;
  while (y > 0) {
    if (y & 1) res = ((res) * (x));
    y = y >> 1;
    x = ((x) * (x));
  }
  return res;
}
long long int fact(long long int n) {
  long long int ans = 1;
  for (long long int i = 1; i <= n; i++) ans *= i;
  return ans;
}
long long int nCr(long long int n, long long int r) {
  if (r > n - r) r = n - r;
  long long int ans = 1, i;
  for (i = 1; i <= r; i++) {
    ans *= n - r + i;
    ans /= i;
  }
  return ans;
}
bool isPrime(long long int n) {
  if (n <= 1) return false;
  for (long long int i = 2; i < n; i++)
    if (n % i == 0) return false;
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  long long int n;
  cin >> n;
  long long int a[n + 1], h[n + 1], c[n + 1];
  a[0] = -9999999999;
  h[0] = 0;
  for (long long int i = 1; i <= n; i++) {
    cin >> a[i];
    cin >> h[i];
  }
  for (long long int i = 1; i <= n; i++) c[i] = a[i - 1];
  long long int ans = 1;
  for (long long int i = 1; i < n; i++) {
    if (a[i] - c[i] > h[i])
      ans++;
    else if (a[i + 1] - a[i] > h[i]) {
      ans++;
      c[i + 1] = c[i + 1] + h[i];
    }
  }
  cout << ans;
}
