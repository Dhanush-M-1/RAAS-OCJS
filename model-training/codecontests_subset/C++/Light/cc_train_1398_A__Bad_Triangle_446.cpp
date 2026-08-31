#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
const int oo = INT_MAX;
int t, n;
int a[N];
int main() {
  cin >> t;
  while (t--) {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) scanf("%d", a + i);
    if (a[0] + a[1] <= a[n - 1])
      printf("%d %d %d\n", 1, 2, n);
    else
      puts("-1");
  }
}
