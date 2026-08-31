#include <bits/stdc++.h>
using namespace std;
const int INF = (int)1E9;
void add(int *s, int k, int v) {
  k++;
  for (; k < 200005; k += -k & k) s[k] += v;
}
int get(int *s, int k) {
  if (k < 0) return 0;
  k++;
  int ans = 0;
  for (; k; k -= -k & k) ans += s[k];
  return ans;
}
int N, K, A, B, a[200005], sa[200005], sb[200005];
int xa[200005], xb[200005];
int main() {
  int Q;
  cin >> N >> K >> A >> B >> Q;
  while (Q--) {
    int t, d;
    scanf("%d%d", &t, &d);
    if (t == 1) {
      int inc;
      scanf("%d", &inc);
      add(sa, (N - (d) + 1), -xa[d]);
      add(sb, d, -xb[d]);
      a[d] += inc;
      xa[d] = min(a[d], A);
      xb[d] = min(a[d], B);
      add(sa, (N - (d) + 1), xa[d]);
      add(sb, d, xb[d]);
    } else {
      int ans = get(sb, d - 1);
      if (d + K <= N) {
        ans += get(sa, (N - (d + K) + 1));
      }
      printf("%d\n", ans);
    }
  }
  return 0;
}
