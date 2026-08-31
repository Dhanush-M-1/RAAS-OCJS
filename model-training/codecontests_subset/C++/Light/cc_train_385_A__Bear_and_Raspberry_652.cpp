#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[100];
  int n, c;
  cin >> n >> c;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int maxx = 0;
  for (int i = 0; i < n - 1; i++) {
    if (a[i] >= c) maxx = max(maxx, a[i] - a[i + 1] - c);
  }
  cout << maxx;
  return 0;
}
