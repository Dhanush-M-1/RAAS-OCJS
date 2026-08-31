#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  char a[105];
  int ans = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] == '8') ans++;
  }
  if (n < 11 || ans == 0) {
    cout << 0 << endl;
    return 0;
  }
  if (ans >= n / 11)
    cout << n / 11 << endl;
  else
    cout << ans << endl;
}
