#include <bits/stdc++.h>
using namespace std;
const int N = 1000010;
int a[N];
int main() {
  int n, x, res = 1000000007;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &x);
    a[x] = 1;
  }
  a[0] = a[1] = 1;
  for (int i = 1; i <= (1e6); i++) {
    if (a[i] == 0)
      a[i] = a[i - 1];
    else
      a[i] = i;
  }
  int nxt = 1000000;
  for (int i = 1000000; i >= 1; i--) {
    res = min(res, max(1000000 - i, a[i - 1] - 1));
  }
  cout << res;
  return 0;
}
