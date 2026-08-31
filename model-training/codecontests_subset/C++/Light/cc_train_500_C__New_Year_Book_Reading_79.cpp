#include <bits/stdc++.h>
using namespace std;
int a[505], b[5005];
int use[505];
int main() {
  int i, j, s, n, t;
  cin >> n >> t;
  for (i = 1; i <= n; i++) scanf("%d", &a[i]);
  s = 0;
  for (i = 1; i <= t; i++) {
    scanf("%d", &b[i]);
    memset(use, 0, sizeof(use));
    for (j = i - 1; j >= 1; j--) {
      if (b[i] == b[j]) break;
    }
    j++;
    for (j; j < i; j++) {
      if (!use[b[j]]) {
        s += a[b[j]];
        use[b[j]] = 1;
      }
    }
  }
  cout << s << endl;
}
