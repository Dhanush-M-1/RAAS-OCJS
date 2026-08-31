#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int r_max = 0;
  int temp, pre;
  cin >> pre;
  for (int i = 0; i < n - 1; ++i) {
    cin >> temp;
    r_max = max(r_max, pre - temp - c);
    pre = temp;
  }
  cout << r_max << endl;
  return 0;
}
