#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, a[110], r = 1000, c = 1100;
  cin >> n >> k;
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  for (int i = 0; i < n; i++) {
    if (k % a[i] == 0) {
      c = k / a[i];
    }
    if (c < r) {
      r = c;
    }
  }
  printf("%d", r);
}
