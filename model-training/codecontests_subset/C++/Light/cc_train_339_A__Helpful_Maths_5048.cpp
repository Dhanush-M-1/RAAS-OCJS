#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  string x;
  cin >> x;
  sort(x.begin(), x.end());
  for (int i = 0; i < x.size(); ++i) {
    if (isdigit(x[i])) {
      if (i != x.size() - 1) {
        cout << x[i] << "+";
      } else {
        cout << x[i];
      }
    }
  }
  return 0;
}
