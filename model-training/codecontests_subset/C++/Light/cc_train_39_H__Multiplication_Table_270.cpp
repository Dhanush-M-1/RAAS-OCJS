#include <bits/stdc++.h>
using namespace std;
string base(int x, int b) {
  string out = "";
  while (x) {
    out += (char)(x % b + '0');
    x /= b;
  }
  reverse(out.begin(), out.end());
  return out;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int n, i, j;
  cin >> n;
  for (i = 1; i < n; i++) {
    for (j = i; j < n * i; j += i) cout << base(j, n) << ' ';
    cout << "\n";
  }
  return 0;
}
