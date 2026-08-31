#include <bits/stdc++.h>
using namespace std;
int main() {
  char str[5000];
  while (gets(str)) {
    int len = strlen(str);
    int num[1000];
    int i, k = 0;
    for (i = 0; i < len; i++) {
      if (str[i] >= '1' && str[i] <= '3') num[k++] = str[i] - '0';
    }
    sort(num, num + k);
    for (i = 0; i < k; i++) {
      printf("%d", num[i]);
      if (i != k - 1) printf("+");
    }
    printf("\n");
  }
  return 0;
}
