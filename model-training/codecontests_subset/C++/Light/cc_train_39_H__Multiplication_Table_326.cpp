#include <bits/stdc++.h>
using namespace std;
int k;
int main() {
  cin >> k;
  for (int i = 1; i < k; i++, printf("\n"))
    for (int j = 1; j < k; j++)
      if (j != 1)
        printf("%2d ", (i * j / k) * 10 + (i * j) % k);
      else
        printf("%d ", i * j);
}
