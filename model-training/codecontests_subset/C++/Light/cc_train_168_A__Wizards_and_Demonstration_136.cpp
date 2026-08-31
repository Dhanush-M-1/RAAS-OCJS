#include <bits/stdc++.h>
using namespace std;
int main(int argc, char *argv[]) {
  int n, x, y;
  cin >> n >> x >> y;
  double d = (double(n) * double(y)) / 100.00;
  int k = ceil(d);
  if (x >= k)
    cout << 0;
  else
    cout << k - x;
  return EXIT_SUCCESS;
}
