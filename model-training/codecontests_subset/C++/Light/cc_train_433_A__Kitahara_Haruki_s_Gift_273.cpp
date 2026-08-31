#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x;
  int a[2];
  a[0] = 0;
  a[1] = 0;
  cin >> n;
  int i;
  for (i = 0; i < n; i++) {
    cin >> x;
    if (x == 100)
      a[0]++;
    else
      a[1]++;
  }
  if (a[0] % 2 == 0) {
    if (a[1] % 2 == 0)
      cout << "YES\n";
    else if (a[0] >= 2)
      cout << "YES\n";
    else
      cout << "NO\n";
  } else
    cout << "NO\n";
}
