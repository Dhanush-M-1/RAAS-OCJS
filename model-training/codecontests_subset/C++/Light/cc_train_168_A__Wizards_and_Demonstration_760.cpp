#include <bits/stdc++.h>
using namespace std;
int a[7];
long long exp(long long a, long long b, long long mod = 1e9 + 7) {
  long long tem = 1;
  while (b) {
    if (b % 2) tem = (tem * a) % mod;
    a = (a * a) % mod;
    b = b / 2;
  }
  return tem;
}
int main() {
  for (int i = 0; i < 3; i++) cin >> a[i];
  int ans = 0;
  double tem = (1.0 * a[0] * a[2]) / 100;
  if (tem == (int)tem)
    ans = max((int)tem - a[1], 0);
  else
    ans = max((int)tem + 1 - a[1], 0);
  cout << ans << "\n";
  return 0;
}
