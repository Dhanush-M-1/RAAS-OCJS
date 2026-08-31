#include <bits/stdc++.h>
using namespace std;
int x[60], y[60], r;
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> x[i] >> y[i] >> r;
  for (int i = 0; i < n; i++) {
    if (i)
      printf("+");
    else
      for (int j = 0; j < n - 1; j++) printf("(");
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", x[i] / 2, i, i);
    if (i) printf(")");
  }
  printf("\n");
  for (int i = 0; i < n; i++) {
    if (i)
      printf("+");
    else
      for (int j = 0; j < n - 1; j++) printf("(");
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", y[i] / 2, i, i);
    if (i) printf(")");
  }
  return 0;
}
