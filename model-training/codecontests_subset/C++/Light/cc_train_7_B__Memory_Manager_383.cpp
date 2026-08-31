#include <bits/stdc++.h>
using namespace std;
char s[100];
int x;
int t;
int n, m;
int a[10000];
bool free(int x, int n) {
  while (n) {
    if (a[x] != 0) return false;
    x++;
    n--;
  }
  return true;
}
int main() {
  scanf("%d%d\n", &t, &m);
  for (int i = m; i < 1000; i++) a[i] = -1;
  int k = 0;
  bool find;
  for (int i = 0; i < t; i++) {
    scanf("%s", s);
    if (s[0] == 'a') {
      scanf("%d\n", &n);
      find = false;
      for (int i = 0; i < m; i++)
        if (free(i, n)) {
          find = true;
          k++;
          while (n) {
            a[i] = k;
            n--;
            i++;
          }
          break;
        }
      if (find)
        printf("%d\n", k);
      else
        printf("NULL\n");
    }
    if (s[0] == 'e') {
      scanf("%d\n", &x);
      find = false;
      if (x > 0) {
        find = false;
        for (int i = 0; i < m; i++)
          if (a[i] == x) {
            a[i] = 0;
            find = true;
          }
      }
      if (!find) {
        printf("ILLEGAL_ERASE_ARGUMENT\n");
      }
    }
    if (s[0] == 'd') {
      scanf("\n");
      for (int i = 0; i < 3 * m; i++)
        for (int j = 0; j < m - 1; j++)
          if (a[j] == 0) {
            int c = a[j];
            a[j] = a[j + 1];
            a[j + 1] = c;
          }
    }
  }
  return 0;
}
