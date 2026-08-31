#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, totData, sec, wait;
  cin >> a >> b >> c;
  totData = a * c;
  sec = totData / b;
  if (totData % b > 0) {
    sec++;
  }
  wait = sec - c;
  if (wait == 0) {
    wait = 1;
  }
  cout << wait;
  return 0;
}
