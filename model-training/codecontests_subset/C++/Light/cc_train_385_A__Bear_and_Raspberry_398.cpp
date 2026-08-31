#include <bits/stdc++.h>
using namespace std;
int n, c, ar[120], in1, in2, i, j, out;
int main(void) {
  scanf("%d%d", &n, &c);
  j = 0;
  for (i = 0; i < n; i++) {
    scanf("%d", &in1);
    if (i > 0) ar[j++] = in2 - in1;
    in2 = in1;
  }
  sort(ar, ar + j);
  j = j - 1;
  if ((ar[j] - c) > 0)
    printf("%d\n", ar[j] - c);
  else
    printf("0\n");
  return 0;
}
