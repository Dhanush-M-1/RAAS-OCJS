#include <bits/stdc++.h>
using namespace std;
map<char, int> M;
int n, a[100000 * 3 + 100], b[100000 * 3 + 100], c[100000 * 3 + 100];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i];
  sort(a, a + n - 1 + 1);
  for (int i = 0; i < n - 1; i++) cin >> b[i];
  sort(b, b + n - 1);
  for (int i = 0; i < n - 2; i++) cin >> c[i];
  sort(c, c + n - 1 - 1);
  for (int i = 0; i < n; i++)
    if (a[i] != b[i]) {
      cout << a[i] << endl;
      break;
    }
  for (int i = 0; i < n - 1; i++)
    if (c[i] != b[i]) {
      cout << b[i] << endl;
      break;
    }
  return 0;
}
