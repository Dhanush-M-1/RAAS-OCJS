#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  scanf("%d%d%d", &n, &x, &y);
  int t = x;
  while (((double)x / n) * 100 < y) {
    x++;
  }
  cout << x - t << endl;
  return 0;
}
