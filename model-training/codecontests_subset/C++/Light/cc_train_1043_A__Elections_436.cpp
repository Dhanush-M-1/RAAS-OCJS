#include <bits/stdc++.h>
using namespace std;
inline int in() {
  int x, y;
  y = scanf("%d", &x);
  return x;
}
int main() {
  int n = in();
  int s = 0, m = 0;
  for (int i = 0; i < n; i++) {
    int nb = in();
    s += nb;
    m = max(nb, m);
  }
  std::cout << max(m, (2 * s) / n + 1);
  return 0;
}
