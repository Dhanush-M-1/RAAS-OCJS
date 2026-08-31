#include <bits/stdc++.h>
using namespace std;
vector<int> pos;
int a[1000005];
void up(long long &a, long long b) {
  if (a == -1 || b < a) a = b;
}
int solve(int x, int n) {
  int stp = 0, re = 0;
  while (1) {
    if (stp + x >= n) {
      re++;
      break;
    }
    auto it = upper_bound(pos.begin(), pos.end(), stp + x);
    if (it == pos.begin()) return -1;
    it--;
    if (*it <= stp) return -1;
    re++;
    stp = *it;
  }
  return re;
}
int main() {
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  int stp = 0;
  for (int i = 0; i < m; i++) {
    int x;
    scanf("%d", &x);
    while (stp < x) pos.push_back(stp++);
    stp++;
  }
  while (stp < n) pos.push_back(stp++);
  for (int i = 1; i <= k; i++) {
    scanf("%d", &a[i]);
  }
  if (pos.empty() || pos[0] != 0) {
    printf("-1\n");
    return 0;
  }
  long long ans = -1;
  for (int i = 1; i <= k; i++) {
    int x = solve(i, n);
    if (x != -1) up(ans, 1ll * x * a[i]);
  }
  printf("%lld\n", ans);
  return 0;
}
