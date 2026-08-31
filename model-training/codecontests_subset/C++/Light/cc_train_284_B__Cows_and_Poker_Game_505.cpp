#include <bits/stdc++.h>
using namespace std;
int n, x = 0, javab = 0;
string a;
int main() {
  cin >> n >> a;
  for (int i = 0; i < (int)a.size(); i++)
    if (a[i] == 'I') x++;
  for (int i = 0; i < (int)a.size(); i++) {
    if (a[i] == 'A' && x <= 0)
      javab++;
    else if (a[i] == 'I' && x - 1 <= 0)
      javab++;
  }
  cout << javab << endl;
  return 0;
}
