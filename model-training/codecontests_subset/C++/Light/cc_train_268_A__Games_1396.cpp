#include <bits/stdc++.h>
using namespace std;
int n, a, b, d[500], s;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= 2 * n; i++) scanf("%d", &d[i]);
  for (int i = 1; i <= 2 * n; i++)
    for (int j = 1; j <= 2 * n; j++)
      if (d[i] == d[i + (2 * j - 1)]) s++;
  printf("%d", s);
  scanf(" ");
}
