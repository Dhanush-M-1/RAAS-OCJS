#include <bits/stdc++.h>
using namespace std;
template <class T>
T sqr(T a) {
  return a * a;
}
template <class T>
T abs(T x) {
  if (x < 0) return -x;
  return x;
}
const double eps = 1e-8;
const double pi = acos(-1.0);
char str[200010];
int main() {
  int n, i, f, a, b;
  while (1 == scanf("%d", &n)) {
    f = a = b = 0;
    scanf("%s", str);
    for (i = 0; i < n; i++) {
      if (str[i] == 'F')
        f++;
      else if (str[i] == 'A')
        a++;
      else
        b++;
    }
    if (b == 1)
      printf("%d\n", b);
    else if (b)
      printf("%d\n", 0);
    else
      printf("%d\n", a);
  }
  return 0;
}
