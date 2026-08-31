#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, i = 0, on, tw, th, cont = 0;
  cin >> t;
  while (i < 3 * t) {
    cin >> on >> tw >> th;
    while (tw >= 1 && th >= 2) {
      tw -= 1;
      th -= 2;
      cont += 3;
    }
    while (on >= 1 && tw >= 2) {
      on -= 1;
      tw -= 2;
      cont += 3;
    }
    cout << cont << endl;
    cont = 0;
    i += 3;
  }
  return 0;
}
