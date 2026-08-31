#include <bits/stdc++.h>
using namespace std;
int n;
int pr(int p, int q) { return p * q / n * 10 + p * q % n; }
int main() {
  cin >> n;
  for (int i = 1; i < n; i++)
    for (int j = 1; j < n; j++) {
      cout << pr(i, j);
      if (j == n - 1)
        cout << "\n";
      else
        cout << " ";
    }
  return 0;
}
