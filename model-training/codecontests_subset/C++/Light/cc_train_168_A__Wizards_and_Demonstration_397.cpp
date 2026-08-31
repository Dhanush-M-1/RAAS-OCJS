#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  scanf("%d%d%d", &n, &x, &y);
  printf("%d", max(0, (int)ceil((n * y - 100 * x) / 100.0)));
}
