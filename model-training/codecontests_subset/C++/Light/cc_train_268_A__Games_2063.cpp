#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, g(0);
  cin >> n;
  int uni[n][2];
  for (int i = 0; i < n; i++) {
    cin >> uni[i][0] >> uni[i][1];
  }
  for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
      if (uni[i][0] == uni[j][1]) g++;
      if (uni[i][1] == uni[j][0]) g++;
    }
  }
  cout << g;
  return 0;
}
