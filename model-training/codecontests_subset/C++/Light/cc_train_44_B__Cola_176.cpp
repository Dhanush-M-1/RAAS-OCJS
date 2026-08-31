#include <bits/stdc++.h>
using namespace std;
long long int n, a, b, c, ans;
int main() {
  cin >> n >> a >> b >> c;
  for (long long int i = 0; i <= a; i += 2) {
    if (i / 2 == n) {
      ans++;
      goto next;
    }
    if ((n - (i / 2)) % 2 == 0) {
      for (long long int j = 0; j <= b; j += 2)
        if (n - (i / 2) - j >= 0 && (n - (i / 2) - j) / 2 <= c) ans++;
      goto next;
    }
    if ((n - (i / 2)) % 2 == 1) {
      for (long long int j = 1; j <= b; j += 2)
        if (n - (i / 2) - j >= 0 && (n - (i / 2) - j) / 2 <= c) ans++;
    }
  next:;
  }
  cout << ans;
  return 0;
}
