#include <bits/stdc++.h>
using namespace std;
long long n, m;
long long arr[5050];
long long ke[5050];
long long go[5050];
struct kk {
  int a, b, c, d;
};
kk f[5050];
int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) arr[i] = LLONG_MAX;
  for (int i = 0; i < m; i++) {
    long long t, k, l, m;
    cin >> t >> k >> l >> m;
    f[i].a = t;
    f[i].b = k;
    f[i].c = l;
    f[i].d = m;
    if (t == 1) {
      for (int j = k - 1; j < l; j++) go[j] += m;
    } else {
      for (int j = k - 1; j < l; j++) {
        arr[j] = (arr[j] > m - go[j] ? m - go[j] : arr[j]);
      }
    }
  }
  for (int i = 0; i < n; i++)
    if (arr[i] == LLONG_MAX) arr[i] = 0;
  for (int i = 0; i < n; i++) ke[i] = arr[i];
  for (int i = 0; i < m; i++) {
    if (f[i].a == 1) {
      for (int j = f[i].b - 1; j < f[i].c; j++) ke[j] += f[i].d;
    } else {
      long long maxx = -LLONG_MAX;
      for (int j = f[i].b - 1; j < f[i].c; j++)
        maxx = (maxx < ke[j] ? ke[j] : maxx);
      if (maxx != f[i].d) {
        printf("NO");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (int i = 0; i < n; i++) printf("%d ", arr[i]);
  getchar();
  getchar();
}
