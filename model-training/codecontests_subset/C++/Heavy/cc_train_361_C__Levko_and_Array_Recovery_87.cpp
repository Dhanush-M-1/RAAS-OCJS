#include <bits/stdc++.h>
using namespace std;
int t[5001];
int a[5001];
int b[5001];
int val[5001];
int upper[5001];
int sums[5001];
int main(int argc, char *argv[]) {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < m; ++i) {
    scanf("%d%d%d%d", &t[i], &a[i], &b[i], &val[i]);
  }
  while ((m > 1) && (t[m - 1] == 1)) {
    --m;
  }
  for (int i = 0; i <= n; ++i) {
    upper[i] = 2000000000;
  }
  for (int i = m - 1; i >= 0; --i) {
    if (t[i] == 2) {
      for (int j = a[i]; j <= b[i]; ++j) {
        upper[j] = ((upper[j]) < (val[i]) ? (upper[j]) : (val[i]));
      }
    } else {
      for (int j = a[i]; j <= b[i]; ++j) {
        if (upper[j] != 2000000000) {
          upper[j] -= val[i];
        }
      }
    }
  }
  memset(sums, 0, sizeof(sums));
  for (int i = 0; i < m; ++i) {
    if (t[i] == 2) {
      bool ok = false;
      for (int j = a[i]; j <= b[i]; ++j) {
        if (upper[j] == 2000000000) {
          upper[j] = val[i] - sums[j];
          ok = true;
        } else if (upper[j] + sums[j] >= val[i]) {
          ok = true;
        }
      }
      if (!ok) {
        printf("NO\n");
        return 0;
      }
    } else {
      for (int j = a[i]; j <= b[i]; ++j) {
        sums[j] += val[i];
      }
    }
  }
  printf("YES\n");
  for (int i = 1; i <= n; ++i) {
    if (upper[i] == 2000000000) {
      printf("0 ");
    } else {
      printf("%d ", upper[i]);
    }
  }
  return 0;
}
