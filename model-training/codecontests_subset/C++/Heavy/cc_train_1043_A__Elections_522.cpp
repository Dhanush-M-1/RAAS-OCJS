#include <bits/stdc++.h>
using namespace std;
long long int mod = 1000000007;
long long int power(long long int a, long long int b) {
  long long int value = 1;
  while (b) {
    if (b & 1) {
      value *= a;
    }
    a *= a;
    b /= 2;
  }
  return value;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n;
  cin >> n;
  long long int a[n];
  long long int mx = 0, sum = 0;
  for (long long int i = 0; i < n; i++) {
    cin >> a[i];
    mx = max(mx, a[i]);
    sum += a[i];
  }
  long long int ans = 0;
  for (long long int i = mx; i < 1000000; i++) {
    if (i * n > 2 * sum) {
      ans = i;
      break;
    }
  }
  cout << ans << endl;
  return 0;
}
