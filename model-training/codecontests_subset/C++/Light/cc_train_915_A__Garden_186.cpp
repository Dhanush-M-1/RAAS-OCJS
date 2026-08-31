#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, i, j, ar[1000];
  cin >> n >> m;
  for (i = 0; i < n; i++) {
    cin >> ar[i];
  }
  sort(ar, ar + n);
  for (j = n - 1; j >= 0; j--) {
    if (m % ar[j] == 0) {
      cout << m / ar[j] << endl;
      break;
    }
  }
}
