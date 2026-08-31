#include <bits/stdc++.h>
int diff(const void *a, const void *b) { return *(int *)a - *(int *)b; }
int main() {
  int len, i, index = 0, arr[1000];
  char str[1000];
  scanf("%s", str);
  len = strlen(str);
  i = 0;
  while (i < len) {
    arr[index++] = str[i] - '0';
    i = i + 2;
  }
  qsort(arr, index, sizeof(int), diff);
  for (i = 0; i < index - 1; i++) printf("%d+", arr[i]);
  printf("%d\n", arr[index - 1]);
  return 0;
}
