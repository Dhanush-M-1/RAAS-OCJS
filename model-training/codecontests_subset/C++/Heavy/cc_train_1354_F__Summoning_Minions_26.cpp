#include <bits/stdc++.h>
using namespace std;
int T, n, k;
struct card {
  int a, b, id;
} A[105];
int f[105][105], fr[105][105];
int use[105], used[105], cnt, pos, num;
int cmp(card u, card v) { return u.b < v.b; }
int main() {
  scanf("%d", &T);
  while (T--) {
    scanf("%d %d", &n, &k);
    for (int i = 1; i <= n; i++) scanf("%d %d", &A[i].a, &A[i].b), A[i].id = i;
    sort(A + 1, A + n + 1, cmp);
    memset(f, 0, sizeof(f));
    memset(used, 0, sizeof(used));
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        if (f[i][j] < f[i - 1][j] + (k - 1) * A[i].b)
          f[i][j] = f[i - 1][j] + (k - 1) * A[i].b, fr[i][j] = j;
        if (f[i][j + 1] < f[i - 1][j] + A[i].a + j * A[i].b)
          f[i][j + 1] = f[i - 1][j] + A[i].a + j * A[i].b, fr[i][j + 1] = j;
      }
    }
    cnt = 0, pos = n, num = k;
    while (pos) {
      if (fr[pos][num] == num - 1) use[++cnt] = A[pos].id, used[A[pos].id] = 1;
      num = fr[pos][num], pos--;
    }
    reverse(use + 1, use + cnt + 1);
    printf("%d\n", 2 * n - k);
    for (int i = 1; i < cnt; i++) printf("%d ", use[i]);
    for (int i = 1; i <= n; i++)
      if (!used[i]) printf("%d %d ", i, -i);
    printf("%d\n", use[cnt]);
  }
  return 0;
}
