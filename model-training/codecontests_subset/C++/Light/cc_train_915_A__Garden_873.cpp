#include <bits/stdc++.h>
using namespace std;
long long int mod = 1e9 + 7;
long long int gcd(long long int a, long long int b) {
  return b ? gcd(b, a % b) : a;
}
int main() {
  int n, k;
  cin >> n >> k;
  int ans = 1e9;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    if (k % a == 0) {
      ans = min(ans, k / a);
    }
  }
  cout << ans << endl;
}
