#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int main() {
  long long int n, i, l, r, a;
  string s, test;
  bool ans;
  cin >> n >> test;
  ans = false;
  for (i = 0; i < n - 1; i++) {
    if (test[i] > test[i + 1]) {
      ans = true;
      l = i + 1;
      break;
    }
  }
  r = l + 1;
  if (ans) {
    cout << "YES\n" << l << " " << r << '\n';
  } else {
    cout << "NO\n";
  }
  return 0;
}
