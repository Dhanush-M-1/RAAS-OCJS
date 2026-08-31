#include <bits/stdc++.h>
using namespace std;
int a[110];
int main() {
  int n, k;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (k % a[i] != 0) a[i] = 0;
  }
  sort(a, a + n);
  cout << k / a[n - 1];
  return 0;
}
