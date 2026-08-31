#include <bits/stdc++.h>
using namespace std;
int main() {
  int num = 0, i = 0, len = 0, a[101] = {0};
  char blank;
  scanf("%d %d%c", &num, &len, &blank);
  for (i = 0; i < num; i++) {
    scanf("%d%c", &a[i], &blank);
  }
  sort(a, a + num);
  for (i = num - 1; i >= 0; i--) {
    if (len % a[i] == 0) break;
  }
  printf("%d", len / a[i]);
}
