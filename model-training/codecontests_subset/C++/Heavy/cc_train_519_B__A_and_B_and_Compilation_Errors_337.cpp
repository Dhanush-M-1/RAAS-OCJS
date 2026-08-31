#include <bits/stdc++.h>
using namespace std;
int main() {
  int a;
  cin >> a;
  vector<int> b(a);
  vector<int> c(a - 1);
  vector<int> d(a - 2);
  for (int i = 0; i < b.size(); i++) {
    cin >> b[i];
  }
  for (int i = 0; i < c.size(); i++) {
    cin >> c[i];
  }
  for (int i = 0; i < d.size(); i++) {
    cin >> d[i];
  }
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  sort(d.begin(), d.end());
  bool x = false;
  for (int i = 0; i < c.size(); i++) {
    if (b[i] != c[i]) {
      cout << b[i] << "\n";
      x = true;
      break;
    }
  }
  if (!x) cout << b[b.size() - 1] << "\n";
  x = false;
  for (int i = 0; i < d.size(); i++) {
    if (c[i] != d[i]) {
      cout << c[i] << "\n";
      x = true;
      break;
    }
  }
  if (!x) cout << c[c.size() - 1] << "\n";
}
