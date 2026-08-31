#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, sum = 0;
  cin >> n;
  int w[n];
  if (n < 2) {
    cout << "NO";
    return 0;
  }
  if (n >= 2) {
    for (int i = 0; i < n; i++) {
      cin >> w[i];
      sum = sum + w[i];
    }
    if (n % 2 != 0 && sum == n * 200) {
      cout << "NO";
      return 0;
    } else if (sum / 2 / 10 % 10 == 0) {
      cout << "YES";
      return 0;
    } else {
      cout << "NO";
      return 0;
    }
  }
}
