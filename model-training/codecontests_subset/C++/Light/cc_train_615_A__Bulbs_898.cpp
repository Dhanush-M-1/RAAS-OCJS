#include <bits/stdc++.h>
using namespace std;
const long long M = 1e9 + 7;
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
long long lcm(long long a, long long b) { return a * (b / gcd(a, b)); }
long long n, m, x, y;
long long a[101];
int main() {
  cin >> n >> m;
  for (int k = 0; k < n; k++) {
    cin >> x;
    while (x--) {
      cin >> y;
      a[y]++;
    }
  }
  for (int i = 1; i < m + 1; i++) {
    if (!a[i]) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
}
