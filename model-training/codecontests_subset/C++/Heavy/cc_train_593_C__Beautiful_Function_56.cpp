#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10;
int n, l1, l2;
char s1[N], s2[N];
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n - 1; ++i) s1[i] = s2[i] = '(';
  l1 = l2 = n - 1;
  for (int i = 1; i <= n; ++i) {
    int x, y, r;
    scanf("%d%d%d", &x, &y, &r);
    l1 += sprintf(s1 + l1, "(%d*(2-abs((abs((t-(%d+1)))-abs((t-(%d-1)))))))",
                  x / 2, i, i);
    l2 += sprintf(s2 + l2, "(%d*(2-abs((abs((t-(%d+1)))-abs((t-(%d-1)))))))",
                  y / 2, i, i);
    if (i != 1) {
      s1[l1++] = ')';
      s2[l2++] = ')';
    }
    if (i != n) {
      s1[l1++] = '+';
      s2[l2++] = '+';
    }
  }
  s1[l1] = s2[l2] = 0;
  printf("%s\n%s\n", s1, s2);
  return 0;
}
