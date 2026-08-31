#include <bits/stdc++.h>
using namespace std;
int main() {
  int c[5];
  int s = 0;
  for (int i = 0; i < 5; i++) {
    cin >> c[i];
    s += c[i];
  }
  if (s != 0 && s % 5 == 0) {
    cout << s / 5;
    return 0;
  }
  cout << -1;
  return 0;
}
