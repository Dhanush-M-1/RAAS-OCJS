#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, q, w;
  cin >> n;
  vector<int> a, b, c;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    a.push_back(x);
  }
  for (int i = 0; i < n - 1; i++) {
    int x;
    cin >> x;
    b.push_back(x);
  }
  for (int i = 0; i < n - 2; i++) {
    int x;
    cin >> x;
    c.push_back(x);
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  int z = 0;
  for (int i = 0; i < b.size(); i++) {
    if (a[i] != b[i]) {
      cout << a[i] << endl;
      z = 1;
      break;
    }
  }
  if (z == 0) cout << a[a.size() - 1] << endl;
  z = 0;
  for (int i = 0; i < c.size(); i++) {
    if (b[i] != c[i]) {
      cout << b[i] << endl;
      z = 1;
      break;
    }
  }
  if (z == 0) cout << b[b.size() - 1] << endl;
}
