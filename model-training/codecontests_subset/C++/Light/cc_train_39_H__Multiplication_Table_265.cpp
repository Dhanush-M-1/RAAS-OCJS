#include <bits/stdc++.h>
using namespace std;
string toBase(int n, int b) {
  string ret = "";
  char buf[200];
  int q = 100, r;
  while (q != 0) {
    q = n / b;
    r = n % b;
    sprintf(buf, "%d", r);
    ret = buf + ret;
    n = q;
  }
  sprintf(buf, "%d", q);
  if (q != 0)
    return buf + ret;
  else
    return ret;
}
int main() {
  int n;
  scanf("%d", &n);
  string mt[15][15];
  string ret;
  for (int r = 1; r <= (n - 1); ++r) {
    for (int c = 1; c <= (n - 1); ++c) {
      ret = toBase(r * c, n);
      printf("%s", ret.c_str());
      if (c != (n - 1)) printf(" ");
    }
    if (r != (n - 1)) printf("\n");
  }
  return 0;
}
