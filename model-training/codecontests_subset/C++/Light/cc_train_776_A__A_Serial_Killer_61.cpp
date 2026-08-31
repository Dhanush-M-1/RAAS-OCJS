#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b;
  int n;
  cin >> a >> b >> n;
  string a1[n], b1[n], sol[n + 1], sol1[n + 1];
  sol[0] = a;
  sol1[0] = b;
  for (int i = 0; i < n; i++) {
    cin >> a1[i] >> b1[i];
    if (i == 0) {
      if (a1[i] == a) {
        sol[i + 1] = b1[i];
        sol1[i + 1] = b;
      } else if (a1[i] == b) {
        sol[i + 1] = a;
        sol1[i + 1] = b1[i];
      }
    } else {
      if (a1[i] == sol[i]) {
        sol[i + 1] = b1[i];
        sol1[i + 1] = sol1[i];
      } else {
        sol1[i + 1] = b1[i];
        sol[i + 1] = sol[i];
      }
    }
  }
  for (int u = 0; u < n + 1; u++) {
    cout << sol[u] << " " << sol1[u] << "\n";
  }
}
