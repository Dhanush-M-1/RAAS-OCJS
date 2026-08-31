#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a = 0, b = 0, c = 0;
  int r;
  for (int i = 0; i < n; ++i) {
    cin >> r;
    a += r;
  }
  for (int i = 0; i < n - 1; ++i) {
    cin >> r;
    b += r;
  }
  for (int i = 0; i < n - 2; ++i) {
    cin >> r;
    c += r;
  }
  cout << (a - b) << '\n' << (b - c) << '\n';
  return 0;
}
