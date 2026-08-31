#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  int count = 0;
  for (int sc = 0; sc <= min(n, 2 * c); sc += 2) {
    for (int sb = 0; sb <= min(n - sc, b); sb++) {
      if (n - sb - sc <= a / 2) count++;
    }
  }
  cout << count;
  return 0;
}
