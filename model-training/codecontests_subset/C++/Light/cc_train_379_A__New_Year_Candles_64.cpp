#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, sum = 0, t = 0;
  cin >> a >> b;
  while (a) {
    if (++t % b != 0) a--;
    sum++;
  }
  cout << sum << endl;
  return 0;
}
