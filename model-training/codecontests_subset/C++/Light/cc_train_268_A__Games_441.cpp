#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, s, count1 = 0;
  cin >> n;
  int g[2 * n];
  int host[n];
  int guest[n];
  for (int i = 0; i < 2 * n; i++) {
    cin >> s;
    g[i] = s;
  }
  for (int i = 0; i < 2 * n; i++) {
    for (int j = 1; j < 2 * n; j++) {
      if (j % 2 == 1 && i % 2 == 0) {
        if (g[i] == g[j]) count1 += 1;
      }
    }
  }
  cout << count1;
}
