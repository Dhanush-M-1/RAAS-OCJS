#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7;
const int INF = 0x3f3f3f3f;
int n, d;
int a[N], s[N];
int z[N], cnt = 0;
int cm[N];
int main() {
  scanf("%d%d", &n, &d);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
    s[i] = s[i - 1] + a[i];
    if (a[i] == 0) z[cnt++] = i;
  }
  cm[n + 1] = INF;
  for (int i = n; i >= 1; --i) {
    cm[i] = min(d - s[i], cm[i + 1]);
    if (cm[i] < 0) {
      printf("-1\n");
      return 0;
    }
  }
  int answer = 0;
  int ans = 0;
  for (int i = 0; i < cnt; ++i) {
    s[z[i]] += ans;
    if (s[z[i]] >= 0) continue;
    s[z[i]] += (cm[z[i]] - ans);
    if (s[z[i]] < 0) {
      printf("-1\n");
      return 0;
    }
    ans = cm[z[i]];
    answer++;
  }
  printf("%d\n", answer);
  return 0;
}
