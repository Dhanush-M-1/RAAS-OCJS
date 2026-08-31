#include <bits/stdc++.h>
using namespace std;
int a[105];
int main(int argc, char **argv) {
  ios::sync_with_stdio(0);
  int n, c, d, maxi = 0;
  cin >> n >> c;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) {
    if ((a[i] - a[i + 1]) > maxi) maxi = a[i] - a[i + 1];
  }
  if ((maxi - c) < 0) return cout << 0, 0;
  cout << maxi - c;
  return 0;
}
