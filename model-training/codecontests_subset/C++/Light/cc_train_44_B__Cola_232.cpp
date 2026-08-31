#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int n, m;
  long long kol = 0;
  int a, b, c;
  cin >> n >> a >> b >> c;
  for (int z = 0; z < c + 1; z++) {
    for (int k = 0; k < b + 1; k++) {
      int i = 2 * n - 2 * k - 4 * z;
      if (i <= a && i >= 0) kol++;
    }
  }
  cout << kol;
  return 0;
}
