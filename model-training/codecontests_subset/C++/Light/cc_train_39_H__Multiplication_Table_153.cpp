#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j;
  cin >> n;
  for (i = 1; i < n; i++) {
    for (j = 1; j < n; j++) {
      if (j == 1)
        cout << i;
      else if (i * j / n == 0)
        cout << "  " << i * j % n;
      else
        cout << " " << i * j / n << i * j % n;
    }
    cout << endl;
  }
}
