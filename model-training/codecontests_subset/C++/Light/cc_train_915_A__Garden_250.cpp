#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[100], n, temp, m, ans;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  for (int i = 0; i < (n - 1); i++) {
    for (int j = 0; j < n - i - 1; j++) {
      if (a[j] < a[j + 1]) {
        temp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = temp;
      }
    }
  }
  for (int i = 0; i < n; i++) {
    if (m % a[i] == 0) {
      ans = max(0, m / a[i]);
      cout << ans << endl;
      return 0;
    }
  }
  return 0;
}
