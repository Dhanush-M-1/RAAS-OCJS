#include <bits/stdc++.h>
using namespace std;
int main() {
  int x;
  long long a = 0, r, b = 0, c = 0;
  cin >> x;
  for (int i = 0; i < x; i++) {
    cin >> r;
    a += r;
  }
  for (int i = 0; i < x - 1; i++) {
    cin >> r;
    b += r;
  }
  for (int i = 0; i < x - 2; i++) {
    cin >> r;
    c += r;
  }
  long long sum = a - b, sum1 = b - c;
  cout << sum << endl;
  cout << sum1 << endl;
  return 0;
}
