#include <bits/stdc++.h>
using namespace std;
int main() {
  int count = 0;
  int num;
  string y;
  int x;
  bool flag = false;
  cin >> num;
  cin >> y;
  if (num < 11)
    cout << "0" << endl;
  else {
    for (int j = 0; j < y.length(); j++) {
      if (y.at(j) == '8') {
        flag = true;
        count++;
      }
    }
    if (flag == false)
      cout << "0" << endl;
    else {
      x = num / 11;
      if (x < count)
        cout << x << endl;
      else
        cout << count << endl;
    }
  }
  return 0;
}
