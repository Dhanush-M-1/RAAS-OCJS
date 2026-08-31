#include <bits/stdc++.h>
using namespace std;
int x, s, n;
int main() {
  for (int i = 1; i <= 5; i++) {
    cin >> x;
    s += x;
  }
  if (s % 5 == 0 && s != 0)
    cout << s / 5;
  else
    cout << "-1";
  return 0;
}
