#include <bits/stdc++.h>
using namespace std;
int a, b, t, c, j, k, T, i, A[1028], B[1028], C[1028];
int main() {
  cin >> a >> b;
  while (a > 0) {
    a--;
    t++;
    if (t == b) {
      t = 0;
      a++;
    }
    j++;
  }
  cout << j;
}
