#include <bits/stdc++.h>
using namespace std;
int n, num, ans, cnt = 0;
char x;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    if (x == '8') num++;
  }
  for (int i = 1; i <= num; i++) {
    for (int j = 1; j <= 11; j++) cnt++;
    if (cnt > n) {
      ans = i - 1;
      break;
    }
    if (cnt == n) {
      ans = i;
      break;
    }
  }
  if (cnt < n) ans = num;
  cout << ans;
  return 0;
}
