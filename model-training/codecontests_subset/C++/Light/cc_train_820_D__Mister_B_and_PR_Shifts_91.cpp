#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000005;
int n;
int ar[maxn];
int cnt[maxn << 2];
int main() {
  scanf("%d", &n);
  long long d = 0;
  int s = 0;
  int f = 0, z = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%d", ar + i);
    int tmp = ar[i] - i;
    if (tmp > 0) {
      z++;
      cnt[tmp]++;
    } else
      f++;
    d += abs(tmp);
  }
  int o = 1;
  long long td = d;
  for (int i = n, j = 1; i > 1; i--, j++, o++) {
    if (ar[i] > i) cnt[ar[i] - i]--;
    if (ar[i] > n)
      z--;
    else
      f--;
    td += f - z;
    td += abs(ar[i] - 1) - abs(ar[i] - n);
    f += cnt[o];
    z -= cnt[o];
    if (ar[i] != 1) {
      cnt[o + ar[i] - 1]++;
      z++;
    } else
      f++;
    if (td < d) {
      d = td;
      s = j;
    }
  }
  printf("%I64d %d\n", d, s);
  return 0;
}
