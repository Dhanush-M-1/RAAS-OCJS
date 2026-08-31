#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, l = 0;
  int a[n];
  for (int k = 0; k < 5; k++) {
    cin >> a[k];
    l += a[k];
  }
  if (l % 5 == 0 && l != 0)
    cout << l / 5;
  else
    cout << -1;
  return 0;
}
