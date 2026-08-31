#include <bits/stdc++.h>
using namespace std;
string a, ans;
int b;
string c;
int main() {
  while (cin >> a >> b) {
    for (int i = 0; i < a.size(); i++)
      if (a[i] >= 'A' && a[i] <= 'Z') a[i] = a[i] - 'A' + 'a';
    for (int i = 0; i < a.size(); i++) {
      if ((int)a[i] < b + 97) {
        a[i] = a[i] - 'a' + 'A';
      }
    }
    cout << a << endl;
  }
  return 0;
}
