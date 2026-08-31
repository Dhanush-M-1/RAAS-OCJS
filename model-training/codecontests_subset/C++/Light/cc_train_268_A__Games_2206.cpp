#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, count{0};
  cin >> n;
  int h[n], g[n];
  for (i = 0; i < n; i++) {
    cin >> h[i] >> g[i];
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (h[i] == g[j]) count++;
    }
  }
  cout << count << endl;
}
