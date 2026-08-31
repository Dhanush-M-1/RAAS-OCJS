#include <bits/stdc++.h>
int c[10];
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  int a[n], i;
  string s;
  cin >> s;
  for (i = 0; i < n; i++) {
    c[s[i] - '0']++;
  }
  int ans = 0;
  for (i = 1; i <= c[8]; i++) {
    if ((n - i) >= 10 * i) ans = i;
  }
  cout << ans;
  return 0;
}
