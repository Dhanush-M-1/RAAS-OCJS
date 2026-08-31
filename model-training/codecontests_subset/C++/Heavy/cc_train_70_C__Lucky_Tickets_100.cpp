#include <bits/stdc++.h>
using namespace std;
const int maxint = 0x7fffffff;
map<pair<int, int>, vector<int> > have;
vector<int>::iterator it;
int maxx, maxy, w;
int tree[100000 * 8];
int reverse(int x) {
  int y = 0;
  while (x > 0) {
    y = y * 10 + x % 10;
    x /= 10;
  }
  return y;
}
int gcd(int x, int y) {
  if (x < y) swap(x, y);
  if (x % y == 0)
    return y;
  else
    return gcd(y, x % y);
}
void insert(int root, int l, int r, int x) {
  tree[root]++;
  if (l == r) return;
  int mid = (l + r) / 2;
  if (x <= mid)
    insert(root * 2, l, mid, x);
  else
    insert(root * 2 + 1, mid + 1, r, x);
}
int find(int root, int l, int r, int cnt) {
  if (cnt > tree[root]) return 0;
  if (l == r) return l;
  int mid = (l + r) / 2;
  if (cnt <= tree[root * 2])
    return find(root * 2, l, mid, cnt);
  else
    return find(root * 2 + 1, mid + 1, r, cnt - tree[root * 2]);
}
int main() {
  int i, y2, y3, g, x2, x3, ans, y, ax, ay;
  scanf("%d%d%d", &maxx, &maxy, &w);
  for (i = 1; i <= maxy; i++) {
    y2 = i;
    y3 = reverse(i);
    g = gcd(y2, y3);
    y2 /= g;
    y3 /= g;
    have[make_pair(y3, y2)].push_back(i);
  }
  ans = maxint;
  for (i = 1; i <= maxx; i++) {
    x2 = i;
    x3 = reverse(i);
    g = gcd(x2, x3);
    x2 /= g;
    x3 /= g;
    for (it = have[make_pair(x2, x3)].begin();
         it != have[make_pair(x2, x3)].end(); it++)
      insert(1, 1, maxy, *it);
    y = find(1, 1, maxy, w);
    if (y != 0)
      if (i * y < ans) {
        ans = i * y;
        ax = i;
        ay = y;
      }
  }
  if (ans == maxint)
    printf("-1\n");
  else
    printf("%d %d\n", ax, ay);
  return 0;
}
