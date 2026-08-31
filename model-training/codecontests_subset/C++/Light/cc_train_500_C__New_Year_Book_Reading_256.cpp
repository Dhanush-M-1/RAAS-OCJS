#include <bits/stdc++.h>
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  int W[600], M[1100];
  int i, j;
  for (i = 0; i < n; ++i) scanf("%d", &W[i]);
  for (i = 0; i < m; ++i) scanf("%d", &M[i]);
  int stack[600], top = n - 1;
  int visited[600] = {0};
  for (i = 0; i < m; ++i) {
    if (visited[M[i]] == 0) {
      stack[top--] = M[i];
      visited[M[i]] = 1;
    }
  }
  int total = 0;
  for (i = 0; i < m; ++i) {
    j = n;
    while (stack[--j] != M[i]) total += W[stack[j] - 1];
    int T[600];
    int k = 0;
    top = n;
    while (stack[--top] != M[i]) T[k++] = stack[top];
    int l = stack[top];
    while (k > 0) stack[top++] = T[--k];
    stack[top++] = l;
  }
  printf("%d", total);
  return (0);
}
