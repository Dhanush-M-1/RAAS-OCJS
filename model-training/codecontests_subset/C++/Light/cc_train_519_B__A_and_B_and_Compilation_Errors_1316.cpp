#include <bits/stdc++.h>
using namespace std;
long long n, a, b, c, f, in1, in2, in3;
int main() {
  cin >> n;
  for (long long i = 0; i < n; i++) {
    cin >> in1;
    a += in1;
  }
  for (long long i = 0; i < n - 1; i++) {
    cin >> in2;
    b += in2;
  }
  for (long long i = 0; i < n - 2; i++) {
    cin >> in3;
    c += in3;
  }
  cout << a - b << endl;
  cout << b - c << endl;
}
