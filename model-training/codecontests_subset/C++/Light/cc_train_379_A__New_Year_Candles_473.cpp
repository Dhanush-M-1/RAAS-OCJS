#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int s = 0;
  while (n != 0) {
    s++;
    n--;
    if (s % m == 0) n++;
  }
  cout << s;
}
