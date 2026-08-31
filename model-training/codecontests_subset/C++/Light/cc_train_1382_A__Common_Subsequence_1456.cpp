#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int n, m;
    scanf("%d%d", &n, &m);
    vector<int> A(10001, 0);
    vector<int> B(10001, 0);
    int x;
    for (int i = 0; i < n; i++) {
      scanf("%d", &x);
      A[x]++;
    }
    for (int i = 0; i < m; i++) {
      scanf("%d", &x);
      B[x]++;
    }
    int flag = 1;
    for (int i = 0; i < 10001; i++)
      if (A[i] && B[i]) {
        printf("YES\n1 %d\n", i);
        flag = 0;
        break;
      }
    if (flag) printf("NO\n");
  }
}
