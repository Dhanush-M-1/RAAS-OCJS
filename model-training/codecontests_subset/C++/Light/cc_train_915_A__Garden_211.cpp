#include <bits/stdc++.h>
using namespace std;
int n, k, a[1005], m;
int main() {
  cin >> n >> k;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= n; i++)
    if (k % a[i] == 0)
      if (a[i] > m) m = a[i];
  cout << k / m << endl;
  return 0;
}
