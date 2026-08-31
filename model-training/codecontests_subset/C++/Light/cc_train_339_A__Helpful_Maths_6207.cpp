#include <bits/stdc++.h>
int main() {
  int j, k;
  char a[100];
  scanf("%s", a);
  for (int i = 2; i < strlen(a); i += 2) {
    k = a[i];
    j = i - 2;
    while (j >= 0 && a[j] > k) {
      a[j + 2] = a[j];
      j = j - 2;
    }
    a[j + 2] = k;
  }
  printf("%s", a);
}
