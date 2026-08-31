#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, h, l, maxi;
  int t[150], v[100];
  cin >> n;
  cin >> k;
  h = k;
  l = 0;
  for (int i = 0; i < n; i++) {
    cin >> t[i];
    if (k % t[i] == 0) {
      v[l] = t[i];
      l++;
    }
  }
  maxi = v[0];
  for (int i = 1; i < l; i++) {
    if (maxi < v[i]) maxi = v[i];
  }
  h = k / maxi;
  cout << h;
}
