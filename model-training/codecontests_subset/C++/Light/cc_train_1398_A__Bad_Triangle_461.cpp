#include <bits/stdc++.h>
using namespace std;
int a[50005];
int main() {
  int t, n;
  cin >> t;
  while (t--) {
    cin >> n;
    for (int i = 1; i <= n; i++) {
      cin >> a[i];
    }
    if (a[1] + a[2] <= a[n]) {
      printf("1 2 %d\n", n);
    } else {
      puts("-1");
    }
  }
}
