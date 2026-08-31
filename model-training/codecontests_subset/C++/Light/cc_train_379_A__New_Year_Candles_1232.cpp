#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, i, hours = 0;
  cin >> a >> b;
  for (i = 1;; i++) {
    a--;
    hours++;
    if (i == b) {
      a++;
      i = 0;
    }
    if (a == 0) break;
  }
  cout << hours;
  return 0;
}
