#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  string second;
  cin >> n >> second;
  int i;
  int p = 0;
  for (i = 0; i < n; i++) {
    if (second[i] == '8') p++;
  }
  int m = (n - p) / 10;
  if (p > m) {
    cout << n / 11;
  } else
    cout << min(p, m);
  return 0;
}
