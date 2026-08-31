#include <bits/stdc++.h>
using namespace std;
long long n;
long long s[200010];
long long a[200010];
long long cnt[200010];
long long p[200010];
long long lb(long long x) { return x & (-x); }
void ins(int x, int y) {
  for (long long i = x; i <= n; i += lb(i)) {
    p[i] += y;
  }
  return;
}
long long gs(int x) {
  long long sum = 0;
  for (long long i = x; i > 0; i -= lb(i)) {
    sum += p[i];
  }
  return sum;
}
int re(long long x) {
  int l = 1, r = n;
  while (l < r) {
    int mid = (l + r + 1) / 2;
    long long tmp = gs(mid - 1);
    if (tmp > x)
      r = mid - 1;
    else
      l = mid;
  }
  return r;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  int i, j;
  for (i = 1; i <= n; i++) {
    cin >> s[i];
    ins(i, i);
  }
  for (i = n; i > 0; i--) {
    a[i] = re(s[i]);
    ins(a[i], -a[i]);
  }
  for (i = 1; i <= n; i++) cout << a[i] << " ";
  return 0;
}
