#include <bits/stdc++.h>
using namespace std;
int a[600], b[2000], n, m, i, j;
int result, k;
int main() {
  cin >> n >> m;
  i = 1;
  while (i <= n) {
    cin >> a[i];
    b[i] = -1;
    i++;
  }
  i = 1;
  while (i <= m) {
    cin >> k;
    for (j = 1; j <= n; j++) {
      if (b[j] > b[k]) result = result + a[j];
    }
    b[k] = i;
    i++;
  }
  cout << result;
  return 0;
}
