#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  if ((a * c) % b != 0)
    cout << (((a * c) / b) - c) + 1;
  else
    cout << ((a * c) / b) - c;
}
