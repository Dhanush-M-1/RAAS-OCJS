#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c = 0, i, s = 0;
  cin >> a >> b;
  for (i = 1; i <= 2000; i++) {
    a--;
    c++;
    if (c == b) {
      a++;
      c = 0;
    }
    if (a == 0) break;
  }
  cout << i;
}
