#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int n1;
  int n2;
  while (cin >> n) {
    n1 = n2 = 0;
    int temp;
    bool flag = false;
    while (n--) {
      cin >> temp;
      if (temp == 100)
        ++n1;
      else
        ++n2;
    }
    if (n1 % 2)
      flag = false;
    else {
      n1 /= 2;
      if (n1 != 0)
        flag = true;
      else {
        if (n2 % 2)
          flag = false;
        else
          flag = true;
      }
    }
    if (flag)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
}
