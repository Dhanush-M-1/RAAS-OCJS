#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, mn = 1000000, b;
  cin >> n >> k;
  vector<int> v;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    if (k % a == 0) b = k / a;
    mn = min(mn, b);
  }
  cout << mn << endl;
}
