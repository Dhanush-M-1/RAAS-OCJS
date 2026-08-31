#include <bits/stdc++.h>
using namespace std;
int n, x[55], y[55], s[55];
void f() {
  for (int i = (1); i <= (n - 1); i++) printf("(");
  for (int i = (1); i <= (n); i++) {
    if (i < 50)
      printf("(%d*((abs((t-%d))+abs((t-%d)))-(abs((t-%d))+abs((t-%d)))))", s[i],
             i + 1, i - 1, i, i);
    else
      printf("(%d*((abs((t-%d))+abs((t-(50+1))))-(abs((t-%d))+abs((t-%d)))))",
             s[i], i - 1, i, i);
    if (i > 1) printf(")");
    if (i < n)
      printf("+");
    else
      printf("\n");
  }
  return;
}
int main() {
  scanf("%d", &n);
  for (int i = (1); i <= (n); i++) {
    int k;
    scanf("%d %d %d", &x[i], &y[i], &k);
    if (x[i] & 1) {
      if (x[i] > 0)
        x[i]--;
      else
        x[i]++;
    }
    if (y[i] & 1) {
      if (y[i] > 0)
        y[i]--;
      else
        y[i]++;
    }
  }
  for (int i = (1); i <= (n); i++) s[i] = x[i] / 2;
  f();
  for (int i = (1); i <= (n); i++) s[i] = y[i] / 2;
  f();
  return 0;
}
