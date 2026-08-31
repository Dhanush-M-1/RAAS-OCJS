#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c = 0, s = 0;
  cin >> a;
  for (int i = 1; i <= a; i++) {
    cin >> b;
    c = c + b;
  }
  for (int i = 1; i <= a - 1; i++) {
    cin >> b;
    s = s + b;
  }
  cout << c - s << endl;
  c = 0;
  for (int i = 1; i < a - 1; i++) {
    cin >> b;
    c = c + b;
  }
  cout << s - c << endl;
  return 0;
}
