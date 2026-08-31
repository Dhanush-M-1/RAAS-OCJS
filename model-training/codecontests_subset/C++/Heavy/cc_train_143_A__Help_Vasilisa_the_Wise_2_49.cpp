#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  float a[4] = {0};
  a[2] = (r2 + c1 - d1) / 2;
  int flag = 0;
  if (a[2] != floor(a[2]) || a[2] <= 0 || a[2] >= 10)
    cout << -1 << endl;
  else {
    a[3] = r2 - a[2];
    if (a[3] == a[2] || a[3] <= 0 || a[3] >= 10)
      cout << -1 << endl;
    else {
      a[0] = d1 - a[3];
      if (a[0] == a[2] || a[0] == a[3] || a[0] <= 0 || a[0] >= 10)
        cout << -1 << endl;
      else {
        a[1] = r1 - a[0];
        if (a[1] == a[0] || a[1] == a[2] || a[1] == a[3] || a[1] <= 0 ||
            a[1] >= 10)
          cout << -1 << endl;
        else {
          flag = 1;
        }
      }
    }
  }
  if (flag == 1)
    cout << a[0] << " " << a[1] << endl << a[2] << " " << a[3] << endl;
  return 0;
}
