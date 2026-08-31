#include <bits/stdc++.h>
char a[60];
char upper[60];
char lower[60];
char ans[60];
using namespace std;
int main() {
  memset(a, 0, sizeof(a));
  memset(upper, 0, sizeof(upper));
  memset(lower, 0, sizeof(lower));
  memset(ans, 0, sizeof(ans));
  int line, len;
  scanf("%s", a);
  scanf("%d", &line);
  len = strlen(a);
  for (int i = 0; i < len; i++) {
    if (a[i] >= 65 && a[i] <= 90) {
      upper[i] = a[i];
      lower[i] = a[i] - 'A' + 'a';
    } else {
      upper[i] = a[i] - 'a' + 'A';
      lower[i] = a[i];
    }
  }
  for (int i = 0; i < len; i++) {
    if (lower[i] < line + 97) {
      ans[i] = upper[i];
    } else {
      ans[i] = lower[i];
    }
    printf("%c", ans[i]);
  }
  printf("\n");
}
