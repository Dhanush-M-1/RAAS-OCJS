#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, one = 0, two = 0, sum = 0;
  cin >> n;
  vector<int> v(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i];
  }
  for (int nn = 0; nn < n; nn++) {
    sum += v[nn];
    if (v[nn] == 100) {
      one += 1;
    } else {
      two += 1;
    }
  }
  if (sum % 200 != 0) {
    cout << "NO" << endl;
  } else if (sum % 200 == 0 && one == 0) {
    if (two % 2 == 0) {
      cout << "YES" << endl;
    } else {
      cout << "NO" << endl;
    }
  } else {
    cout << "YES" << endl;
  }
}
