#include <bits/stdc++.h>
using namespace std;
int main() {
  string a;
  int b;
  cin >> a >> b;
  for (int i = 0; i < a.length(); i++) {
    a[i] = (a[i] >= 'a' && a[i] <= 'z') ? a[i] : a[i] - 'A' + 'a';
  }
  for (int i = 0; i < a.length(); i++) {
    int t = a[i];
    if (t < b + 97) {
      a[i] = (a[i] >= 'A' && a[i] <= 'Z') ? a[i] : a[i] - 'a' + 'A';
    } else {
      a[i] = (a[i] >= 'a' && a[i] <= 'z') ? a[i] : a[i] - 'A' + 'a';
    }
  }
  cout << a << endl;
  return 0;
}
