#include <bits/stdc++.h>
using namespace std;
int main() {
  int aux, c = 0, count = 5;
  while (count--) {
    cin >> aux;
    c += aux;
  }
  if (c % 5 != 0 or c / 5 == 0)
    cout << -1 << endl;
  else
    cout << c / 5 << endl;
  return 0;
}
