#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, d = 0;
  cin >> n >> c;
  int a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) d = max(d, a[i] - a[i + 1] - c);
  cout << d;
}
