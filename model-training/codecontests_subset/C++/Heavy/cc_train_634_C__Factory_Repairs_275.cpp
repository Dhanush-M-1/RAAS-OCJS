#include <bits/stdc++.h>
#pragma warning(disable : 4996)
using namespace std;
template <typename T, typename U>
pair<T, U> operator+(const pair<T, U> &l, const pair<T, U> &r) {
  return make_pair(l.first + r.first, l.second + r.second);
}
int n, m, q;
long long A, B;
int S;
pair<long long, long long> it[600000];
long long a[200000];
void update(int x) {
  for (x /= 2; x > 0; x /= 2) it[x] = it[x * 2] + it[x * 2 + 1];
}
pair<long long, long long> getres(int x, int y) {
  pair<long long, long long> res(0, 0);
  while (x <= y) {
    if (x % 2 == 1) res = res + it[x++];
    if (y % 2 == 0) res = res + it[y--];
    x /= 2, y /= 2;
  }
  return res;
}
int main() {
  int i, j, k;
  cin >> n >> m >> A >> B >> q;
  for (S = 1; S < n; S *= 2)
    ;
  for (i = 0; i < q; i++) {
    int x, y, z;
    scanf("%d", &x);
    if (x == 1) {
      scanf("%d%d", &y, &z), y--;
      a[y] += z;
      it[S + y] = pair<long long, long long>(min(a[y], B), min(a[y], A));
      update(S + y);
    } else {
      scanf("%d", &y), y--;
      long long ans = getres(S + 0, S + y - 1).first;
      ans += getres(S + y + m, S + n - 1).second;
      printf("%lld\n", ans);
    }
  }
  return 0;
}
