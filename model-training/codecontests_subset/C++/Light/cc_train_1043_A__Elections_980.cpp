#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, s = 0, max = 0;
  int temp;
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> temp;
    if (temp > max) {
      max = temp;
    }
    s += temp;
  }
  if (max * n - s > s) {
    cout << max;
  } else {
    cout << (s * 2) / n + 1;
  }
  return 0;
}
