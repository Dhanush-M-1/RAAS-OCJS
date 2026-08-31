#include <bits/stdc++.h>
using namespace std;
long n, k, res;
long a[101];
int main() {
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    if (k % a[i] == 0) res = max(res, a[i]);
  }
  cout << k / res;
}
