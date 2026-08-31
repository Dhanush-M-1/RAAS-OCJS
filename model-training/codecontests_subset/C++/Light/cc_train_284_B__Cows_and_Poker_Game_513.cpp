#include <bits/stdc++.h>
using namespace std;
const int N = 5;
int a[N];
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int ii = 0, aa = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'I') ii++;
    if (s[i] == 'A') aa++;
  }
  if (ii > 1) cout << 0 << endl;
  if (ii == 1) cout << 1 << endl;
  if (ii == 0) cout << aa << endl;
  return 0;
}
