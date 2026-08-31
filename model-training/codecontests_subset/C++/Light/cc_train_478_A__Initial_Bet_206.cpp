#include <bits/stdc++.h>
using namespace std;
long long s, i, c;
int main() {
  s = 0;
  for (i = 1; i <= 5; i++) {
    cin >> c;
    s += c;
  }
  if (s % 5 == 0 && s != 0)
    cout << s / 5 << endl;
  else
    cout << -1 << endl;
  return 0;
}
