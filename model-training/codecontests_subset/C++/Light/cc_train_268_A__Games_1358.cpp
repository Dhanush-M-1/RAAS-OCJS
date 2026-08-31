#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n], b[n];
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    cin >> b[i];
  }
  int count = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      if (a[i] == b[j] && i != j) {
        count++;
      }
    }
  }
  cout << count;
  return 0;
}
