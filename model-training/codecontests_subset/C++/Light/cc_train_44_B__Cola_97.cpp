#include <bits/stdc++.h>
using namespace std;
int main() {
  int liters, half, one, two, c = 0, temp;
  cin >> liters >> half >> one >> two;
  if (half % 2 != 0)
    half = (half - 1) * 0.5;
  else
    half = half * 0.5;
  two = two * 2;
  for (int i = half; i >= 0; i--) {
    for (int j = one; j >= 0; j--) {
      temp = liters - (i + j);
      if (temp >= 0 && temp % 2 == 0 && two >= temp) c++;
    }
  }
  cout << c << endl;
  return 0;
}
