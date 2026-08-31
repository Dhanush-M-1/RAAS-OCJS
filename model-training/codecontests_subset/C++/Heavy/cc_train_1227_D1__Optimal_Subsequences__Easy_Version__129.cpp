#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e4 + 9;
struct node {
  int x, y;
} a[maxn];
int b[maxn];
bool cmp(node a, node b) { return a.x == b.x ? a.y < b.y : a.x > b.x; }
map<int, int> A;
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i].x);
    b[i] = a[i].x;
    a[i].y = i;
  }
  sort(a + 1, a + 1 + n, cmp);
  int m;
  scanf("%d", &m);
  while (m--) {
    int k, pos;
    scanf("%d%d", &k, &pos);
    for (int i = 1; i <= k; ++i) {
      A[a[i].y] = 1;
    }
    int r = 1;
    for (int j = 1; j <= n; ++j) {
      if (A[j]) {
        if (r == pos) {
          printf("%d\n", b[j]);
          break;
        }
        r++;
      }
    }
    A.clear();
  }
  return 0;
}
