#include <bits/stdc++.h>
using namespace std;
int n;
void solve(int *x) {
  for (int i = 1; i < n; i++) putchar('(');
  for (int i = 0; i < n; i++) {
    if (i >= 1) putchar('+');
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", x[i] / 2, i, i);
    if (i >= 1) putchar(')');
  }
}
int x[555], y[555], baka;
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%d%d%d", &x[i], &y[i], &baka);
  solve(x);
  cout << endl;
  solve(y);
}
