#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int i, j, cl = 0;
  int h[n], a[n];
  for (i = 0; i < n; i++) {
    cin >> h[i] >> a[i];
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (h[i] == a[j]) cl++;
    }
  }
  cout << cl;
}
