#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[100001], b[100001], c[100001], i;
  cin >> n;
  for (i = 0; i < n; i++) cin >> a[i];
  for (i = 0; i < n - 1; i++) cin >> b[i];
  for (i = 0; i < n - 2; i++) cin >> c[i];
  int sm_a = 0, sm_b = 0, sm_c = 0;
  for (i = 0; i < n; i++) sm_a += a[i];
  for (i = 0; i < n - 1; i++) sm_b += b[i];
  for (i = 0; i < n - 2; i++) sm_c += c[i];
  cout << sm_a - sm_b << " " << sm_b - sm_c;
  return 0;
}
