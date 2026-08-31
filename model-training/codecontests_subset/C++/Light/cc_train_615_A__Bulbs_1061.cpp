#include <bits/stdc++.h>
using namespace std;
int check(int a[], int m) {
  for (int i = 1; i <= m; i++) {
    if (a[i] != 0) return 0;
  }
  return 1;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie();
  int n, m, c, b;
  cin >> n >> m;
  int a[m + 1];
  for (int i = 1; i <= m; i++) a[i] = i;
  for (int i = 1; i <= n; i++) {
    cin >> c;
    for (int j = 1; j <= c; j++) {
      cin >> b;
      a[b] = 0;
    }
  }
  if (check(a, m))
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
