#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t, k = 0;
  cin >> t;
  vector<int> myv;
  map<int, int> mip;
  while (t--) {
    int a, b;
    cin >> a >> b;
    myv.push_back(a);
    mip[b]++;
  }
  for (int i = 0; i < myv.size(); i++) {
    k += mip[myv[i]];
  }
  cout << k;
  return 0;
}
