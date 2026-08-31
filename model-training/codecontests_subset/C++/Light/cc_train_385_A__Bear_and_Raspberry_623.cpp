#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int n, c;
  cin >> n >> c;
  int a[120];
  for (int i = 0; i < n; ++i) cin >> a[i];
  for (int i = 0; i < n - 1; ++i) a[i] -= a[i + 1];
  int rt = 0;
  for (int i = 0; i < n - 1; ++i) rt = max(rt, a[i]);
  rt = max(rt - c, 0);
  cout << rt << endl;
}
