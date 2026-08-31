#include <bits/stdc++.h>
using namespace std;
const int MAX_n = 1e5 + 2;
long long int n, a[MAX_n], b[MAX_n], c[MAX_n];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
  }
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  for (int i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      cout << a[i] << endl;
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (c[i] != b[i]) {
      cout << b[i];
      break;
    }
  }
  return 0;
}
