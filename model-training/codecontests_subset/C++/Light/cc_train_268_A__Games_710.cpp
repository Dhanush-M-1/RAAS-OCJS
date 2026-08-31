#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<vector<int>> v;
  vector<int> temp(2);
  while (n--) {
    cin >> temp[0] >> temp[1];
    v.push_back(temp);
  }
  int sum = 0;
  for (int i = 0; i < v.size(); i++) {
    for (int j = 0; j < v.size(); j++) {
      if (i == j) {
        continue;
      }
      if (v[i][1] == v[j][0]) {
        sum++;
      }
    }
  }
  cout << sum;
}
