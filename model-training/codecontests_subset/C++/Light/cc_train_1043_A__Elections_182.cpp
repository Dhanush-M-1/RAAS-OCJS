#include <bits/stdc++.h>
using namespace std;
int cas = 1;
int dxx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dyy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
int dx[] = {-1, 0, 0, 1};
int dy[] = {0, -1, 1, 0};
struct node {
  int x, y;
  bool operator<(const node& p) const { return x < p.x; }
};
int main() {
  int n;
  scanf("%d", &n);
  int sum = 0;
  int a[105];
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    sum += a[i];
  }
  sort(a, a + n);
  int x = a[n - 1];
  for (;; x++) {
    int g = 0;
    for (int i = 0; i < n; i++) {
      g += (x - a[i]);
    }
    if (g > sum) {
      printf("%d\n", x);
      return 0;
    }
  }
  return 0;
}
