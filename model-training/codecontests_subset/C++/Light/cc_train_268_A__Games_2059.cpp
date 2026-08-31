#include <bits/stdc++.h>
using namespace std;
int h[105], a[105];
int main() {
  int n;
  int x, y;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x >> y;
    h[x]++;
    a[y]++;
  }
  int count = 0;
  for (int i = 0; i < 105; i++) {
    count += h[i] * a[i];
  }
  cout << count;
  return 0;
}
