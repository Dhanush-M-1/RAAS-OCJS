#include <bits/stdc++.h>
using namespace std;
#pragma warning(disable : 4996)
int main() {
  int n, check1 = 0, check2 = 0;
  char a[3];
  char b[3];
  scanf("%s", a);
  cin >> n;
  for (int j = 0; j < n; j++) {
    scanf("%s", b);
    if (a[1] == b[0]) check1 = 1;
    if (a[0] == b[1]) check2 = 1;
    if (a[0] == b[0] && b[1] == a[1]) {
      check1 = 1;
      check2 = 1;
    }
  }
  if (check1 == 1 && check2 == 1)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
}
