#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, w = 0;
  cin >> a >> b;
  int h = 1;
  for (;; h++) {
    a--;
    w++;
    if (w == b) {
      w = 0;
      a++;
    }
    if (a <= 0) break;
  }
  cout << h;
}
