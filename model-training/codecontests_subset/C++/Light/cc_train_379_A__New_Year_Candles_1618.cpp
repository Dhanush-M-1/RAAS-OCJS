#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, consumed = 0, time = 0;
  cin >> a >> b;
  while (a != 0) {
    a = a - 1;
    consumed++;
    time++;
    if (consumed == b) {
      a++;
      consumed = 0;
    }
  }
  cout << time << endl;
}
