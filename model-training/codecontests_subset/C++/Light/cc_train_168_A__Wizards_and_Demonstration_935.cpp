#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  scanf("%d %d %d", &n, &x, &y);
  int z = (y * n) / 100;
  if ((double)z < (y / 100.0) * n) {
    z = z + 1;
  }
  int p = 0;
  while (x + p < z) {
    p++;
  }
  cout << p << endl;
}
