#include <bits/stdc++.h>
using namespace std;
int main() {
  int io = 0, ao = 0, showerCows = 0, n;
  cin >> n;
  vector<char> v(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i];
    if (v[i] == 'I') io++;
    if (v[i] == 'A') ao++;
  }
  if (io == 1) {
    cout << "1";
    return 0;
  }
  if (io > 1) {
    cout << "0";
    return 0;
  }
  cout << ao;
}
