#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, number = 0;
  cin >> n;
  vector<int> a(n), b(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
    for (int j = 0; j < n; j++) {
      if (a[i] == b[j]) {
        number++;
      }
      if (a[j] == b[i]) {
        number++;
      }
    }
  }
  cout << number << endl;
  return 0;
}
