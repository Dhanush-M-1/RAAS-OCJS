#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a = 0, s, b = 0, c = 0;
  for (int i = 0; i < n; i++) {
    cin >> s;
    a += s;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> s;
    b += s;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> s;
    c += s;
  }
  cout << a - b << "\n" << b - c << "\n";
}
