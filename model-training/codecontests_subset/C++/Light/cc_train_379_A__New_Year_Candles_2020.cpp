#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int hours_light_up;
  hours_light_up = a;
  int a1 = a;
  hours_light_up = hours_light_up + a1 / b;
  while (a1 / b >= b) {
    a1 = a1 / b;
    a1 = a1 + a - a1 * b;
    a = a1;
    hours_light_up = hours_light_up + a1 / b;
  }
  if (a1 / b < b) {
    a1 = a1 / b;
    a1 = a1 + a - a1 * b;
    hours_light_up = hours_light_up + a1 / b;
  }
  cout << hours_light_up;
  return 0;
}
