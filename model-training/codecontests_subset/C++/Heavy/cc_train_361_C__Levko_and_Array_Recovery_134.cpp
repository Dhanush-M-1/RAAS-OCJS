#include <bits/stdc++.h>
using namespace std;
long long i, j, k, N, M, K;
long long t[100000], a[100000], b[100000], c[100000], ans[100000], ansc[100000];
int check() {
  for (i = 1; i <= M; i++) {
    if (t[i] == 2) {
      long long m = -1 * 1000000000;
      for (j = a[i]; j <= b[i]; j++) {
        m = max(m, ans[j]);
      }
      if (m != c[i]) return false;
    } else {
      for (j = a[i]; j <= b[i]; j++) {
        ans[j] += c[i];
      }
    }
  }
  return true;
}
int main() {
  scanf("%I64d%I64d", &N, &M);
  for (i = 1; i <= M; i++) {
    scanf("%I64d%I64d%I64d%I64d", &t[i], &a[i], &b[i], &c[i]);
  }
  for (i = 1; i <= 5005; i++) ans[i] = 1000000000;
  for (i = M; i >= 1; i--) {
    if (t[i] == 2)
      for (j = a[i]; j <= b[i]; j++) {
        if (ans[j] > c[i]) ans[j] = c[i];
      }
    else {
      for (j = a[i]; j <= b[i]; j++) {
        ans[j] -= c[i];
      }
    }
  }
  for (i = 1; i <= N; i++) ans[i] = min(1000000000LL, ans[i]);
  for (i = 1; i <= N; i++) ansc[i] = ans[i];
  if (check()) {
    printf("YES\n");
    for (i = 1; i <= N; i++) {
      printf("%I64d%c", ansc[i], i == N ? '\n' : ' ');
    }
  } else {
    printf("NO\n");
  }
}
