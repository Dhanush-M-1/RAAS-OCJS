#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, m;
  cin >> n >> k;
  m = k;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    if (k % a == 0) {
      if (k / a < m) m = k / a;
    }
  }
  cout << m;
}
