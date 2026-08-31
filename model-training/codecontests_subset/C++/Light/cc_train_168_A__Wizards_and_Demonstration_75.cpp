#include <bits/stdc++.h>
using namespace std;
int main() {
  double P;
  int N, wizard;
  scanf("%d %d %lf", &N, &wizard, &P);
  int jawab = max(0, (int)(ceil(P / 100.0 * (double)N) + 0.005) - wizard);
  printf("%d\n", jawab);
  return 0;
}
