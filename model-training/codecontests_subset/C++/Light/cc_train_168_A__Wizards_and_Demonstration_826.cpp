#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  double per, res;
  scanf("%d%d%d", &n, &x, &y);
  per = ((x / double(n)) * 100);
  if (per >= y) {
    cout << 0 << "\n";
    return 0;
  }
  per = y - per;
  res = (per / 100) * n;
  cout << ceil(res);
  return 0;
}
