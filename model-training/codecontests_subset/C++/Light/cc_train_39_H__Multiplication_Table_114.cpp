#include <bits/stdc++.h>
using namespace std;
int main() {
  int a;
  cin >> a;
  for (int i = 1; i <= a - 1; i++, putchar('\n'))
    for (int j = 1; j <= a - 1; j++)
      if (j != 1)
        printf("%2d ", (i * j / a) * 10 + (i * j) % a);
      else
        printf("%d ", i * j);
}
