#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b;
  int n;
  cin >> a >> b >> n;
  cout << a << " " << b << endl;
  string k, r;
  for (int i = 0; i < n; i++) {
    cin >> k >> r;
    if (a == k)
      a = r;
    else
      b = r;
    cout << a << " " << b << endl;
  }
  return 0;
}
