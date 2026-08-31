#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int a[n], b[n], m = 0;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n; i++) {
    if (k % a[i] == 0) b[m++] = k / a[i];
  }
  int temp = b[0];
  for (int i = 1; i < m; i++) {
    if (b[i] < temp) temp = b[i];
  }
  cout << temp;
  return 0;
}
