#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  vector<int> ve;
  for (int i = 0; i < n; i++) {
    int x;
    scanf("%d", &x);
    ve.push_back(x);
  }
  vector<int> res;
  for (int i = 0; i < n; i++) {
    res.push_back(min(ve[i] - 1, (int)1e6 - ve[i]));
  }
  cout << *max_element(res.begin(), res.end()) << endl;
  return 0;
}
