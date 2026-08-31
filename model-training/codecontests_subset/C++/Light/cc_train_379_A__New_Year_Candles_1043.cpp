#include <bits/stdc++.h>
using namespace std;
void func() {
  int a, b;
  cin >> a >> b;
  int c = a, ost = 0;
  while (a) {
    ost += a;
    a = ost / b;
    ost = ost % b;
    c += a;
  }
  cout << c;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    func();
  }
  return 0;
}
