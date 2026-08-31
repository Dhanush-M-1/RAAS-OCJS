#include <bits/stdc++.h>
using namespace std;
int a[105];
int main() {
  int n, k;
  cin >> n >> k;
  int j = 1000;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (k % a[i] == 0) {
      j = min(k / a[i], j);
    }
  }
  cout << j;
}
