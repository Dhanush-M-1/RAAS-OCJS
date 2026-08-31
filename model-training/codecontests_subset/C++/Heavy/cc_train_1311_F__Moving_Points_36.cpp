#include <bits/stdc++.h>
using namespace std;
int n;
long long f1[200005], f2[200005], kc;
pair<long long, long long> a[200005];
bool cmp1(pair<long long, long long> x, pair<long long, long long> y) {
  return x.first < y.first;
}
bool cmp2(pair<long long, long long> x, pair<long long, long long> y) {
  return x.second < y.second;
}
void update(int id, long long value, long long f[]) {
  while (id < 200005) {
    f[id] = f[id] + value;
    id = id + (id & -id);
  };
}
long long rsumq(int x, long long f[]) {
  long long sum = 0;
  while (x != 0) {
    sum += f[x];
    x -= (x & -x);
  };
  return sum;
}
long long rsumq(int x, int y, long long f[]) {
  return rsumq(y, f) - (x == 1 ? 0 : rsumq(x - 1, f));
}
void nhap() {
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i].first;
  for (int i = 1; i <= n; i++) cin >> a[i].second;
  sort(a + 1, a + 1 + n, cmp2);
  int cnt = 1;
  for (int i = 1; i < n; i++) {
    int tmp = a[i].second;
    a[i].second = cnt;
    if (tmp != a[i + 1].second) cnt++;
  }
  a[n].second = cnt;
}
void xuly() {
  sort(a + 1, a + 1 + n, cmp1);
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    ans += (rsumq(1, a[i].second, f1) * a[i].first - rsumq(1, a[i].second, f2));
    update(a[i].second, 1, f1);
    update(a[i].second, a[i].first, f2);
  }
  cout << ans;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  nhap();
  xuly();
  return 0;
}
