#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, n, y, r = 0;
  float a;
  cin >> n >> x >> y;
  a = (float)((float)y / 100) * n;
  a = ceil(a);
  if (a > x) r = (int)a - x;
  cout << r << endl;
}
