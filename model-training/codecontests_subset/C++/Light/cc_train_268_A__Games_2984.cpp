#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int h[n], a[n];
  int x = 0;
  for (int i = 0; i < n; i++) {
    cin >> h[i] >> a[i];
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (i != j) {
        if (a[i] == h[j]) {
          x++;
        }
      }
    }
  }
  cout << x << endl;
}
