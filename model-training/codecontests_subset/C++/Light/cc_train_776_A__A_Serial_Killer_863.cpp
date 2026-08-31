#include <bits/stdc++.h>
using namespace std;
int main() {
  string a[100000], b[100000];
  cin >> a[0] >> b[0];
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i] >> b[i];
  }
  cout << a[0] << " " << b[0] << endl;
  for (int i = 1; i <= n; i++) {
    if (a[i] == a[i - 1]) {
      a[i] = b[i - 1];
      cout << a[i] << " " << b[i] << endl;
    } else if (a[i] == b[i - 1]) {
      a[i] = a[i - 1];
      cout << a[i] << " " << b[i] << endl;
    }
  }
}
