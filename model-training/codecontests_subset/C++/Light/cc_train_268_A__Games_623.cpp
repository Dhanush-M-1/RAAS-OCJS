#include <bits/stdc++.h>
using namespace std;
int c[100][2];
int main() {
  int n, sum = 0;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%d %d", &c[i][0], &c[i][1]);
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) {
      if (j == i) continue;
      if (c[i][0] == c[j][1]) sum++;
    }
  printf("%d\n", sum);
  return 0;
}
