#include <bits/stdc++.h>
using namespace std;
int main() {
  std::ios_base::sync_with_stdio(0);
  cin.tie(NULL), cout.tie(NULL);
  string x, y;
  cin >> x;
  for (int i = 0; i < x.size(); i++) {
    if (x[i] != '+') y += x[i];
  }
  sort(y.begin(), y.end());
  for (int i = 0; i < y.size(); i++) {
    if (i == y.size() - 1) {
      cout << y[i];
      break;
    }
    cout << y[i] << "+";
  }
  cout << endl;
  return 0;
}
