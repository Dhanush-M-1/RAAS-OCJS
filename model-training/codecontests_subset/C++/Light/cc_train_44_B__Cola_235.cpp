#include <bits/stdc++.h>
using namespace std;
int n, a, b, c, kol = 0;
int main() {
  scanf("%d%d%d%d", &n, &a, &b, &c);
  for (int i = 0; i <= a; i += 2) {
    for (int j = 0; j <= b; j++)
      if ((n - i / 2 - j) >= 0 && (n - i / 2 - j) % 2 == 0 &&
          (n - i / 2 - j) / 2 <= c)
        kol++;
  }
  printf("%d", kol);
}
