#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  long long xr1 = 0, xr2 = 0;
  for (int i = 0; i < n; i++) {
    long long s;
    cin >> s;
    xr1 = xr1 ^ s;
  }
  for (int i = 0; i < n - 1; i++) {
    long long s;
    cin >> s;
    xr2 = xr2 ^ s;
    xr1 = xr1 ^ s;
  }
  cout << xr1 << endl;
  for (int i = 0; i < n - 2; i++) {
    long long s;
    cin >> s;
    xr2 = xr2 ^ s;
  }
  cout << xr2 << endl;
}
