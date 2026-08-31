#include <bits/stdc++.h>
int N, M, a[5005], b[5005], l[5005], r[5005], m[5005], t[5005];
int main() {
  scanf("%d%d", &N, &M);
  for (int i = 1; i <= N; i++) b[i] = 1e9;
  for (int i = 1; i <= M; i++) {
    scanf("%d%d%d%d", &t[i], &l[i], &r[i], &m[i]);
    for (int j = l[i]; j <= r[i]; j++)
      if (t[i] == 1)
        a[j] += m[i];
      else
        b[j] = std::min(b[j], m[i] - a[j]);
  }
  for (int i = 1; i <= N; i++) a[i] = 0;
  for (int i = 1; i <= M; i++) {
    int mi = -1e9;
    for (int j = l[i]; j <= r[i]; j++)
      if (t[i] == 1)
        a[j] += m[i];
      else
        mi = std::max(mi, a[j] + b[j]);
    if (t[i] == 2 && mi != m[i]) {
      puts("NO");
      return 0;
    }
  }
  puts("YES");
  for (int i = 1; i <= N; i++) printf("%d%c", b[i], i == N ? '\n' : ' ');
}
