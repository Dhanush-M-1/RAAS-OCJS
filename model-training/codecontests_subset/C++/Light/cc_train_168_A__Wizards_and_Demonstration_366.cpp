#include <bits/stdc++.h>
using namespace std;
int n, y, cal, x;
void calcular(int n, int y) {
  cal = (n * y) / 100;
  if ((n * y) % 100 != 0) cal++;
}
int main() {
  cin >> n >> x >> y;
  calcular(n, y);
  if (cal < x)
    cout << "0";
  else
    cout << cal - x;
  return 0;
}
