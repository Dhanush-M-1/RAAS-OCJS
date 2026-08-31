#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, flag = 0, f1 = 0, f2 = 0, f3 = 0;
  char a[200006];
  scanf("%d", &n);
  scanf("%s", a);
  for (i = 0; i < n; i++) {
    if (a[i] == 'A') {
      f1++;
    } else if (a[i] == 'F') {
      f2++;
    } else if (a[i] == 'I') {
      f3++;
    }
  }
  if (f3 >= 2) {
    printf("0");
    return 0;
  } else if (f3 == 0) {
    printf("%d", f1);
    return 0;
  } else {
    printf("1");
    return 0;
  }
}
