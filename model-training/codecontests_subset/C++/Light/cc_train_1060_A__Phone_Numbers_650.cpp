#include <bits/stdc++.h>
using namespace std;
int main() {
  float n;
  cin >> n;
  int x = 0;
  string r;
  cin >> r;
  for (int i = 0; i < n; i++) {
    if (r[i] == '8') x++;
  }
  int k = floor(n / 11);
  cout << min(k, x);
  return 0;
}
