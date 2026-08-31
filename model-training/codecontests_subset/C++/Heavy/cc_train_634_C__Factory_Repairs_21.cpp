#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:167177216")
using namespace std;
const int MAX = 2147483647;
const int MAXN = 201000;
const long long MOD = 1000000000 + 7;
long long FWB[MAXN], FWA[MAXN];
void update(long long *fw, int index, int count) {
  for (int i = index; i < MAXN; i += (i + 1) & -(i + 1)) {
    fw[i] += count;
  }
}
long long get(long long *fw, int l, int r) {
  long long result = 0;
  for (int i = r; i >= 0; i -= (i + 1) & -(i + 1)) {
    result += fw[i];
  }
  for (int i = l - 1; i >= 0; i -= (i + 1) & -(i + 1)) {
    result -= fw[i];
  }
  return result;
}
long long get_pos(long long *fw, int pos) { return get(fw, pos, pos); }
int main() {
  memset(FWB, 0, sizeof(FWB));
  memset(FWA, 0, sizeof(FWA));
  int n, k, a, b, q;
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  for (int i = 0; i < q; ++i) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int count, d;
      scanf("%d%d", &d, &count);
      d--;
      long long val = get_pos(FWB, d);
      long long newval = val;
      newval += count;
      newval = min(newval, (long long)b);
      update(FWB, d, newval - val);
      val = get_pos(FWA, d);
      newval = val;
      newval += count;
      newval = min(newval, (long long)a);
      update(FWA, d, newval - val);
    } else {
      int pos;
      scanf("%d", &pos);
      pos--;
      long long leftsum = get(FWB, 0, pos - 1);
      long long rightsum = get(FWA, pos + k, n - 1);
      printf("%I64d\n", leftsum + rightsum);
    }
  }
  return 0;
}
