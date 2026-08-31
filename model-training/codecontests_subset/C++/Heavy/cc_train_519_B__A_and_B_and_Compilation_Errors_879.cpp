#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<long int> a(n);
  vector<long int> b(n - 1);
  vector<long int> c(n - 2);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  int misa, misb;
  for (int i = 0; i < a.size(); i++) {
    if (i == n - 1) {
      misa = a[i];
    } else if (a[i] != b[i]) {
      misa = a[i];
      break;
    }
  }
  for (int i = 0; i < b.size(); i++) {
    if (i == n - 2) {
      misb = b[i];
    } else if (b[i] != c[i]) {
      misb = b[i];
      break;
    }
  }
  cout << misa << endl << misb << endl;
}
