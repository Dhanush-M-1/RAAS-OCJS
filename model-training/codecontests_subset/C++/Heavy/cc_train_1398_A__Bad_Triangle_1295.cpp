#include <bits/stdc++.h>
#pragma GCC optimize("O3")
int mod = 1000000007;
using namespace std;
bool isp(long long x) {
  for (long long i = 2; i * i <= x; ++i)
    if (x % i == 0) return false;
  return true;
}
void pog() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
}
bool sortinrev(const pair<long long, long long> &a,
               const pair<long long, long long> &b) {
  return (a.first > b.first);
}
bool prime_check(long long n) {
  bool flag = 1;
  for (long long i = 2; i <= sqrt(n); i++) {
    if (n % i == 0) {
      flag = 0;
      break;
    }
  }
  return flag;
}
long long power(long long x, unsigned long long y, long long p) {
  long long res = 1;
  x = x % p;
  if (x == 0) return 0;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
int32_t main() {
  pog();
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    long long arr[n];
    for (long long i = 0; i < n; i++) {
      cin >> arr[i];
    };
    long long sum = arr[0] + arr[1];
    long long flag = 0;
    for (long long i = 2; i < n; i++)
      if (sum <= arr[i]) {
        flag = i + 1;
        break;
      }
    if (flag)
      cout << 1 << " " << 2 << " " << flag << "\n";
    else
      cout << -1 << "\n";
  }
}
