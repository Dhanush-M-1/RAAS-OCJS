#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, n, sum = 0, i, j;
  cin >> n >> a >> b >> c;
  a = a / 2;
  for (i = 0; i <= a; i++) {
    for (j = 0; j <= c; j++) {
      int s = n - i - j * 2;
      if (s >= 0 && s <= b) {
        sum++;
      }
    }
  }
  cout << sum << endl;
  return 0;
}
