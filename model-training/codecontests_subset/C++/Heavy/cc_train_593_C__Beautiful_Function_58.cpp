#include <bits/stdc++.h>
using namespace std;
const int N = 52;
struct circle {
  int x, y;
} a[N];
int n;
void d1(int l, int r) {
  if (l == r) {
    printf("(%d*((1-abs((t-%d)))+abs((1-abs((t-%d))))))", a[l].x / 2, l, l);
    return;
  }
  int mid = (l + r) >> 1;
  printf("(");
  d1(l, mid);
  printf("+");
  d1(mid + 1, r);
  printf(")");
}
void d2(int l, int r) {
  if (l == r) {
    printf("(%d*((1-abs((t-%d)))+abs((1-abs((t-%d))))))", a[l].y / 2, l, l);
    return;
  }
  int mid = (l + r) >> 1;
  printf("(");
  d2(l, mid);
  printf("+");
  d2(mid + 1, r);
  printf(")");
}
int main() {
  scanf("%d", &n);
  int p;
  for (int i = 1; i <= n; i++) {
    scanf("%d%d%d", &a[i].x, &a[i].y, &p);
  }
  d1(1, n);
  puts("");
  d2(1, n);
  puts("");
  return 0;
}
