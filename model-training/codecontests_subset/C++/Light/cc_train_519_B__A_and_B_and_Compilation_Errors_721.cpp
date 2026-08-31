#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x;
  long long int a[3] = {0, 0, 0};
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    a[0] += x;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    a[1] += x;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    a[2] += x;
  }
  cout << a[0] - a[1] << endl << a[1] - a[2];
  return 0;
}
