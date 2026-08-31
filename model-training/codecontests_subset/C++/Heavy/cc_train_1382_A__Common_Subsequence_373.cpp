#include <bits/stdc++.h>
using namespace std;
int main(int argc, const char* argv[]) {
  std::ios::sync_with_stdio(false);
  cout << fixed << setprecision(12);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  for (int k = 0; k < t; k++) {
    vector<bool> nums(1010, 0);
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
      int aux;
      cin >> aux;
      nums[aux] = 1;
    }
    bool ok = false;
    for (int i = 0; i < m; i++) {
      int aux;
      cin >> aux;
      if (nums[aux] and !ok) {
        cout << "YES" << '\n';
        cout << 1 << ' ' << aux << '\n';
        ok = true;
      }
    }
    if (!ok) cout << "NO" << '\n';
  }
  return 0;
}
