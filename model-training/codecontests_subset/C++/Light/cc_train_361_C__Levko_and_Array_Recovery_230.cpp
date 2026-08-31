#include <bits/stdc++.h>
using namespace std;
const int MAXN = 400010;
int gcd(int a, int b) { return b ? gcd(b, a % b) : a; }
int num[5005], X[5005], A[5005], B[5005], C[5005];
int main() {
  int n, m, x, a, b, c;
  cin >> n >> m;
  bool flag = 0;
  for (int i = 1; i <= n; i++) num[i] = -1000000000;
  for (int i = 0; i < m; i++) {
    scanf("%d%d%d%d", &x, &a, &b, &c);
    X[i] = x, A[i] = a, B[i] = b, C[i] = c;
    if (x == 1) {
      for (int j = a; j <= b; j++)
        if (num[j] != -1000000000) num[j] += c;
    } else {
      for (int j = a; j <= b; j++) {
        if (num[j] >= c || num[j] == -1000000000) num[j] = c;
      }
    }
  }
  for (int i = m - 1; i >= 0; i--) {
    if (X[i] == 1) {
      for (int j = A[i]; j <= B[i]; j++) num[j] -= C[i];
    } else {
      int t = num[A[i]];
      for (int j = A[i]; j <= B[i]; j++) t = max(t, num[j]);
      if (t != C[i]) {
        puts("NO");
        return 0;
      }
    }
  }
  puts("YES");
  for (int i = 1; i <= n; i++) printf("%d ", max(num[i], -1000000000));
  return 0;
}
