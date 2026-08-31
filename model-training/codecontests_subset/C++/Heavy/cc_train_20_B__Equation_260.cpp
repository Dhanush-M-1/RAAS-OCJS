#include <bits/stdc++.h>
using namespace std;
double a, b, c;
struct node {
  double x1, x2;
  int n;
} cx;
node solve() {
  node ax;
  if (a == 0 && b == 0 && c == 0) {
    ax.n = -1;
    return ax;
  }
  if (a == 0 && b == 0 && c != 0) {
    ax.n = 0;
    return ax;
  }
  if (a == 0 && b != 0 && c != 0) {
    ax.n = 1;
    ax.x1 = -c / b;
    return ax;
  }
  if (a == 0 && b != 0 && c == 0) {
    ax.n = 1;
    ax.x1 = 0.0;
    return ax;
  }
  double y = b * b - 4 * a * c;
  if (y < 0) {
    ax.n = 0;
    return ax;
  }
  if (y == 0) {
    ax.n = 1;
    ax.x1 = -b / (2 * a);
    return ax;
  }
  ax.n = 2;
  ax.x1 = (-b + sqrt(y)) / (2 * a);
  ax.x2 = (-b - sqrt(y)) / (2 * a);
  return ax;
}
int main() {
  while (scanf("%lf %lf %lf", &a, &b, &c) != EOF) {
    cx = solve();
    if (cx.n == 0 || cx.n == -1) {
      printf("%d\n", cx.n);
    }
    if (cx.n == 1) {
      printf("%d\n%.10lf\n", cx.n, cx.x1);
      continue;
    }
    if (cx.n == 2) {
      if (cx.x1 < cx.x2) swap(cx.x1, cx.x2);
      printf("%d\n%.10lf\n%.10lf\n", cx.n, cx.x2, cx.x1);
    }
  }
}
