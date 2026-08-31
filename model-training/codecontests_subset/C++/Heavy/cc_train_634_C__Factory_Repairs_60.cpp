#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
long long f1[N], f2[N];
long long sz[N];
void add1(int x, int val) {
  for (; x < N; x += x & -x) {
    f1[x] += val;
  }
}
long long get1(int x) {
  long long sol = 0;
  for (; x > 0; x -= x & -x) {
    sol += f1[x];
  }
  return sol;
}
void add2(int x, int val) {
  for (; x < N; x += x & -x) {
    f2[x] += val;
  }
}
long long get2(int x) {
  long long sol = 0;
  for (; x > 0; x -= x & -x) {
    sol += f2[x];
  }
  return sol;
}
int main() {
  int b, p, va, vb, q;
  cin >> b >> p >> va >> vb >> q;
  int u, d, n;
  for (int i = 0; i < q; i++) {
    cin >> u;
    if (u == 1) {
      cin >> d >> n;
      if (sz[d] < vb) {
        if (sz[d] + n > vb) {
          add1(d, vb - sz[d]);
        } else {
          add1(d, n);
        }
      }
      if (sz[d] < va) {
        if (sz[d] + n > va) {
          add2(d, va - sz[d]);
        } else {
          add2(d, n);
        }
      }
      sz[d] += n;
    } else {
      cin >> d;
      cout << get1(d - 1) + get2(b) - get2(d + p - 1) << endl;
    }
  }
}
