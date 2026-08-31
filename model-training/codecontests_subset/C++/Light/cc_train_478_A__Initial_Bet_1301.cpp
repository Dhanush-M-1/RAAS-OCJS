#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, i, s = 0;
  for (i = 0; i < 5; i++) {
    cin >> x;
    s = s + x;
  }
  if (s % 5 == 0 && s != 0)
    cout << s / 5;
  else
    cout << -1;
  return 0;
}
