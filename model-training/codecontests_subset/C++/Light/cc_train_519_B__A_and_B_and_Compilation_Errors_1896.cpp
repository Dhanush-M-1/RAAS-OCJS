#include <bits/stdc++.h>
using namespace std;
long long int n, a[100000], b[1000000], c[100000], x = 0, y = 0, z = 0;
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    x ^= a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
    y ^= b[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
    z ^= c[i];
  }
  cout << (x ^ y) << endl << (y ^ z);
  return 0;
}
