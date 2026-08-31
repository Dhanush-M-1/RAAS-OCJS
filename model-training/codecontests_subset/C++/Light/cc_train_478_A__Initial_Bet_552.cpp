#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d, e;
  scanf("%d%d%d%d%d", &a, &b, &c, &d, &e);
  int x = a + b + c + d + e;
  if (x % 5 == 0 && x != 0) {
    x = x / 5;
    cout << x;
  } else
    cout << "-1";
  return 0;
}
