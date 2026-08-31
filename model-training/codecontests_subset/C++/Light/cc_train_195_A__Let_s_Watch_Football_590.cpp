#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int ans = c * (a - b);
  cout << ceil((double)ans / (double)b) << "\n";
}
