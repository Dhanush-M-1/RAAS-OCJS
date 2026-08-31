#include <bits/stdc++.h>
using namespace std;
char a[100], b[100], c[100], d[100];
int la, lb, lc, ld, n;
bool equ(char* a, int la, char* b, int lb) {
  if (la != lb) return false;
  for (int i = 0; i < la; i++)
    if (a[i] != b[i]) return false;
  return true;
}
void modify(char* a, int* la, char* b, int* lb) {
  for (int i = 0; i < (*lb); i++) a[i] = b[i];
  *la = *lb;
}
void print(char* a, int la, char* b, int lb) {
  for (int i = 0; i < la; i++) printf("%c", a[i]);
  printf(" ");
  for (int i = 0; i < lb; i++) printf("%c", b[i]);
  printf("\n");
}
int main() {
  scanf("%s%s", &a, &b);
  la = 0;
  while (a[la] != '\0') la++;
  lb = 0;
  while (b[lb] != '\0') lb++;
  print(a, la, b, lb);
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%s%s", &c, &d);
    lc = 0;
    while (c[lc] != '\0') lc++;
    ld = 0;
    while (d[ld] != '\0') ld++;
    if (equ(a, la, c, lc))
      modify(a, &la, d, &ld);
    else
      modify(b, &lb, d, &ld);
    print(a, la, b, lb);
  }
}
