#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int t;
  cin >> t;
  while (t-- > 0) {
    int n;
    cin >> n;
    vector<int> a(n);
    for (int& v : a) cin >> v;
    if (a[0] + a[1] > a[n - 1])
      cout << "-1\n";
    else
      cout << "1 2 " << n << '\n';
  }
  return 0;
}
