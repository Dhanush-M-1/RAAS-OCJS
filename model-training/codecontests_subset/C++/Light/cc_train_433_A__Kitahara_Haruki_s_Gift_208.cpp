#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[101], ans = 0;
  cin >> n;
  bool flag = false;
  for (int i = 1; i <= n; i += 1) {
    cin >> a[i];
    if (a[i] == 100) flag = true;
    ans += a[i];
  }
  if (ans % 200 == 100)
    cout << "NO" << endl;
  else {
    if (ans % 400 == 0)
      cout << "YES" << endl;
    else if (flag)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
  return 0;
}
