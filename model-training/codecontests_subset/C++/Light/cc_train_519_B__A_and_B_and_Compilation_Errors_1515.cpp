#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, s, a = 0, b = 0, c = 0;
  cin >> n;
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
  cout << a - b << endl << b - c << endl;
  return 0;
}
