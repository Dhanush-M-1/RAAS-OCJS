#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int n;
  cin >> n;
  vector<int> a(n, 0);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  vector<int> b(n - 1, 0);
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
  }
  vector<int> c(n - 2, 0);
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
  }
  int firstPass = 0;
  for (int i = 0; i < a.size(); i++) {
    firstPass ^= a[i];
  }
  for (int i = 0; i < b.size(); i++) {
    firstPass ^= b[i];
  }
  int secondPass = 0;
  for (int i = 0; i < a.size(); i++) {
    secondPass ^= a[i];
  }
  secondPass ^= firstPass;
  for (int i = 0; i < c.size(); i++) {
    secondPass ^= c[i];
  }
  cout << firstPass << endl << secondPass;
  return 0;
}
