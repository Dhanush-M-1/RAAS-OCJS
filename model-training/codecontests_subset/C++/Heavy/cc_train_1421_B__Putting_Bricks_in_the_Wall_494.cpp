#include <bits/stdc++.h>
using namespace std;
template <class T>
T sqr(T a) {
  return a * a;
}
template <class T>
T abs(T x) {
  if (x < 0) return -x;
  return x;
}
const double eps = 1e-8;
const double pi = acos(-1.0);
struct node {
  int x, y, val;
};
char str[210][210];
vector<node> vec;
int main() {
  int tks, ks = 1;
  scanf("%d", &tks);
  while (tks--) {
    vec.clear();
    node a, b, c, d;
    int i, n;
    scanf("%d", &n);
    for (i = 0; i < n; i++) scanf("%s", str[i]);
    a.x = 0;
    a.y = 1;
    a.val = str[a.x][a.y] - '0';
    b.x = 1;
    b.y = 0;
    b.val = str[b.x][b.y] - '0';
    c.x = n - 1;
    c.y = n - 2;
    c.val = str[c.x][c.y] - '0';
    d.x = n - 2;
    d.y = n - 1;
    d.val = str[d.x][d.y] - '0';
    if (a.val == b.val) {
      if (a.val == c.val) vec.push_back(c);
      if (a.val == d.val) vec.push_back(d);
    } else if (c.val == d.val) {
      if (a.val == c.val) vec.push_back(a);
      if (b.val == c.val) vec.push_back(b);
    } else {
      if (a.val == 1)
        vec.push_back(b);
      else
        vec.push_back(a);
      if (c.val == 0)
        vec.push_back(d);
      else
        vec.push_back(c);
    }
    printf("%d\n", vec.size());
    for (i = 0; i < vec.size(); i++)
      printf("%d %d\n", vec[i].x + 1, vec[i].y + 1);
  }
  return 0;
}
