#include <bits/stdc++.h>
using namespace std;
long long a, b, c;
int main() {
  cin >> a >> b >> c;
  cout << ceil((double)a * c / b) - c;
  return 0;
}
