#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  while (cin >> n) {
    int h[n], g[n];
    for (int i = 0; i < n; i++) {
      cin >> h[i] >> g[i];
    }
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j != i) {
          if (h[i] == g[j]) count++;
        }
      }
    }
    cout << count << endl;
  }
  return 0;
}
