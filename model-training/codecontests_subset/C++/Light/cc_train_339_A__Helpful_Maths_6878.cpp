#include <bits/stdc++.h>
using namespace std;
int main() {
  char a[100];
  char temp;
  int i;
  int j;
  scanf("%s", a);
  for (i = 0; (a[i] != '\0') && (a[i + 1] != '\0'); i = i + 2) {
    for (j = 0; (a[j] != '\0') && (a[j + 1] != '\0'); j = j + 2) {
      if (a[j] > a[j + 2]) {
        temp = a[j];
        a[j] = a[j + 2];
        a[j + 2] = temp;
      }
    }
  }
  printf("%s\n", a);
  return 0;
}
