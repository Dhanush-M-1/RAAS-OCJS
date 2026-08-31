#include <bits/stdc++.h>
using namespace std;
int main() {
  int c, b, a, totc = 0;
  cin >> c >> b;
  a = c;
  totc += c;
  while (b <= a) {
    totc += a / b;
    a = (a / b) + (a % b);
  }
  cout << totc << endl;
  return 0;
}
