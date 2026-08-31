#include <bits/stdc++.h>
int S[101], n, c, m = 0;
int main() {
  scanf("%d%d", &n, &c);
  for (int i = 0; i < n; i++) scanf("%d", &S[i]);
  for (int i = 0; i < n - 1; i++)
    if (m < S[i] - S[i + 1]) m = S[i] - S[i + 1];
  printf("%d", m - c > 0 ? (m - c) : 0);
}
