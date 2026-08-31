#include <bits/stdc++.h>
using namespace std;
int x[55], y[55];
int main() {
  int n, t;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d%d%d", &x[i], &y[i], &t);
  for (int i = 1; i < n; i++) putchar('(');
  printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", x[1] / 2, 1, 1);
  for (int i = 2; i <= n; i++) {
    printf("+(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1)))))", x[i] / 2, i, i);
  }
  putchar('\n');
  for (int i = 1; i < n; i++) putchar('(');
  printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", y[1] / 2, 1, 1);
  for (int i = 2; i <= n; i++) {
    printf("+(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1)))))", y[i] / 2, i, i);
  }
  putchar('\n');
  cin >> n;
  return 0;
}
