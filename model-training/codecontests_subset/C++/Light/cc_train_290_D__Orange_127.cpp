#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, x;
  string a;
  cin >> a >> x;
  for (i = 0; i < a.size(); i++)
    if (a[i] <= 'Z') a[i] = a[i] - 'A' + 'a';
  for (i = 0; i < a.size(); i++)
    if (a[i] - 'a' < x)
      cout << char(a[i] - 'a' + 'A');
    else
      cout << a[i];
  cout << endl;
}
