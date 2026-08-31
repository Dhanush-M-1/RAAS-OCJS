#include <bits/stdc++.h>
using namespace std;
int main() {
  char a[100];
  int x;
  cin >> a >> x;
  int l = strlen(a);
  int i;
  for (i = 0; i < l; i++) {
    if (a[i] < 97) a[i] += 32;
    if (a[i] < 97 + x) a[i] -= 32;
  }
  cout << a << endl;
  return 0;
}
