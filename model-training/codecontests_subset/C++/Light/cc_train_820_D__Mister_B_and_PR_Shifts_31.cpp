#include <bits/stdc++.h>
using namespace std;
long long pos = 0;
long long neg = 0;
long long ans1 = 1e18;
long long ans2 = 0;
int a[1000005];
int cnt[2000005];
int tot1 = 0;
int tot2 = 0;
int n;
void update(int i, int p) {
  if (a[i] - i >= 0) {
    if (a[i] - n >= 0) {
      cnt[a[i] - i]--;
      pos -= a[i] - n;
      tot1--;
    } else {
      neg -= n - a[i];
      tot2--;
    }
  } else {
    neg -= n - a[i];
    tot2--;
  }
  tot1 -= cnt[p];
  pos -= tot1;
  neg += cnt[p];
  neg += tot2;
  tot2 += cnt[p];
  cnt[a[i] - 1 + p + 1]++;
  pos += a[i] - 1;
  tot1++;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    if (a[i] - i >= 0) {
      cnt[a[i] - i]++;
      pos += a[i] - i;
      tot1++;
    } else {
      neg += i - a[i];
      tot2++;
    }
  }
  int p = 0;
  if (ans1 > neg + pos) {
    ans1 = neg + pos;
    ans2 = p;
  }
  update(n, p);
  p++;
  for (int i = n - 1; i >= 1; i--, p++) {
    if (ans1 > neg + pos) {
      ans1 = neg + pos;
      ans2 = p;
    }
    update(i, p);
  }
  printf("%lld %lld\n", ans1, ans2);
}
