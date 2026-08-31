#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int a[3] = {0, 0, 0}, n, temp;
  cin >> n;
  for (int i = 0; i < 3; ++i) {
    for (int j = 0; j < n - i; ++j) {
      cin >> temp;
      a[i] += temp;
    }
  }
  cout << a[0] - a[1] << endl << a[1] - a[2] << endl;
  return 0;
}
