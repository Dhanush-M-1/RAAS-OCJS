#include <bits/stdc++.h>
using namespace std;
int main() {
  string a;
  int n, i;
  cin >> a >> n;
  for (i = 0; i < a.length(); i++) {
    if (a[i] >= 'A' && a[i] <= 'Z') a[i] = a[i] - 'A' + 'a';
    if (int(a[i]) < 97 + n) a[i] = a[i] - 'a' + 'A';
  }
  cout << a;
}
