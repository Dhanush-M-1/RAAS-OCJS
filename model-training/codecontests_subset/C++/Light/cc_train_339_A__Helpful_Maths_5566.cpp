#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[101], n, i, j, k = 1, max, t, r;
  char str[101];
  scanf("%s", &str);
  r = strlen(str);
  for (i = 0; i < r; i++)
    if (str[i] >= 49 && str[i] <= 51) {
      a[k] = str[i] - 48;
      k++;
    }
  for (i = k - 1; i >= 2; i--) {
    max = a[i];
    t = i;
    for (j = i - 1; j >= 1; j--)
      if (a[j] > max) {
        max = a[j];
        t = j;
      }
    if (t != i) swap(a[i], a[t]);
  }
  for (i = 1; i < k - 1; i++) printf("%d+", a[i]);
  printf("%d\n", a[k - 1]);
  return 0;
}
