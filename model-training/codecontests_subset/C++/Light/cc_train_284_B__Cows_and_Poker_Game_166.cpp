#include <bits/stdc++.h>
using namespace std;
int a[200500];
int main() {
  int n;
  scanf("%d", &n);
  char c;
  int res = 0;
  int A = 0;
  int F = 0;
  int I = 0;
  scanf("\n");
  for (int i = 0; i < n; i++) {
    scanf("%c", &c);
    if (c == 'A') {
      A++;
    }
    if (c == 'F') {
      F++;
    }
    if (c == 'I') {
      I++;
    }
  }
  if (I == 0) {
    res = A;
  }
  if (I == 1) {
    res = 1;
  }
  if (I > 1) {
    res = 0;
  }
  printf("%d", res);
}
