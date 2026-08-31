#include <bits/stdc++.h>
using namespace std;
char c;
int n, len, nump, nume, sum;
int po[110], ne[110], a[110];
void Display() {
  printf("Possible\n");
  int cur = 1;
  printf("%d", a[0]);
  for (int i = 1; i < len; i++)
    if (po[cur] == i) {
      printf(" + %d", a[i]);
      cur++;
    } else
      printf(" - %d", a[i]);
  printf(" = %d\n", n);
}
int main() {
  len = nump = 1;
  nume = po[0] = 0;
  while (scanf(" %c", &c) && c != '=') {
    if (c == '?') continue;
    if (c == '+')
      po[nump++] = len++;
    else
      ne[nume++] = len++;
  }
  scanf("%d", &n);
  if (nump > nume) {
    sum = nume * n + n;
    if (nump > sum)
      printf("Impossible\n");
    else {
      for (int i = 0; i < nume; i++) a[ne[i]] = n;
      for (int i = 0; i < nump; i++) {
        a[po[i]] = sum / (nump - i);
        sum -= a[po[i]];
      }
      Display();
    }
  } else {
    sum = nump * n - n;
    if (sum < nume)
      printf("Impossible\n");
    else {
      for (int i = 0; i < nump; i++) a[po[i]] = n;
      for (int i = 0; i < nume; i++) {
        a[ne[i]] = sum / (nume - i);
        sum -= a[ne[i]];
      }
      Display();
    }
  }
  return 0;
}
