#include <bits/stdc++.h>
using namespace std;
int main() {
  int total, v, n;
  cin >> v >> n;
  total = v;
  while ((v / n) > 0) {
    total = total + v / n;
    v = v / n + v % n;
  }
  cout << total;
  return 0;
}
