#include <bits/stdc++.h>
using namespace std;
const long long mod = 998244353;
const int N = 2e5 + 2;
const int inf = 2e9;
const long long linf = 4e18;
long long val[N], cnt[N];
void upd(int x, long long v) {
  int z = 0;
  if (v < 0)
    z--;
  else
    z++;
  for (; x < N; x += x & (-x)) {
    cnt[x] += z;
    val[x] += v;
  }
}
array<long long, 2> get(int x) {
  array<long long, 2> data;
  data = {0, 0};
  for (; x > 0; x -= x & (-x)) {
    data[0] += cnt[x];
    data[1] += val[x];
  }
  return data;
}
array<long long, 2> get2(int x) {
  array<long long, 2> a = get(N - 1);
  array<long long, 2> b = get(x - 1);
  return {a[0] - b[0], a[1] - b[1]};
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cerr.tie(0);
  int n;
  cin >> n;
  vector<array<long long, 2>> data(n), v(n);
  for (int i = 0; i < n; i++) cin >> data[i][0];
  for (int i = 0; i < n; i++) {
    cin >> data[i][1];
    v[i] = {data[i][1], i};
  }
  sort(v.begin(), v.end());
  int h = 0;
  data[v[0][1]][1] = ++h;
  for (int i = 1; i < n; i++) {
    data[v[i][1]][1] = h;
    if (v[i][0] != v[i - 1][0]) data[v[i][1]][1] = ++h;
  }
  sort(data.begin(), data.end());
  for (int i = 0; i < n; i++) {
    upd(data[i][1], data[i][0]);
  }
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    upd(data[i][1], -data[i][0]);
    array<long long, 2> d = get2(data[i][1]);
    ans += d[1] - (d[0] * data[i][0]);
  }
  cout << ans;
  return 0;
}
