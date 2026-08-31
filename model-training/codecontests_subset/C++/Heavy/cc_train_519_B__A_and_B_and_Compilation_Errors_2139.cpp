#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, i, j, k;
  cin >> n;
  long long a[n], b[n - 1], c[n - 2];
  for (i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (i = 0; i < n - 1; i++) {
    cin >> b[i];
  }
  for (i = 0; i < n - 2; i++) {
    cin >> c[i];
  }
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  long long first = -1, second = -1;
  for (i = 0; i < n - 1; i++) {
    if (a[i] != b[i]) {
      first = a[i];
      break;
    }
  }
  if (first == -1) {
    first = a[n - 1];
  }
  for (i = 0; i < n - 2; i++) {
    if (b[i] != c[i]) {
      second = b[i];
      break;
    }
  }
  if (second == -1) {
    second = b[n - 2];
  }
  cout << first << "\n" << second << endl;
}
