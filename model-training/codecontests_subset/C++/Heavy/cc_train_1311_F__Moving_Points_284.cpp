#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 1000;
const long long M = 1e5 + 10;
const long long inf = 1e9 + 7;
const long long Mod = 1e9 + 7;
const double eps = 1e-6;
int T;
pair<int, int> a[N];
int b[N];
int n;
pair<long long, long long> bt[N];
pair<long long, long long> query(int first) {
  pair<long long, long long> res{0, 0};
  while (first) {
    res.first += bt[first].first;
    res.second += bt[first].second;
    first -= ((first) & (-first));
  }
  return res;
}
void modify(int first, int val) {
  while (first <= n) {
    bt[first].first += val;
    bt[first].second++;
    first += ((first) & (-first));
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i].first);
  }
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i].second);
    b[i] = a[i].second;
  }
  sort(a + 1, a + n + 1);
  sort(b + 1, b + n + 1);
  int len = unique(b + 1, b + n + 1) - b - 1;
  long long ans = 0;
  for (int i = 1; i <= n; ++i) {
    int id = lower_bound(b + 1, b + len + 1, a[i].second) - b;
    pair<long long, long long> cur = query(id);
    ans -= cur.first - cur.second * a[i].first;
    modify(id, a[i].first);
  }
  printf("%lld", ans);
  return 0;
}
