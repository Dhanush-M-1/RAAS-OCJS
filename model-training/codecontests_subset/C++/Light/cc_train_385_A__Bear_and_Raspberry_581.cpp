#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, c, a[200], max1 = 0, i;
  cin >> n >> c;
  for (i = 0; i < n; i++) cin >> a[i];
  for (i = 0; i < n - 1; i++)
    if (a[i] - a[i + 1] > max1) max1 = a[i] - a[i + 1];
  cout << max(0LL, max1 - c) << endl;
  return 0;
}
