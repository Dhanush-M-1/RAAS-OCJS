#include <bits/stdc++.h>
using namespace std;
int n, x, y;
int main() {
  scanf("%d%d%d", &n, &x, &y);
  int k = 0;
  while (((double)x + k) < ((double)(y * n) / 100)) k++;
  printf("%d", k);
  return 0;
}
