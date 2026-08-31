#include <bits/stdc++.h>
using namespace std;
int n, h[110], a[110];
int total;
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    scanf("%d %d", &h[i], &a[i]);
  }
  for (int i = 0; i < n - 1; ++i) {
    for (int j = i + 1; j < n; ++j) {
      if (h[i] == a[j]) total++;
      if (h[j] == a[i]) total++;
    }
  }
  printf("%d\n", total);
  return 0;
}
