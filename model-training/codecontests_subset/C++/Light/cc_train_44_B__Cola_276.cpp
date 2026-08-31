#include <bits/stdc++.h>
using namespace std;
int main() {
  cout << fixed;
  cout.precision(9);
  int n, A, B, C;
  cin >> n >> A >> B >> C;
  n *= 2;
  int r = 0;
  for (int c = 0; c <= C && 4 * c <= n; c++)
    for (int b = 0; b <= B && 2 * b + 4 * c <= n; b++) {
      if (n - 2 * b - 4 * c <= A) r++;
    }
  cout << r << endl;
  return 0;
}
