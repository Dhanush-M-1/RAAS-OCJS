#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:100000000000,100000000000")
using namespace std;
const long long inf = 1e18 + 7;
const long long mod = 1e9 + 7;
const double eps = 1e-12;
const double PI = 2 * acos(0.0);
const double E = 2.71828;
int n, m;
bool def[5005];
long long ans[5005], add[5005];
long long q[5005];
long long type[5005];
long long L[5005];
long long R[5005];
long long Val[5005];
void check() {
  for (long long(i) = 0; (i) < (long long)(n); (i)++) {
    if (ans[i] < -1000000000 || ans[i] > 1000000000) {
      puts("NO");
      exit(0);
    }
    q[i] = ans[i];
  }
  for (long long(i) = 0; (i) < (long long)(m); (i)++) {
    long long t = type[i], l = L[i], r = R[i], val = Val[i];
    if (t == 1) {
      for (int i = l; i <= r; ++i) {
        q[i] += val;
      }
      continue;
    }
    long long Max = q[l];
    for (int i = l + 1; i <= r; ++i) {
      Max = max(Max, q[i]);
    }
    if (Max != val) {
      puts("NO");
      exit(0);
    }
  }
}
int main(void) {
  scanf("%d%d", &n, &m);
  for (long long(i) = 0; (i) < (long long)(m); (i)++) {
    long long t, l, r, val;
    cin >> t >> l >> r >> val;
    --l;
    --r;
    type[i] = t;
    L[i] = l;
    R[i] = r;
    Val[i] = val;
    if (t == 1) {
      for (int i = l; i <= r; ++i) {
        add[i] += val;
      }
    } else {
      for (int i = l; i <= r; ++i) {
        if (!def[i]) {
          def[i] = true;
          ans[i] = val - add[i];
        } else {
          if (val < ans[i] + add[i]) {
            ans[i] = val - add[i];
          }
        }
      }
    }
  }
  check();
  puts("YES");
  for (long long(i) = 0; (i) < (long long)(n); (i)++) {
    printf("%d ", (int)ans[i]);
  }
  printf("\n");
  return 0;
}
