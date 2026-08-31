#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k = 0, maxx = -1;
  cin >> n;
  int a[n + 10];
  int sum = 0;
  k = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
    if (maxx < a[i]) {
      maxx = a[i];
    }
  }
  while (k * n - sum <= sum || maxx > k) {
    k++;
  }
  cout << k;
}
