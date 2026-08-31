#include <bits/stdc++.h>
using namespace std;
const long long oo = 0x3f3f3f3f3f3f3f3fll;
const int LGN = 25;
const int MOD = 1e9 + 7;
const int N = 1e6 + 5;
int n;
long long delta[N];
void add(int l, int r, int v) {
  if (r < l || n <= l) return;
  delta[l] += v;
  delta[r + 1] -= v;
}
int main() {
  std::ios::sync_with_stdio(false);
  scanf("%d", &(n));
  static int p[N];
  long long d = 0;
  for (long long i = 1, __R = n; i <= __R; i++) {
    scanf("%d", &(p[i]));
    d += abs(i - p[i]);
    if (p[i] > i) {
      add(1, p[i] - i, -1);
      add(p[i] - i + 1, n - i, +1);
      add(n - i + 1, n - i + 1, -(n - p[i]) + (p[i] - 1));
      add(n - i + 2, n - 1, -1);
    } else if (p[i] == i) {
      add(1, n - i, +1);
      add(n - i + 1, n - i + 1, -(n - p[i]) + (p[i] - 1));
      add(n - i + 2, n - 1, -1);
    } else {
      add(1, n - i, +1);
      add(n - i + 1, n - i + 1, -(n - p[i]) + (p[i] - 1));
      add(n - i + 2, n - i + p[i], -1);
      add(n - i + p[i] + 1, n - 1, +1);
    }
  }
  long long mind = d;
  int mink = 0;
  for (long long k = 1, __R = n - 1; k <= __R; k++) {
    delta[k] += delta[k - 1];
  }
  for (long long k = 1, __R = n - 1; k <= __R; k++) {
    d += delta[k];
    if (d < mind) {
      mind = d;
      mink = k;
    }
  }
  printf("%lld %d\n", mind, mink);
  return 0;
}
