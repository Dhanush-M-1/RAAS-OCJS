#include <bits/stdc++.h>
using namespace std;
long long BIT[200009][4], N = 200009, n, ans, I;
struct st {
  long long x, v;
} a[200009];
bool cmp(st a, st b) {
  if (a.v == b.v) return a.x > b.x;
  return a.v > b.v;
}
bool cmp2(st a, st b) {
  if (a.v == b.v) return a.x > b.x;
  return a.v > b.v;
}
set<long long> s;
map<long long, long long> mp;
void update(long long x, long long val, long long zz) {
  for (; x < N; x += x & -x) BIT[x][zz] += val;
}
long long query(long long x, long long zz) {
  long long sum = 0;
  for (; x > 0; x -= x & -x) sum += BIT[x][zz];
  return sum;
}
long long q(long long l, long long r, long long zz) {
  return query(r, zz) - query(l - 1, zz);
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i].x;
    s.insert(a[i].x);
  }
  for (int i = 0; i < n; i++) {
    cin >> a[i].v;
  }
  for (auto x : s) mp[x] = ++I;
  sort(a, a + n, cmp);
  for (int i = 0; i < n; i++) {
    ans += q(mp[a[i].x] + 1, I, 1) - a[i].x * q(mp[a[i].x] + 1, I, 2);
    update(mp[a[i].x], a[i].x, 1);
    update(mp[a[i].x], 1, 2);
  }
  cout << ans << endl;
}
