#include <bits/stdc++.h>
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
const int maxn = 100100;
using namespace std;
int ans[110][110];
struct node {
  int nub, pos;
} a[110];
bool cmp(node c, node b) {
  if (c.nub == b.nub) return c.pos < b.pos;
  return c.nub > b.nub;
}
bool cmp2(node c, node b) { return c.pos < b.pos; }
int main() {
  int n, m;
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> a[i].nub;
    a[i].pos = i;
  }
  sort(a + 1, a + 1 + n, cmp);
  ans[1][1] = a[1].nub;
  for (int i = 2; i <= n; ++i) {
    sort(a + 1, a + 1 + i, cmp2);
    for (int j = 1; j <= i; ++j) {
      ans[i][j] = a[j].nub;
    }
  }
  cin >> m;
  for (int i = 1; i <= m; ++i) {
    int x, pos;
    cin >> x >> pos;
    cout << ans[x][pos] << endl;
  }
}
