#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[100], b[100], c = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
  }
  for (int j = 0; j < n; j++) {
    for (int k = 0; k < n; k++) {
      if (a[j] == b[k] && k != j) c++;
    }
  }
  cout << c;
  return 0;
}
