#include <bits/stdc++.h>
using namespace std;
const int N = 200004;
long long s[N], p[N];
int n, a[N];
void add(int x, int v) {
  for (int i = x; i <= n; i += (i & -i)) s[i] += v;
}
long long que(int x) {
  long long ans = 0;
  for (int i = x; i; i -= (i & -i)) ans += s[i];
  return ans;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &p[i]);
    add(i, i);
  }
  for (int i = n; i >= 1; i--) {
    int l = 0, r = n;
    while (l < r) {
      int mid = (l + r) / 2;
      if (que(mid) > p[i])
        r = mid;
      else
        l = mid + 1;
    }
    add(l, -l);
    a[i] = l;
  }
  for (int i = 1; i <= n; i++) printf("%d ", a[i]);
}
