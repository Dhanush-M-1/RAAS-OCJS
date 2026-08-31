#include <bits/stdc++.h>
using namespace std;
struct Tree {
  long long x, height;
  bool operator<(const Tree& b) const { return x < b.x; }
} q[105005];
const long long INF = 0x3f3f3f3f3f3f3f3f;
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%lld%lld", &q[i].x, &q[i].height);
  }
  sort(q + 1, q + 1 + n);
  q[0].x = -INF;
  q[n + 1].x = INF;
  int res = 0;
  for (int i = 1; i <= n; i++) {
    if (q[i].x - q[i].height > q[i - 1].x) {
      res++;
      continue;
    }
    if (q[i].x + q[i].height < q[i + 1].x) {
      q[i].x += q[i].height;
      res++;
    }
  }
  cout << res << endl;
}
