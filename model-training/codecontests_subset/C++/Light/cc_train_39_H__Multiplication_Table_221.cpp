#include <bits/stdc++.h>
using namespace std;
void bas(int number, int base) {
  int final[99];
  double remainder;
  int i = 0;
  while (number != 0) {
    remainder = (number % base);
    final[i] = remainder;
    i++;
    number = number / base;
  }
  for (i--; i > -1; i--) {
    if (final[i] < 10)
      cout << final[i];
    else
      cout << char(final[i] - 10 + 'a');
  }
}
int main() {
  int base;
  cin >> base;
  int a[base][base], i, j;
  for (i = 1; i < base; i++) {
    for (j = 1; j < base; j++) {
      bas(i * j, base);
      if (j < base - 1) cout << " ";
    }
    cout << endl;
  }
  return 0;
}
