#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, i, p, count = 0, count1 = 0;
  cin >> n;
  vector<long long int> a;
  vector<long long int> b;
  vector<long long int> c;
  for (i = 0; i < n; i++) {
    cin >> p;
    a.push_back(p);
  }
  sort(a.begin(), a.end());
  for (i = 0; i < n - 1; i++) {
    cin >> p;
    b.push_back(p);
  }
  sort(b.begin(), b.end());
  for (i = 0; i < n - 2; i++) {
    cin >> p;
    c.push_back(p);
  }
  sort(c.begin(), c.end());
  for (i = 0; i < n - 1; i++) {
    if (a[i] != b[i]) {
      count = 1;
      cout << a[i] << endl;
      break;
    }
  }
  if (count == 0) {
    cout << a[n - 1] << endl;
  }
  for (i = 0; i < n - 2; i++) {
    if (b[i] != c[i]) {
      count1 = 1;
      cout << b[i] << endl;
      break;
    }
  }
  if (count1 == 0) {
    cout << b[n - 2] << endl;
  }
  return 0;
}
