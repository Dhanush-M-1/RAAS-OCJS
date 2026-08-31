#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
long long c1[maxn], c2[maxn];
void add(long long *c, int x, int y) {
  for (; x < maxn; x += x & -x) c[x] += y;
}
long long ask(long long *c, int x) {
  long long ret = 0;
  for (; x > 0; x -= x & -x) ret += c[x];
  return ret;
}
struct node {
  int x, v;
} p[maxn];
int b[maxn];
bool cmp(node a, node b) {
  if (a.x == b.x) return a.v < b.v;
  return a.x < b.x;
}
int main() {
  int n;
  cin >> n;
  int m = 0;
  for (int i = 0; i < n; i++) scanf("%d", &p[i].x);
  for (int i = 0; i < n; i++) {
    scanf("%d", &p[i].v);
    b[m++] = p[i].v;
  }
  sort(b, b + m);
  m = unique(b, b + m) - b;
  for (int i = 0; i < n; i++) {
    p[i].v = lower_bound(b, b + m, p[i].v) - b + 1;
  }
  sort(p, p + n, cmp);
  long long Ans = 0;
  for (int i = 0; i < n; i++) {
    long long cnt = ask(c1, p[i].v), sum = ask(c2, p[i].v);
    Ans += cnt * p[i].x - sum;
    add(c1, p[i].v, 1);
    add(c2, p[i].v, p[i].x);
  }
  cout << Ans << endl;
}
