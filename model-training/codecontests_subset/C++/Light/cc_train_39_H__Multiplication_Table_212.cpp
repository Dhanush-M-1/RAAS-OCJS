#include <bits/stdc++.h>
using namespace std;
int n, a[101];
void print(int m) {
  int cnt = 0;
  while (m) a[cnt++] = m % n, m /= n;
  reverse(a, a + cnt);
  for (int i = 0; i < cnt; i++) printf("%d", a[i]);
  printf(" ");
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) print(i * j);
    puts("");
  }
  return 0;
}
