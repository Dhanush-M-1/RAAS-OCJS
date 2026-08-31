#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
vector<int> bckt;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, k, a, b = 0;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a;
    bckt.push_back(a);
  }
  sort(bckt.begin(), bckt.end());
  for (int i = 0; i < n; i++) {
    if (k % bckt[i] == 0) {
      b = bckt[i];
    }
  }
  cout << k / b;
  return 0;
}
