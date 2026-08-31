#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  scanf("%d %d %d", &a, &b, &c);
  int r = ceil(a * c / (double)(b));
  for (int i = r; i >= 0; i--) {
    int d = a * c - (i + c - 1) * b;
    if (d <= 0) continue;
    if (d / (double)(b) > 1.0) {
      printf("%d", i + 1);
      return 0;
    }
  }
  return 0;
}
