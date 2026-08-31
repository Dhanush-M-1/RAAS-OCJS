#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 5;
long long n, k, a[105], x, mn = N;
int main() {
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  sort(a + 1, a + 1 + n);
  for (int i = n; i >= 1; i--) {
    if (k % a[i] == 0) {
      cout << k / a[i];
      return 0;
    }
  }
}
