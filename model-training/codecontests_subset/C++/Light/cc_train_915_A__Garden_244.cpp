#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int e = 0;
  for (int i = 0; i < a; ++i) {
    int c;
    cin >> c;
    if (b % c == 0 && c > e) e = c;
  }
  cout << b / e;
}
