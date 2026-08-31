#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int a[n], k[n];
  for (int i = 0; i < n; i++) k[i] = 0;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int j = 0; j < n - 1; j++) {
    if (a[j] > a[j + 1]) k[j] = a[j] - a[j + 1] - c;
  }
  int m = k[0];
  for (int i = 0; i < n - 1; i++) {
    if (k[i + 1] > m) m = k[i + 1];
  }
  cout << m << endl;
  return 0;
}
