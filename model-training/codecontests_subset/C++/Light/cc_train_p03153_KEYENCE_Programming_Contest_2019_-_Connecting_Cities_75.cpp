#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <cmath>
#include <ctime>
#include <cctype>

#include <algorithm>
#include <functional>
#include <set>
#include <map>
#include <vector>
#include <iostream>
#include <limits>
#include <numeric>

#define LOG(FMT...) fprintf(stderr, FMT)

using namespace std;

typedef long long ll;
typedef unsigned long long ull;

struct Ed {
  int u, v;
  ll w;

  Ed() {}

  Ed(int u, int v, ll w) : u(u), v(v), w(w) {}

  bool operator<(const Ed &rhs) const {
    return w < rhs.w;
  }

  bool operator>(const Ed &rhs) const {
    return rhs < *this;
  }
};

const int N = 200010;
const ll INF = 1LL << 60;

int n, d;
int a[N], f[N];
pair<ll, int> p[N], q[N];
Ed mst[N];
Ed tmp[N * 2];

int find(int x) { return f[x] == x ? x : f[x] = find(f[x]); }

void divideConquer(int l, int r) {
  if (l == r)
    return;
  int mid = (l + r) >> 1;
  divideConquer(l, mid);
  divideConquer(mid + 1, r);
  merge(mst + l, mst + mid, mst + mid + 1, mst + r, tmp + 1);
  pair<ll, int> x = p[l], y = q[mid + 1];
  int a = r - l - 1, b = a;
  for (int i = l; i <= mid; ++i)
    tmp[++b] = Ed(p[i].second, y.second, p[i].first + y.first);
  for (int i = mid + 1; i <= r; ++i)
    tmp[++b] = Ed(x.second, q[i].second, x.first + q[i].first);
  inplace_merge(tmp + a + 1, tmp + a + mid - l + 2, tmp + b + 1);
  inplace_merge(tmp + 1, tmp + a + 1, tmp + b + 1);
  for (int i = l; i <= r; ++i)
    f[i] = i;
  int cnt = l;
  for (int i = 1; i <= b; ++i) {
    int u = find(tmp[i].u), v = find(tmp[i].v);
    if (u != v) {
      mst[cnt++] = tmp[i];
      f[u] = v;
    }
  }
  inplace_merge(p + l, p + mid + 1, p + r + 1);
  inplace_merge(q + l, q + mid + 1, q + r + 1);
}

int main() {

  scanf("%d%d", &n, &d);
  for (int i = 1; i <= n; ++i)
    scanf("%d", &a[i]);
  for (int i = 1; i <= n; ++i)
    p[i] = make_pair(a[i] - i * (ll)d, i);
  for (int j = 1; j <= n; ++j)
    q[j] = make_pair(a[j] + j * (ll)d, j);
  divideConquer(1, n);
  ll ans = 0;
  for (int i = 1; i < n; ++i)
    ans += mst[i].w;
  printf("%lld\n", ans);

  return 0;
}
