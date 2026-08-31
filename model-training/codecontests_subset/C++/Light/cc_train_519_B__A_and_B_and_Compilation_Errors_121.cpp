#include <bits/stdc++.h>
using namespace std;
int n, a[100001], b[100001], c[100001], e, j;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) cin >> b[i];
  for (int i = 0; i < n - 2; i++) cin >> c[i];
  sort(a, a + n);
  sort(b, b + n - 1);
  while (a[j] == b[j] && j < n) j++;
  cout << a[j] << endl;
  c[n - 2] = a[j];
  sort(c, c + n - 1);
  j = 0;
  while (a[j] == c[j] && j < n) j++;
  cout << a[j] << endl;
  return 0;
}
