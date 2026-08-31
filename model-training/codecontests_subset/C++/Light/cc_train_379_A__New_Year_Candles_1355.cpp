#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, cont = 0, c = 0;
  cin >> a >> b;
  cont += a;
  while (a >= 0) {
    a -= b;
    if (a >= 0) {
      cont++;
      a++;
    } else {
      break;
    }
  }
  cout << cont << endl;
  return 0;
}
