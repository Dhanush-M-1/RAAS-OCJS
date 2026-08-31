#include <bits/stdc++.h>
using namespace std;
int n, m;
int a[111111], b[111111], c[1111];
void po(int p) {
  if (a[p] == 0)
    b[p]++;
  else
    po(a[p]);
}
int main() {
  int z = 0, k, i, j, x, y;
  string s1, s2;
  cin >> n >> m;
  for (i = 1; i <= n; i++) cin >> a[i];
  for (i = 1; i <= n; i++) po(i);
  x = 1;
  while (a[m]) {
    m = a[m];
    x++;
  }
  c[0] = 1;
  for (i = 1; i <= n; i++)
    if (b[i] && i != m) {
      for (j = n; j >= 0; j--)
        if (c[j]) c[j + b[i]] = 1;
    }
  for (i = 0; i <= n; i++)
    if (c[i]) cout << i + x << endl;
}
