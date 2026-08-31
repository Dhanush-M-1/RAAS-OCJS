#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  int n, a, b, c, k;
  long long ans = 0;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= a; i += 2) {
    for (int j = 0; j <= c; j++) {
      k = i / 2 + j * 2;
      if (k > n)
        break;
      else if (n - k <= b)
        ans++;
    }
  }
  cout << ans;
  return 0;
}
