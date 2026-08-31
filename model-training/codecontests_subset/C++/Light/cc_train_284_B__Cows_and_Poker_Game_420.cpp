#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ca = 0, cf = 0, ci = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    char s;
    cin >> s;
    if (s == 'F') cf++;
    if (s == 'I') ci++;
    if (s == 'A') ca++;
  }
  if (ci == 0) cout << ca;
  if (ci == 1) cout << 1;
  if (ci > 1) cout << 0;
  return 0;
}
