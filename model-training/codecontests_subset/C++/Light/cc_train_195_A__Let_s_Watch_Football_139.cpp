#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int x = (a * c) - (b * c);
  cout << ceil(float(x) / b) << endl;
}
