#include <bits/stdc++.h>
using namespace std;
int a[110];
int main() {
  int i, n, len, p, j;
  string s;
  getline(cin, s);
  len = 0;
  p = 0;
  a[len++] = 1;
  p++;
  for (i = 0; i < s.length(); i++) {
    if (s[i] == '+') {
      a[len++] = 1;
      p++;
    } else if (s[i] == '-') {
      a[len++] = -1;
      p--;
    } else if (s[i] == '=') {
      n = 0;
      for (j = i + 2; j < s.length(); j++) {
        n = n * 10 + (s[j] - '0');
      }
      break;
    }
  }
  for (i = 0; i < len; i++) {
    while (p > n && a[i] < 0 && abs(a[i]) < n) {
      p--;
      a[i]--;
    }
    while (p < n && a[i] > 0 && a[i] < n) {
      p++;
      a[i]++;
    }
  }
  if (p != n) {
    printf("Impossible\n");
    return 0;
  }
  printf("Possible\n");
  for (i = 0; i < len; i++) {
    if (i > 0) {
      if (a[i] > 0)
        printf(" + ");
      else
        printf(" - ");
    }
    printf("%d", abs(a[i]));
  }
  printf(" = %d\n", n);
  return 0;
}
