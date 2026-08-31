#include <bits/stdc++.h>
using namespace std;
const long long mod = (long long)1e9 + 7;
int main() {
  ios_base ::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int n, c;
  cin >> n >> c;
  vector<int> v(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i];
  }
  int mx = 0;
  for (int i = 1; i < n; i++) {
    mx = max(mx, (v[i - 1] - v[i] - c));
  }
  cout << mx;
  return 0;
}
