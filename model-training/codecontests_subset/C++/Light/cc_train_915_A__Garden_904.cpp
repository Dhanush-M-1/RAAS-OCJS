#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int s, h = 0;
  for (int i = 0; i < n; i++) {
    cin >> s;
    if (k % s == 0 && s > h) h = s;
  }
  cout << k / h << endl;
}
