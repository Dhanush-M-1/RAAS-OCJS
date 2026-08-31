#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 10;
int N, M, K, pos[maxn], a[maxn];
int bad[maxn];
int good[maxn];
int main() {
  scanf("%d %d %d", &N, &M, &K);
  for (int i = 1; i <= M; ++i) {
    scanf("%d", &pos[i]);
    bad[pos[i]] = 1;
  }
  for (int i = 1; i <= K; ++i) {
    scanf("%d", &a[i]);
  }
  if (bad[0] == 1) {
    printf("-1\n");
    return 0;
  }
  good[0] = 0;
  int low = 0;
  for (int i = 1; i <= N; ++i) {
    if (bad[i]) {
      good[i] = good[i - 1];
    } else {
      good[i] = i;
    }
    low = max(low, i - good[i] + 1);
  }
  if (low > K) {
    printf("-1\n");
    return 0;
  }
  long long ans = 1e18;
  for (int k = low; k <= K; ++k) {
    int j = 0;
    long long cnt = 0;
    while (j < N) {
      ++cnt;
      j += k;
      if (j >= N) break;
      if (bad[j]) {
        ++cnt;
        j = good[j] + k;
      }
    }
    ans = min(ans, cnt * a[k]);
  }
  printf("%lld\n", ans);
}
