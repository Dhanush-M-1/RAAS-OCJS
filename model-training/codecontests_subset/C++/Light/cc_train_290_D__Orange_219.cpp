#include <bits/stdc++.h>
using namespace std;
int main() {
  string a;
  int n;
  cin >> a >> n;
  int l = a.size();
  for (int i = 0; i < l; ++i) a[i] = tolower(a[i]);
  for (int i = 0; i < l; ++i) {
    int buff = a[i];
    if (buff < n + 97) a[i] = toupper(a[i]);
  }
  cout << a << endl;
  return 0;
}
