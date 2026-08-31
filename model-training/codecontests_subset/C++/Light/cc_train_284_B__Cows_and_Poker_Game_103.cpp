#include <bits/stdc++.h>
using namespace std;
int main() {
  char s;
  int i, j, n, all, in, fold, c, d;
  all = 0;
  in = 0;
  fold = 0;
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> s;
    if (s == 'A') all++;
    if (s == 'I') in++;
    if (s == 'F') fold++;
  }
  if (in == 0)
    cout << all;
  else if (in == 1)
    cout << 1;
  else
    cout << 0;
  return 0;
}
