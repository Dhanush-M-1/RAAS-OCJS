#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:500000000")
using namespace std;
int main() {
  int n, c, i;
  cin >> n >> c;
  vector<int> a(n);
  for (i = 0; i < n; i++) cin >> a[i];
  int res = 0;
  for (i = 0; i + 1 < n; i++) res = max(res, a[i] - a[i + 1] - c);
  cout << res << endl;
}
