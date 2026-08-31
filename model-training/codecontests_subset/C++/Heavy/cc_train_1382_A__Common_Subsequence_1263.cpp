#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1e9 + 7;
const long long int mod1 = 998244353;
const long long int inf = 9e18 + 5;
const double pi = acosl(-1.0l);
const long double eps = 1e-9;
bool equalTo(double a, double b) {
  if (fabs(a - b) <= eps)
    return true;
  else
    return false;
}
bool notEqual(double a, double b) {
  if (fabs(a - b) > eps)
    return true;
  else
    return false;
}
bool lessThan(double a, double b) {
  if (a + eps < b)
    return true;
  else
    return false;
}
bool lessThanEqual(double a, double b) {
  if (a < b + eps)
    return true;
  else
    return false;
}
bool greaterThan(double a, double b) {
  if (a > b + eps)
    return true;
  else
    return false;
}
bool greaterThanEqual(double a, double b) {
  if (a + eps > b)
    return true;
  else
    return false;
}
void swap(long long int &a, long long int &b) {
  long long int t = a;
  a = b;
  b = t;
}
long long int min(long long int a, long long int b) {
  if (a < b) return a;
  return b;
}
long long int max(long long int a, long long int b) {
  if (a > b) return a;
  return b;
}
long long int pow(long long int a, long long int b) {
  a %= mod;
  long long int ans = 1;
  while (b > 0) {
    if (b & 1) ans = ans * a % mod;
    a = a * a % mod;
    b /= 2;
  }
  return ans;
}
int main() {
  ios_base ::sync_with_stdio(0);
  cin.tie(0);
  long long int tc;
  cin >> tc;
  while (tc--) {
    long long int n, m;
    cin >> n >> m;
    long long int a[n];
    long long int b[m];
    map<long long int, long long int> mp;
    for (long long int i = 0; i < n; i++) {
      cin >> a[i];
      mp[a[i]]++;
    }
    long long int pos = -1;
    for (long long int i = 0; i < m; i++) {
      cin >> b[i];
      if (mp[b[i]]) {
        pos = i;
      }
    }
    if (pos == -1) {
      cout << "NO\n";
    } else {
      cout << "YES\n";
      cout << "1 " << b[pos] << "\n";
    }
  }
}
