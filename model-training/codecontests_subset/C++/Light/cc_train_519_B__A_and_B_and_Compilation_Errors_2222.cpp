#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> v(n);
  for (auto &i : v) cin >> i;
  int x = v[0];
  int temp;
  for (int i = 1; i < n; i++) x = x ^ v[i];
  int y = x;
  for (int i = 0; i < n - 1; i++) {
    cin >> temp;
    y = y ^ temp;
  }
  int first = y;
  cout << first << endl;
  y = x;
  for (int i = 0; i < n - 2; i++) {
    cin >> temp;
    y = y ^ temp;
  }
  int second = y ^ first;
  cout << second << endl;
  return 0;
}
