#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  double ans = max((a - b) / b, c * (a - b) / b);
  printf("%d\n", max(0, (int)ceil(ans)));
  return 0;
}
