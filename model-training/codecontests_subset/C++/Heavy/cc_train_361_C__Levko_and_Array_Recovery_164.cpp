#include <bits/stdc++.h>
using namespace std;
int n, m;
int S[5001], A[5001], X[5001];
int op[5001][4];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i < n + 1; i++) {
    A[i] = 1000000000;
    S[i] = 0;
  }
  for (int i = 0; i < m; i++) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int l, r, d;
      scanf("%d%d%d", &l, &r, &d);
      op[i][0] = 1, op[i][1] = l;
      op[i][2] = r;
      op[i][3] = d;
      for (int j = l; j < r + 1; j++) S[j] += d;
    } else {
      int l, r, d;
      scanf("%d%d%d", &l, &r, &d);
      op[i][0] = 2, op[i][1] = l;
      op[i][2] = r;
      op[i][3] = d;
      for (int j = l; j < r + 1; j++) A[j] = min(A[j], d - S[j]);
    }
  }
  for (int i = 1; i < n + 1; i++) {
    X[i] = A[i];
  }
  for (int i = 0; i < m; i++) {
    if (op[i][0] == 1) {
      for (int j = op[i][1]; j < op[i][2] + 1; j++) {
        A[j] += op[i][3];
      }
    } else {
      int M = -1000000000;
      for (int j = op[i][1]; j < op[i][2] + 1; j++) {
        M = max(M, A[j]);
      }
      if (M != op[i][3]) {
        printf("NO\n");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (int i = 1; i < n + 1; i++) cout << X[i] << " ";
  return 0;
}
