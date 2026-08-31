#include <bits/stdc++.h>
using namespace std;
int ans;
int a = 0, b = 0, l;
int z1, z2;
int f = 0;
int main() {
  cout << "? 0 0" << endl;
  cin >> ans;
  if (ans == 1)
    f = 1;
  else if (ans == -1)
    f = 2;
  l++;
  for (int i = 29; i >= 0; i--) {
    cout << "? " << a + (1 << i) << " " << b << endl;
    l++;
    l++;
    cin >> z1;
    l++;
    cout << "? " << a << " " << b + (1 << i) << endl;
    l++;
    cin >> z2;
    l++;
    if (z1 == -1 && z2 == 1) {
      a += (1 << i);
      b += (1 << i);
      l++;
    } else if (z1 == 1 && z2 == -1) {
      continue;
    } else if (f == 1) {
      a += (1 << i);
      if (z1 == -1)
        f = 2;
      else if (z1 == 1)
        f = 1;
      else
        f = 0;
      l++;
    } else if (f == 2) {
      b += (1 << i);
      if (z2 == 1)
        f = 1;
      else if (z2 == -1)
        f = 2;
      else
        f = 0;
      l++;
    }
    l++;
  }
  cout << "! " << a << " " << b << endl;
  return 0;
}
