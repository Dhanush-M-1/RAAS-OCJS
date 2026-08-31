#include <bits/stdc++.h>
using namespace std;
int main() {
  int *h, *g, n = 0, countx = 0;
  cin >> n;
  h = new int[n];
  g = new int[n];
  for (int i = 0; i < n; i++) {
    cin >> h[i] >> g[i];
  }
  for (int i = 0; i < n; i++)
    for (int a = 0; a < n; a++)
      if (g[i] == h[a]) countx++;
  cout << countx << endl;
  return 0;
}
