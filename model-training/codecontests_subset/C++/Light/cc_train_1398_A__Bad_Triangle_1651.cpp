#include <bits/stdc++.h>
using namespace std;
const int maxn = 100000 + 5;
int a[maxn];
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
      scanf("%d", &a[i]);
    }
    if (a[1] + a[2] <= a[n]) {
      cout << 1 << " " << 2 << " " << n << endl;
    } else {
      cout << -1 << endl;
    }
  }
  return 0;
}
