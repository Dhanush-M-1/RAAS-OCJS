#include <bits/stdc++.h>
using namespace std;
void return_print(string x);
int main() {
  string a;
  int len, b;
  getline(cin, a);
  cin >> b;
  len = a.size();
  for (int i = 0; i < len; i++) {
    if (a[i] >= 'A' && a[i] <= 'Z') a[i] = 'a' + a[i] - 'A';
    if ((a[i] - 'a' + 1) <= b) a[i] = 'A' + a[i] - 'a';
  }
  cout << a;
  return 0;
}
