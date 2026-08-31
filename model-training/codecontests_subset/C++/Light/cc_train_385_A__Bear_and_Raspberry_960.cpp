#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  vector<int> v1, v2;
  ;
  for (int i = 0; i < n; i++) {
    int j;
    cin >> j;
    v1.push_back(j);
  }
  for (int i = 0; i < n - 1; i++) {
    v2.push_back(v1[i] - v1[i + 1] - c);
  }
  sort(v2.begin(), v2.end());
  int j = (v2.back() > 0) ? (v2.back()) : 0;
  cout << j;
}
