#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1 << 18;
long long A, B;
pair<long long, long long> operator+(pair<long long, long long> p1, int x) {
  return pair<long long, long long>(min(A, p1.first + x),
                                    min(B, p1.second + x));
}
pair<long long, long long> operator+(pair<long long, long long> p1,
                                     pair<long long, long long> p2) {
  return pair<long long, long long>(p1.first + p2.first, p1.second + p2.second);
}
pair<long long, long long> tree[2 * MAXN];
long long lazy[2 * MAXN];
void update(int x, long long v) {
  x += MAXN;
  tree[x] = tree[x] + v;
  while (x /= 2) {
    tree[x] = tree[2 * x] + tree[2 * x + 1];
  }
}
pair<long long, long long> query(int a, int b, int cur = 1, int lt = 0,
                                 int rt = MAXN) {
  if (rt <= a || b <= lt) {
    return pair<long long, long long>(0, 0);
  }
  if (a <= lt && rt <= b) {
    return tree[cur];
  }
  int mid = (lt + rt) / 2;
  return query(a, b, 2 * cur, lt, mid) + query(a, b, 2 * cur + 1, mid, rt);
}
int N, K, Q;
int main() {
  if (fopen("input.txt", "r")) {
    freopen("input.txt", "r", stdin);
  }
  scanf("%d %d %lld %lld %d", &N, &K, &A, &B, &Q);
  int qt, d, p;
  long long a;
  for (int qi = 0; qi < Q; qi++) {
    scanf("%d", &qt);
    if (qt == 1) {
      scanf("%d %lld", &d, &a);
      d--;
      update(d, a);
    } else {
      scanf("%d", &p);
      p--;
      long long bef = query(0, p).second;
      long long aft = query(p + K, N).first;
      printf("%lld\n", bef + aft);
    }
  }
}
