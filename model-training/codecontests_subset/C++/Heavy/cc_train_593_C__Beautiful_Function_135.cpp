#include <bits/stdc++.h>
using namespace std;
int n;
struct node {
  int x, y, r;
} a[58];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d%d%d", &a[i].x, &a[i].y, &a[i].r);
  }
  for (int i = 1; i < n; i++) printf("(");
  for (int i = 1; i <= n; i++) {
    if (i > 1) printf("+");
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", a[i].x / 2, i - 1,
           i - 1);
    if (i > 1) printf(")");
  }
  printf("\n");
  for (int i = 1; i < n; i++) printf("(");
  for (int i = 1; i <= n; i++) {
    if (i > 1) printf("+");
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", a[i].y / 2, i - 1,
           i - 1);
    if (i > 1) printf(")");
  }
  return 0;
}
