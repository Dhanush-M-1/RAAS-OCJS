#include <bits/stdc++.h>
using namespace std;
int main() {
  int x1, x2, x3, x4, x5, tot;
  cin >> x1 >> x2 >> x3 >> x4 >> x5;
  tot = x1 + x2 + x3 + x4 + x5;
  if (tot == 0)
    cout << -1;
  else if (tot % 5 == 0)
    cout << tot / 5;
  else
    cout << -1;
  return 0;
}
