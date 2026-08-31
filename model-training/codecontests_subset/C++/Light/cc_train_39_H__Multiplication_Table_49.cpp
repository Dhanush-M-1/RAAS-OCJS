#include <bits/stdc++.h>
using namespace std;
int eprintf(const char *format, ...) { return 0; }
string calc(int x, int n) {
  string res = "";
  for (; x; x /= n) res = string(1, '0' + (x % n)) + res;
  return res;
}
int main() {
  int n;
  while (scanf("%d", &n) >= 1) {
    for (int a = 1; a <= n - 1; a++, printf("\n"))
      for (int b = 1; b <= n - 1; b++) {
        int c = a * b;
        string s = calc(c, n);
        if (b > 1)
          printf(" %2s", s.c_str());
        else
          printf("%1s", s.c_str());
      }
    break;
  }
  return 0;
}
