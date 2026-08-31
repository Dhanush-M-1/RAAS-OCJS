#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int diff = 0;
  int ar[n];
  for (int i = 0; i < n; i++) {
    cin >> ar[i];
  }
  for (int i = 1; i < n; i++) {
    if (ar[i - 1] - ar[i] > diff) diff = ar[i - 1] - ar[i];
  }
  if (diff >= c)
    cout << diff - c;
  else
    cout << 0;
  return 0;
}
