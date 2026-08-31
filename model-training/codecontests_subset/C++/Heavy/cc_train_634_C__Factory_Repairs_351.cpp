#include <bits/stdc++.h>
using namespace std;
struct BIT {
  long long tree[200010];
  BIT(void) {
    for (int i = 0; i < 200010; i++) tree[i] = 0;
  }
  void update(int idx, long long val) {
    while (idx < 200010) {
      tree[idx] += val;
      idx += (idx & (-idx));
    }
  }
  long long query(int idx) {
    long long ret = 0;
    while (idx > 0) {
      ret += tree[idx];
      idx -= (idx & (-idx));
    }
    return ret;
  }
  long long query(int a, int b) {
    if (a > b) return 0;
    long long ret = query(b) - query(a - 1);
    return ret;
  }
};
BIT AA, BB, CC, DD;
int N, K, A, B, Q;
long long val[200010];
inline void ReadInput(void) {
  scanf("%d", &N);
  scanf("%d", &K);
  scanf("%d", &A);
  scanf("%d", &B);
  scanf("%d", &Q);
}
inline void solve(void) {
  while (Q--) {
    int type;
    scanf("%d", &type);
    if (type == 1) {
      int d;
      long long a;
      scanf("%d", &d);
      scanf("%lld", &a);
      if (val[d] > A) {
        AA.update(d, -1);
      } else {
        CC.update(d, -val[d]);
      }
      if (val[d] > B) {
        BB.update(d, -1);
      } else {
        DD.update(d, -val[d]);
      }
      a += val[d];
      val[d] = a;
      if (a > A) {
        AA.update(d, 1);
      } else {
        CC.update(d, a);
      }
      if (a > B) {
        BB.update(d, 1);
      } else {
        DD.update(d, a);
      }
    } else {
      int p;
      scanf("%d", &p);
      long long ans = 0, foo = 0, bar = 0;
      foo = AA.query(p + K, 200010 - 1);
      bar = BB.query(1, p - 1);
      foo *= A;
      bar *= B;
      foo += CC.query(p + K, 200010 - 1);
      bar += DD.query(1, p - 1);
      ans = foo + bar;
      printf("%lld\n", ans);
    }
  }
}
inline void Refresh(void) {}
int main() {
  ReadInput();
  solve();
  return 0;
}
