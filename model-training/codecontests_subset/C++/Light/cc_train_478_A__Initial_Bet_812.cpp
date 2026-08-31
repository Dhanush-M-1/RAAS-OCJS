#include <bits/stdc++.h>
using namespace std;
int main() {
  int x[5];
  cin >> x[0] >> x[1] >> x[2] >> x[3] >> x[4];
  if ((x[0] + x[1] + x[2] + x[3] + x[4]) % 5 == 0 &&
      (x[0] + x[1] + x[2] + x[3] + x[4]) != 0)
    cout << (x[0] + x[1] + x[2] + x[3] + x[4]) / 5;
  else
    cout << -1;
  return 0;
}
