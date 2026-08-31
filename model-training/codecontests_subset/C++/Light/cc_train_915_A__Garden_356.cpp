#include <bits/stdc++.h>
using namespace std;
int n, k, a[110];
int main() {
  std::ios_base::sync_with_stdio(false);
  cin >> n >> k;
  for (int i = 0; i < n; i++) cin >> a[i];
  sort(a, a + n);
  reverse(a, a + n);
  for (int i = 0; i < n; i++)
    if (k % a[i] == 0) {
      cout << k / a[i];
      return 0;
    }
}
