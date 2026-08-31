#include <bits/stdc++.h>
using namespace std;
const long double EPS = 1e-10;
const long long INF = 1e18;
const long double PI = acos(-1.0L);
long long gcd(long long a, long long b) {
  if (b == 0) {
    return a;
  }
  return gcd(b, a % b);
}
int main() {
  int cnt = 1;
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < (n); i++) {
      cin >> a[i];
    }
    if (a[0] + a[1] <= a[n - 1]) {
      cout << "1  2 " << n << "\n";
    } else {
      cout << "-1\n";
    }
  }
  return 0;
}
