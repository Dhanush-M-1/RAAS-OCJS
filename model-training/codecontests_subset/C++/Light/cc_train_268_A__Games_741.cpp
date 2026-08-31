#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int h[n];
  int a[n];
  int k = 0;
  for (int i = 0; i < n; i++) {
    cin >> h[i] >> a[i];
  }
  for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
      if (h[i] == a[j]) {
        k = k + 1;
      }
      if (h[j] == a[i]) {
        k = k + 1;
      }
    }
  }
  cout << endl << k;
}
