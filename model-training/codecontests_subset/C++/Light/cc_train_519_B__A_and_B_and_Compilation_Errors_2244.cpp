#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  vector<long long> s, s1;
  cin >> n;
  long long a[n], b[n - 1], c[n - 2];
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) cin >> b[i];
  for (int i = 0; i < n - 2; i++) cin >> c[i];
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  for (int i = 0; i < n; i++)
    if (i == n - 1 || a[i] != b[i]) {
      cout << a[i] << endl;
      break;
    }
  for (int i = 0; i < n - 1; i++)
    if (i == n - 2 || b[i] != c[i]) {
      cout << b[i] << endl;
      break;
    }
}
