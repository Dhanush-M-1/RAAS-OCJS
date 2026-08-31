#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, cnt = 0, nn = 0;
  scanf("%d%d", &n, &m);
  while (n) {
    cnt++;
    n--;
    nn++;
    n += nn / m;
    nn %= m;
  }
  printf("%d\n", cnt);
}
