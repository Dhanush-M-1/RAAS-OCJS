#include <bits/stdc++.h>
using namespace std;
const int oo = 1e9;
const int MAXN = 1e2;
int main() {
  ios::sync_with_stdio(0);
  int n, x, y;
  scanf("%d %d %d", &n, &x, &y);
  printf("%d", max(0, int(ceil(double(n) * y / 100)) - x));
  return 0;
}
