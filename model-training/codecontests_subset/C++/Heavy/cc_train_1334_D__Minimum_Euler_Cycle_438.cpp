#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using pll = pair<ll, ll>;
const int LM = 3e5 + 4;
ll N;
ll L, R;
ll part[LM];
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    scanf("%lld%lld%lld", &N, &L, &R);
    bool e = 0;
    if (R == N * (N - 1) + 1) {
      e = 1;
      R--;
    }
    for (int i = 1; i <= N - 1; i++) part[i] = part[i - 1] + (N - i) * 2;
    for (int i = 1; i <= N; i++) {
      if (L <= part[i] && R > part[i - 1]) {
        int v, last = i;
        for (int j = 1; j <= (N - i) * 2; j++) {
          if (j & 1)
            v = i;
          else
            v = ++last;
          if (L <= part[i - 1] + j && part[i - 1] + j <= R) printf("%d ", v);
        }
      }
    }
    if (e) printf("1 ");
    puts("");
  }
  return 0;
}
