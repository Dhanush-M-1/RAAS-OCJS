#include <bits/stdc++.h>
using namespace std;
long long int power(long long int x, long long int y) {
  long long int res = 1;
  x = x % 1000000007;
  while (y > 0) {
    if (y & 1) res = (res * x) % 1000000007;
    y = y >> 1;
    x = (x * x) % 1000000007;
  }
  return res;
}
long long int prime(long long int x) {
  for (long long int i = 2; i <= sqrt(x); i++) {
    if (x % i == 0) return 0;
  }
  return 1;
}
long long int binary(long long int a[], long long int n, long long int k) {
  long long int low = 0, mid = n / 2, high = n - 1;
  while (low <= high) {
    if (k < a[mid]) {
      high = mid - 1;
    } else if (k > a[mid]) {
      low = mid + 1;
    } else {
      return mid + 1;
    }
    mid = (high + low) / 2;
  }
  return -1;
}
long long int sign(long long int x) { return x > 0; }
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int t = 1;
  while (t--) {
    long long int n = 0, i = 0, j = 0, c = 0, k = 0, x = 0, y = 0, z = 0,
                  flag = 0, flag1 = 0;
    cin >> n;
    for (long long int i = 0; i < n; i++) {
      cin >> k;
      x += k;
    }
    for (long long int i = 0; i < n - 1; i++) {
      cin >> k;
      y += k;
    }
    for (long long int i = 0; i < n - 2; i++) {
      cin >> k;
      z += k;
    }
    cout << x - y << endl << y - z << endl;
  }
  return 0;
}
