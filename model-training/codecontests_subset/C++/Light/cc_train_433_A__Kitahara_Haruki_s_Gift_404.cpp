#include <bits/stdc++.h>
using namespace std;
int n;
int w[101];
int k = 0;
int s = 0;
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%d", &w[i]);
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (w[i] > w[j]) {
        int tmp = w[i];
        w[i] = w[j];
        w[j] = tmp;
      }
    }
  }
  k = w[0];
  for (int i = 1; i < n; i++) {
    if (k < s)
      k += w[i];
    else
      s += w[i];
  }
  if (k == s)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
