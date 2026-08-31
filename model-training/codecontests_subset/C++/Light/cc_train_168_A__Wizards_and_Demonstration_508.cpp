#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j;
  double x, y, z;
  cin >> x >> y >> z;
  z /= 100.0;
  x = ceil(x * z);
  if (y >= x)
    puts("0");
  else
    printf("%.lf\n", x - y);
  return 0;
}
