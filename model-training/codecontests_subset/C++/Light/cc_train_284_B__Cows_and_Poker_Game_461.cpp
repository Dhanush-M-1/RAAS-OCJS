#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, a = 0, f = 0, ii = 0, ans = 0;
  cin >> n;
  char *arr = new char[n];
  for (i = 0; i < n; i++) cin >> arr[i];
  for (i = 0; i < n; i++) {
    if (arr[i] == 'A')
      a++;
    else if (arr[i] == 'F')
      f++;
    else
      ii++;
  }
  if (ii > 1) {
    cout << "0" << endl;
    return 0;
  } else if (ii == 0) {
    cout << a << endl;
    return 0;
  } else if (ii == 1) {
    cout << "1" << endl;
    return 0;
  }
  return 0;
}
