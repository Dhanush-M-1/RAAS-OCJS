#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, ab = 0, hours = 0;
  cin >> a >> b;
  while (a != 0) {
    a--;
    ab++;
    hours++;
    if (ab == b) {
      a++;
      ab = 0;
    }
  }
  cout << hours;
  return 0;
}
