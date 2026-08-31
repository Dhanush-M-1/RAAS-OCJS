#include <bits/stdc++.h>
using namespace std;
int ni() {
  int a;
  scanf("%d", &a);
  return a;
}
double nf() {
  double a;
  scanf("%lf", &a);
  return a;
}
char sbuf[100005];
string ns() {
  scanf("%s", sbuf);
  return sbuf;
}
long long nll() {
  long long a;
  scanf("%lld", &a);
  return a;
}
template <class T>
void out(T a, T b) {
  bool first = true;
  for (T i = a; i != b; ++i) {
    if (!first) printf(" ");
    first = false;
    cout << *i;
  }
  printf("\n");
}
template <class T>
void outl(T a, T b) {
  for (T i = a; i != b; ++i) {
    cout << *i << "\n";
  }
}
int n, m;
bool moo(long long cx, long long cy, long long x, long long y) {
  if ((x * cx + y * cy) % (cx * cx + cy * cy) != 0) return false;
  if ((y * cx - x * cy) % (cx * cx + cy * cy) != 0) return false;
  return true;
}
int main() {
  int i, j, k;
  int x = ni();
  int y = ni();
  int tx = ni();
  int ty = ni();
  int cx = ni();
  int cy = ni();
  if (cx == 0 && cy == 0) {
    for (i = (0); i < (((4))); ++i) {
      if (x == tx && y == ty) {
        printf("YES\n");
        return 0;
      }
      swap(x, y);
      x = -x;
    }
    printf("NO\n");
    return 0;
  }
  for (i = (0); i < (((4))); ++i) {
    if (moo(cx, cy, tx - x, ty - y)) {
      printf("YES\n");
      return 0;
    }
    swap(x, y);
    x = -x;
  }
  printf("NO\n");
  return 0;
}
