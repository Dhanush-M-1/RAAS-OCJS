#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  vector<int> num;
  num.resize(n);
  for (int i = 0; i < num.size(); i++) cin >> num[i];
  int maxi = 0;
  for (int i = 0; i < num.size() - 1; i++) {
    maxi = max(maxi, num[i] - num[i + 1] - c);
  }
  cout << maxi << endl;
  return 0;
}
