#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  int Max = 1;
  for (int i = 0; i < n; i++) {
    if (k % a[i] == 0 && a[i] > Max) Max = a[i];
  }
  cout << k / Max << endl;
  return 0;
}
