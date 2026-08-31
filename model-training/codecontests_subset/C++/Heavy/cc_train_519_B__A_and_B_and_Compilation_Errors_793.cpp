#include <bits/stdc++.h>
using namespace std;
int n;
long long a[100005];
long long b[100005];
long long c[100005];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) cin >> b[i];
  for (int i = 0; i < n - 2; i++) cin >> c[i];
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  int i = 0;
  int j = 0;
  int f = 0;
  while (f < 1) {
    if (a[i] == b[j]) {
      i++;
      j++;
      continue;
    }
    if (a[i] != b[j]) {
      cout << a[i] << endl;
      break;
      f = 1;
    }
  }
  i = 0;
  j = 0;
  f = 0;
  while (f < 1) {
    if (b[i] == c[j]) {
      i++;
      j++;
      continue;
    }
    if (b[i] != c[j]) {
      cout << b[i] << endl;
      break;
      f = 1;
    }
  }
  return 0;
}
