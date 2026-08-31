#include <bits/stdc++.h>
using namespace std;
int a[222];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) cin >> a[i];
  int ans = m;
  for (int i = 0; i < n - 1; i++)
    if (a[i] - a[i + 1] > ans) ans = a[i] - a[i + 1];
  cout << ans - m << endl;
  return 0;
}
