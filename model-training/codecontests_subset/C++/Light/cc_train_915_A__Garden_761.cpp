#include <bits/stdc++.h>
using namespace std;
int n, k, a[105], i;
int main() {
  cin >> n >> k;
  for (i = 1; i <= n; i++) cin >> a[i];
  sort(a + 1, a + n + 1);
  for (i = n; i >= 1; i--)
    if (k % a[i] == 0) return cout << k / a[i], 0;
}
