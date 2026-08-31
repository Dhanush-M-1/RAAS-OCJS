#include <bits/stdc++.h>
using std::sort;
const int SIZE = 100;
int dig[SIZE + 10];
char str[SIZE + 10];
int strsplit(char *str, int len) {
  int size = -1;
  for (char *p = strtok(str, "+"); p != NULL; p = strtok(NULL, "+"))
    sscanf(p, "%d", &dig[++size]);
  return size;
}
int main() {
  while (scanf("%s", str) != -1) {
    int len = strlen(str);
    int size = strsplit(str, len);
    if (size < 0) {
      printf("\n");
      continue;
    }
    sort(dig, dig + size + 1);
    for (int i = 0; i < size; i++) printf("%d+", dig[i]);
    printf("%d\n", dig[size]);
  }
  return 0;
}
