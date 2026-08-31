#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, a = 1, b;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> b;
    if (a < b && k % b == 0) a = b;
  }
  cout << k / a;
}
