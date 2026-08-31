#include <bits/stdc++.h>
using namespace std;
double x, y, n, z, t;
int main() {
  cin >> n >> x >> y;
  z = x;
  t = (x / n) * 100;
  while (t < y) {
    x++;
    t = (x / n) * 100;
  }
  cout << x - z << endl;
}
