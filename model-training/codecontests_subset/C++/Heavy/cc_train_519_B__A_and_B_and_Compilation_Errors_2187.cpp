#include <bits/stdc++.h>
using namespace std;
const int oo = (int)1e9;
const long long ooll = (long long)1e18;
int n;
int v1[1234567], v2[1234567], v3[1234567];
int main() {
  scanf("%i", &n);
  for (int i = 0; i < n; ++i) {
    scanf("%i", v1 + i);
  }
  for (int i = 0; i < n - 1; ++i) {
    scanf("%i", v2 + i);
  }
  for (int i = 0; i < n - 2; ++i) {
    scanf("%i", v3 + i);
  }
  sort(v1, v1 + n);
  sort(v2, v2 + n - 1);
  sort(v3, v3 + n - 2);
  int x = v1[n - 1], y = v2[n - 2];
  for (int i = 0; i < n - 1; ++i) {
    if (v1[i] != v2[i]) {
      x = v1[i];
      break;
    }
  }
  for (int i = 0; i < n - 2; ++i) {
    if (v2[i] != v3[i]) {
      y = v2[i];
      break;
    }
  }
  cout << x << " " << y;
  return 0;
}
