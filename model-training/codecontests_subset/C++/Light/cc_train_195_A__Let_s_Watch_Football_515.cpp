#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int tt = a * c;
  int tmp;
  for (int i = 1; i <= tt; i++) {
    tmp = i * b;
    tmp = tmp + c * b;
    if (tmp >= tt) {
      printf("%d\n", i);
      return 0;
    }
  }
  return 0;
}
