#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, pas = 10000000;
  cin >> n;
  int a[n];
  a[n + 1] = 1000000;
  a[0] = 1;
  for (int i = 1; i <= n; i++) cin >> a[i];
  sort(a + 1, a + n + 1);
  for (int i = 0; i <= n; i++)
    pas = min(pas, max(a[i] - 1, 1000000 - a[i + 1]));
  cout << pas;
  return 0;
}
