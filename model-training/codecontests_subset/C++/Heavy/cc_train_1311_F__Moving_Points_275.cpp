#include <bits/stdc++.h>
using namespace std;
const long long maxn = 200000 + 50;
const long long LIM = 17;
const long long INF = (long long)1e9 + 7;
long long N;
long long h[maxn];
long long sum[maxn << 1], cnt[maxn << 1];
struct node {
  long long x, v;
} a[maxn];
bool cmp(const node& a, const node& b) { return a.x < b.x; }
inline long long lowerbit(long long x) { return x & -x; }
void updata(long long x, long long val, long long tree[]) {
  while (x <= N) {
    tree[x] += val;
    x += lowerbit(x);
  }
}
long long query(long long x, long long tree[]) {
  long long sum = 0;
  while (x > 0) {
    sum += tree[x];
    x -= lowerbit(x);
  }
  return sum;
}
int main() {
  scanf("%lld", &N);
  for (long long i = 1; i <= N; i++) {
    scanf("%lld", &a[i].x);
  }
  for (long long i = 1; i <= N; i++) {
    scanf("%lld", &a[i].v);
  }
  sort(a + 1, a + 1 + N, cmp);
  long long l = -1e8;
  for (long long i = 1; i <= N; i++) {
    h[i] = a[i].v;
  }
  sort(h + 1, h + 1 + N);
  long long d = unique(h + 1, h + 1 + N) - h - 1;
  long long ans = 0;
  for (long long i = 1; i <= N; i++) {
    long long x = lower_bound(h + 1, h + 1 + d, a[i].v) - h;
    ans += (query(x, cnt) * (a[i].x - l) - query(x, sum));
    updata(x, 1, cnt);
    updata(x, a[i].x - l, sum);
  }
  cout << ans << endl;
}
