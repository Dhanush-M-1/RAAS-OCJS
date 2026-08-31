#include <bits/stdc++.h>
using namespace std;
long long int psum[5010], max_val[5010];
long long int mmin(long long int a, long long int b) {
  if (a < b) return a;
  return b;
}
int main() {
  long long int qry[5010], l[5010], r[5010], d[5010], x, y, v, N, M, psum[5010],
      max_val[5010];
  cin >> N >> M;
  for (int i = 0; i < 5004; i++) {
    psum[i] = 0;
    max_val[i] = 1000000000;
  }
  for (int i = 1; i <= M; i++) {
    cin >> qry[i] >> l[i] >> r[i] >> d[i];
    if (qry[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) psum[j] += d[i];
    } else {
      for (int j = l[i]; j <= r[i]; j++)
        max_val[j] = mmin(max_val[j], d[i] - psum[j]);
    }
  }
  for (int i = 1; i <= N; i++) {
    if (max_val[i] < -1000000000 || max_val[i] > 1000000000) {
      printf("NO\n");
      return 0;
    }
  }
  long long int curr_max;
  for (int i = 0; i < 5010; i++) psum[i] = 0;
  for (int i = 1; i <= M; i++) {
    if (qry[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) psum[j] += d[i];
    } else {
      curr_max = -10000000000;
      for (int j = l[i]; j <= r[i]; j++) {
        if (curr_max < (max_val[j] + psum[j])) curr_max = max_val[j] + psum[j];
      }
      if (curr_max != d[i]) {
        printf("NO\n");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (int i = 1; i <= N - 1; i++) printf("%lld ", max_val[i]);
  printf("%lld\n", max_val[N]);
  return 0;
}
