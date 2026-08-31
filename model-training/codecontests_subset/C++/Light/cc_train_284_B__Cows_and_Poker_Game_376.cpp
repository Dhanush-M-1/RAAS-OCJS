#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int a[3] = {0};
  cin >> n;
  char c;
  for (int i = 0; i < n; i++) {
    cin >> c;
    if (c == 'A') a[0]++;
    if (c == 'I') a[1]++;
  }
  if (a[1] == 0) {
    cout << a[0];
  } else if (a[1] == 1)
    cout << 1;
  else if (a[1] > 1)
    cout << 0;
  return 0;
}
