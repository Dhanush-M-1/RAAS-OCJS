#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, rent, MAX = 0;
  cin >> n >> rent;
  vector<int> v(n);
  cin >> v[0];
  for (int i = 1; i < n; i++) {
    cin >> v[i];
    MAX = max(MAX, v[i - 1] - v[i] - rent);
  }
  cout << MAX << endl;
  return 0;
}
