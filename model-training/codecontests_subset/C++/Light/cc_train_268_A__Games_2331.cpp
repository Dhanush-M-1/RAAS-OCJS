#include <bits/stdc++.h>
using namespace std;
int a[110], b[110];
int main() {
  int n;
  while (scanf("%d", &n) == 1) {
    int ans = 0;
    for (int i = 0; i < n; i++) scanf("%d%d", &a[i], &b[i]);
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (a[i] == b[j]) ans++;
    printf("%d\n", ans);
  }
}
