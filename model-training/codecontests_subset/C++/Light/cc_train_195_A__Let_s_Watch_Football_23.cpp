#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int tdata = a * c;
  int down = b;
  int ttime = c;
  int extra = tdata / b;
  int newt = extra - c;
  int newt1 = tdata - newt * b;
  if (newt1 % b == 0) {
    cout << newt;
  } else {
    cout << newt + 1;
  }
}
