#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, s = 0, i, j;
  cin >> n;
  int a[n], b[n];
  for (i = 0; i <= n - 1; i++) cin >> a[i] >> b[i];
  for (j = 0; j <= n - 1; j++)
    for (i = 0; i <= n - 1; i++) {
      if (i == j) {
        i++;
      }
      if (i <= n - 1) {
        if (a[j] == b[i]) s++;
      }
    }
  cout << s;
}
