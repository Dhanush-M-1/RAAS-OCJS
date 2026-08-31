#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int sum = 0;
  int x;
  cin >> n;
  int maxi = 0;
  for (int i = 0; i < n; i++) {
    cin >> x;
    maxi = max(maxi, x);
    sum = sum + x;
  }
  if (maxi * n > 2 * sum) {
    cout << maxi << endl;
  } else if ((2 * sum) % n == 0) {
    cout << (2 * sum) / n + 1 << endl;
  } else {
    double q = (2 * sum) / (n + 0.0) + 0.0;
    cout << ceil(q) << endl;
  }
}
