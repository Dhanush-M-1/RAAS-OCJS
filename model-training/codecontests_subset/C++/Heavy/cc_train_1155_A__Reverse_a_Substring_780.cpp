#include <bits/stdc++.h>
using namespace std;
long long power(long long a, long long b) {
  long long res = 1;
  a = a % 1000000007;
  while (b > 0) {
    if (b & 1) {
      res = (res * a) % 1000000007;
      b--;
    }
    a = (a * a) % 1000000007;
    b >>= 1;
  }
  return res;
}
long long fermat_inv(long long y) { return power(y, 1000000007 - 2); }
long long gcd(long long a, long long b) { return (b == 0) ? a : gcd(b, a % b); }
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t = 1;
  while (t--) {
    int n;
    cin >> n;
    string s;
    cin >> s;
    int check = -1;
    for (int i = 0; i < n - 1; i++) {
      if (s[i] > s[i + 1]) {
        check = i + 1;
        break;
      }
    }
    if (check == -1) {
      cout << "NO\n";
    } else {
      cout << "YES\n";
      cout << check << " " << (check + 1) << "\n";
    }
  }
  return 0;
}
