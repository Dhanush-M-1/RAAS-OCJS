#include <bits/stdc++.h>
using namespace std;
long n, a, b, c;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> a >> b >> c;
  swap(a, c);
  c = c / 2;
  long ans = 0;
  for (int i = 0; i <= a * 2; i += 2) {
    if (i > n) break;
    if (b + c < n - i) {
      continue;
    }
    long need = n - i;
    long cur = min(min(min(b + 1, c + 1), b + c - need + 1), need + 1);
    ans += cur;
  }
  cout << ans;
  return 0;
}
