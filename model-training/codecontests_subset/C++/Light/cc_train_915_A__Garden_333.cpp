#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  long long n, k, p, q, o, b, c, ans = 0, w = 2;
  string s;
  cin >> n >> k;
  long long a[n];
  for (long long i = 0; i < n; i++) cin >> a[i];
  sort(a, a + n);
  for (long long i = n - 1; i >= 0; i--)
    if (k % a[i] == 0) {
      cout << k / a[i] << endl;
      break;
    }
  return 0;
}
