#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, ar[101], mx = 0;
  cin >> a >> b;
  for (int x = 0; x < a; x++) {
    cin >> ar[x];
  }
  for (int x = 0; x < a - 1; x++) {
    mx = max(mx, ar[x] - ar[x + 1] - b);
  }
  cout << mx;
  return 0;
}
