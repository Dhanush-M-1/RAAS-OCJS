#include <bits/stdc++.h>
using namespace std;
struct Node {
  double v;
  int id;
} s[100100];
const double eps = 1e-9;
int n, m, w, size[100100], tot;
double v[100100];
int rev(int x) {
  int t = 0;
  while (x) t = t * 10 + x % 10, x /= 10;
  return t;
}
bool cmp(Node x, Node y) { return x.v < y.v || (x.v == y.v && x.id < y.id); }
void prep() {
  for (int i = 1; i <= max(n, m); i++) {
    int x = rev(i);
    v[i] = (double)i / x;
    s[i].v = (double)x / i;
    s[i].id = i;
  }
  sort(s + 1, s + m + 1, cmp);
}
int dcmp(double x) {
  if (fabs(x) < eps) return 0;
  return x > eps ? 1 : -1;
}
int getwhe(int x) {
  int l = 1, r = m;
  while (l < r) {
    int mid = (l + r) >> 1;
    if (dcmp(s[mid].v - v[x]) < 0)
      l = mid + 1;
    else
      r = mid;
  }
  return l;
}
void work() {
  prep();
  int r = m, ans1, ans2;
  long long ans = (long long)1 << 50;
  for (int i = 1; i <= n; i++) {
    int str = getwhe(i);
    for (; str <= m && dcmp(s[str].v - v[i]) == 0 && s[str].id <= r; str++)
      tot++, size[s[str].id]++;
    while (tot - size[r] >= w) tot -= size[r], r--;
    if (tot >= w && (long long)i * r < ans)
      ans = (long long)i * r, ans1 = i, ans2 = r;
  }
  if (ans == (long long)1 << 50)
    cout << "-1";
  else
    cout << ans1 << " " << ans2;
}
int main() {
  cin >> n >> m >> w;
  work();
}
