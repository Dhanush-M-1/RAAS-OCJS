#include <bits/stdc++.h>
using namespace std;
const int N = 55;
int n;
int ar[2][N];
void work(int ttt) {
  const int *a = ar[ttt];
  for (int i = 0; i < n - 1; i++) putchar('(');
  for (int now = 0; now < n; now++) {
    printf("((2-abs((abs((t-(%d-1)))-abs((t-(%d+1))))))*%d)", now, 1 * now,
           a[now] / 2);
    if (now) putchar(')');
    if (now < n - 1) putchar('+');
  }
  putchar(10);
}
int main() {
  scanf("%d", &n);
  int r;
  for (int i = 0; i < n; i++) scanf("%d%d%d", &ar[0][i], &ar[1][i], &r);
  work(0);
  work(1);
  return 0;
}
