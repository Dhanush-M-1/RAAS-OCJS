#include <bits/stdc++.h>
inline int getInt() {
  int s;
  scanf("%d", &s);
  return s;
}
using namespace std;
long long high[5000];
long long diff[5000];
int tm[5000];
int lm[5000];
int rm[5000];
int mm[5000];
int main() {
  const int n = getInt();
  const int m = getInt();
  for (int i = 0; i < (int)(n); i++) high[i] = 1000000000ll;
  for (int i = 0; i < (int)(m); i++) {
    const int t = tm[i] = getInt();
    const int l = lm[i] = getInt() - 1;
    const int r = rm[i] = getInt() - 1;
    const int m = mm[i] = getInt();
    if (t == 1) {
      for (int j = l; j <= r; j++) {
        diff[j] += m;
      }
    } else {
      for (int j = l; j <= r; j++) {
        high[j] = min(high[j], m - diff[j]);
      }
    }
  }
  bool ans = true;
  for (int i = 0; i < (int)(n); i++) diff[i] = 0;
  for (int i = 0; i < (int)(m); i++) {
    const int t = tm[i];
    const int l = lm[i];
    const int r = rm[i];
    const int m = mm[i];
    if (t == 1) {
      for (int j = l; j <= r; j++) {
        diff[j] += m;
      }
    } else {
      long long h = -1000000000000ll;
      for (int j = l; j <= r; j++) {
        h = max(h, high[j] + diff[j]);
      }
      if (h != m) {
        ans = false;
      }
    }
  }
  if (ans) {
    puts("YES");
    printf("%lld", high[0]);
    for (int i = 0; i < (int)(n - 1); i++) printf(" %lld", high[i + 1]);
    puts("");
  } else {
    puts("NO");
  }
  return 0;
}
