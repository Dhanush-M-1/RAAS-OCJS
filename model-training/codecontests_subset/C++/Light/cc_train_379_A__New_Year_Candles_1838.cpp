#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, q = 0, time = 0, k;
  cin >> a >> b;
  k = a;
  while (k != 0) {
    k--;
    q++;
    time++;
    if (q == b) {
      k++;
      q = 0;
    }
  }
  cout << time;
}
