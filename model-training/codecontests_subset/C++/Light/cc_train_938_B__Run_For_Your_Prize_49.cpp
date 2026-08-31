#include <bits/stdc++.h>
using namespace std;
int n, p, k;
int main() {
  cin >> n;
  while (n--) {
    cin >> p;
    k = max(k, min(p - 1, 1000000 - p));
  }
  cout << k;
}
