#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i;
  cin >> n;
  vector<int> a, b, c;
  for (int i = 0; i < n; ++i) {
    int tmp;
    cin >> tmp;
    a.push_back(tmp);
  }
  for (int i = 0; i < n - 1; ++i) {
    int tmp;
    cin >> tmp;
    b.push_back(tmp);
  }
  for (int i = 0; i < n - 2; ++i) {
    int tmp;
    cin >> tmp;
    c.push_back(tmp);
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  i = 0;
  while (1) {
    if (i >= b.size()) {
      cout << a[i] << endl;
      break;
    }
    if (a[i] == b[i])
      i++;
    else {
      cout << a[i] << endl;
      break;
    }
  }
  i = 0;
  while (1) {
    if (i >= c.size()) {
      cout << b[i] << endl;
      break;
    }
    if (b[i] == c[i])
      i++;
    else {
      cout << b[i];
      break;
    }
  }
}
