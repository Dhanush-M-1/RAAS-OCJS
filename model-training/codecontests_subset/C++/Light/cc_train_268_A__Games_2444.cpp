#include <bits/stdc++.h>
using namespace std;
int k, n, p;
int a[1000], b[1000];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i] >> b[i];
  p = 1;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++)
      if (a[i] == b[j]) {
        k++;
      }
  }
  cout << k;
  return 0;
}
