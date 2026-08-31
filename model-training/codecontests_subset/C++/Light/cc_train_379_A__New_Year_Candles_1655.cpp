#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int c = 0;
  while (n != 0) {
    ++c;
    n--;
    if (c % m == 0) n++;
  }
  cout << c;
  return 0;
}
