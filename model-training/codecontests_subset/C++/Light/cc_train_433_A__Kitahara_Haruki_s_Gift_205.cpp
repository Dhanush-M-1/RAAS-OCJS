#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, i, o = 0, t = 0, s = 0;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> x;
    s += x;
    if (x == 100) {
      o++;
    } else
      t++;
  }
  if (o == 0) {
    if (t % 2 == 0) {
      cout << "YES";
    } else
      cout << "NO";
  } else if ((s % 200) != 0) {
    cout << "NO";
  } else {
    s = s / 2;
    if (s % 100 == 0) {
      cout << "YES";
    } else
      cout << "NO";
  }
  return 0;
}
