#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, count = 0, a, b = 0;
  cin >> n >> k;
  while (n != 0) {
    count = count + n;
    b = b + n;
    n = b / k;
    b = b % k;
  }
  cout << count;
  return 0;
}
