#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c = 0;
  cin >> n;
  int a[n], h[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> h[i];
    for (int j = 0; j <= i; j++) {
      if (a[j] == h[i]) {
        c++;
      }
      if (h[j] == a[i]) c++;
    }
  }
  cout << c;
}
