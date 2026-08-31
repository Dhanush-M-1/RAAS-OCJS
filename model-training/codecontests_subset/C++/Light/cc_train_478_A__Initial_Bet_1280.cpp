#include <bits/stdc++.h>
using namespace std;
int c, s;
int main() {
  for (int i = 0; i < 5; i++) {
    cin >> c;
    s += c;
  }
  if (s % 5 == 0 && s != 0)
    cout << s / 5;
  else
    cout << -1;
  return 0;
}
