#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, l;
  cin >> n >> m >> l;
  int c = (n * l) - (m * l);
  int x = c / m;
  if (c % m == 0) {
    cout << x;
  } else {
    cout << x + 1;
  }
}
