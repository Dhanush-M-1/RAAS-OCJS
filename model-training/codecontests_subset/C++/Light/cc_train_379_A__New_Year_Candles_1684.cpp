#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a, b;
  cin >> a >> b;
  long long int res = a, temp;
  while (a >= b) {
    res += (a / b);
    a = a / b + a % b;
  }
  cout << res << "\n";
}
