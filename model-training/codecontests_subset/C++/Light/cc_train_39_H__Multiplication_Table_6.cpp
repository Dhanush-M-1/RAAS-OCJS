#include <bits/stdc++.h>
using namespace std;
void base(int n, int k) {
  vector<int> vt;
  while (n) {
    vt.push_back(n % k);
    n /= k;
  }
  reverse(vt.begin(), vt.end());
  for (int i = 0; i < vt.size(); i++) {
    cout << vt[i];
  }
  cout << " ";
}
int main() {
  int n;
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      base(i * j, n);
    }
    cout << endl;
  }
  cout << endl;
}
