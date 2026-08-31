#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[200], num = 0;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    if (a[i] == 100) num++;
  }
  int x = num * 50 + (n - num) * 100;
  if (x % 100 != 0 || n == 1)
    cout << "NO" << endl;
  else {
    if (x % 200 == 0)
      cout << "YES" << endl;
    else {
      if (num > 1)
        cout << "YES" << endl;
      else
        cout << "NO" << endl;
    }
  }
  return 0;
}
