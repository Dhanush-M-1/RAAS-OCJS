#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, a;
  cin >> n >> c;
  int mx = 0, cur = 0;
  for (int i = 0; i < n; i++) {
    cin >> a;
    if (cur - a - c > mx) mx = cur - a - c;
    cur = a;
  }
  cout << mx;
}
