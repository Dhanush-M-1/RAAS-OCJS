#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, i = 0;
  cin >> a >> b;
  while (a != 0) {
    a--;
    i++;
    if (i % b == 0) a++;
  }
  cout << i << endl;
}
