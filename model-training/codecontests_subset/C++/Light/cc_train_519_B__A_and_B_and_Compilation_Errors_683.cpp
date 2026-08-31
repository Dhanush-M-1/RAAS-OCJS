#include <bits/stdc++.h>
using namespace std;
long long n, a[100005], b[100005], c[100005];
void Citire() {
  long long x;
  cin >> n;
  int i;
  x = 0;
  for (i = 1; i <= n; i++) {
    cin >> a[i];
    x ^= a[i];
  }
  for (i = 1; i < n; i++) {
    cin >> b[i];
    x ^= b[i];
  }
  for (i = 1; i < n - 1; i++) cin >> c[i];
  cout << x << "\n";
  ;
  x = 0;
  for (i = 1; i < n; i++) x ^= b[i];
  for (i = 1; i < n - 1; i++) x ^= c[i];
  cout << x << "\n";
}
int main() {
  Citire();
  return 0;
}
