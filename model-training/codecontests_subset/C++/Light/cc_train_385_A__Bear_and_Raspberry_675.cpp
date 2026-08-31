#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, d;
  cin >> n >> d;
  int a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  int maxi = INT_MIN;
  for (int i = 1; i < n; i++) {
    maxi = max(maxi, a[i - 1] - a[i] - d);
  }
  if (maxi < 0)
    cout << "0";
  else
    cout << maxi;
}
