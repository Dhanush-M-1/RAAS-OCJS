#include <bits/stdc++.h>
using namespace std;
int main(int argc, char *argv[]) {
  double n, x, y;
  cin >> n >> x >> y;
  double res = y / ((float)100.0) * n;
  if (res <= x)
    cout << 0;
  else
    cout << ceil(res - x);
  return 0;
}
