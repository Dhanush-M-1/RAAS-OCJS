#include <bits/stdc++.h>
using namespace std;
char b;
string hagia(int n, int l, string a) {
  while (n > 0) {
    b = n % l + '0';
    a = b + a;
    n /= l;
  }
  return a;
}
int main() {
  int l;
  string a = "";
  cin >> l;
  for (int i = 1; i < l; i++) {
    for (int j = 0; j < l; j++) {
      int num = i * j;
      cout << hagia(i * j, l, a) << " ";
      a = "";
    }
    cout << "\n";
  }
  return 0;
}
