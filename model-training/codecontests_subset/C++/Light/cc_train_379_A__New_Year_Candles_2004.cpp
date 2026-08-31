#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  int C = 0;
  int R = 0;
  cin >> n >> m;
  while (true) {
    if (n == 0) break;
    n--;
    R++;
    C++;
    if (C == m) {
      C = 0;
      n++;
    }
  }
  cout << R << endl;
  return 0;
}
