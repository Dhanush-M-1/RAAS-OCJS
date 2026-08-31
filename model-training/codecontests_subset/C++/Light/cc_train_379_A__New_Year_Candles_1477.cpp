#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, s = 0;
  cin >> n >> k;
  while (n >= k) s += n / k * k, n = n % k + n / k;
  cout << s + n;
  return 0;
}
