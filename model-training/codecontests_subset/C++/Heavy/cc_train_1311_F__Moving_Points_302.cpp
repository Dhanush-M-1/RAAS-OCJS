#include <bits/stdc++.h>
using namespace std;
const int M = 2e5 + 5;
int n, t[M], k;
long long ans;
struct node {
  long long p;
  int v;
} a[M];
struct BIT {
  long long s[M];
  void add(int i, long long x) {
    for (; i <= k; i += i & -i) s[i] += x;
  }
  long long ask(int i) {
    long long res = 0;
    for (; i > 0; i -= i & -i) res += s[i];
    return res;
  }
} f1, f2;
inline int find(int x) {
  int l = 1, r = k, mid;
  while (l < r) {
    mid = (l + r) >> 1;
    if (t[mid] < x)
      l = mid + 1;
    else
      r = mid;
  }
  return l;
}
int cmp(node x, node y) { return x.p < y.p; }
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) scanf("%lld", &a[i].p);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i].v);
    t[i] = a[i].v;
  }
  sort(a + 1, a + n + 1, cmp);
  sort(t + 1, t + n + 1);
  k++;
  for (int i = 2; i <= n; i++)
    if (t[i] != t[i - 1]) t[++k] = t[i];
  for (int i = 1; i <= n; i++) {
    int w = find(a[i].v);
    ans += a[i].p * f1.ask(w) - f2.ask(w);
    f1.add(w, 1);
    f2.add(w, a[i].p);
  }
  cout << ans << endl;
  return 0;
}
