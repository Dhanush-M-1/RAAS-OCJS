#include <bits/stdc++.h>
using namespace std;
int i, n, ans;
int f[10];
char ch;
int main() {
  memset(f, 0, sizeof(f));
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> ch;
    f[ch - 48]++;
  }
  ans = min(n / 11, f[8]);
  cout << ans;
  return 0;
}
