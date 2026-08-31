#include <bits/stdc++.h>
using namespace std;
int main(int argc, char** argv) {
  int n, x, y, k;
  cin >> n >> x >> y;
  k = n * y;
  if (k % 100 != 0) {
    k = n * y / 100 + 1;
  } else
    k = n * y / 100;
  x = k - x;
  if (x < 0)
    cout << 0;
  else
    cout << x;
  return 0;
}
