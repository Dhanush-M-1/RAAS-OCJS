#include <bits/stdc++.h>
using namespace std;
using ull = unsigned long long;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, k;
  cin >> n >> k;
  int mh = k;
  for (int i = 0; i < n; ++i) {
    int bs;
    cin >> bs;
    if (k % bs == 0) {
      mh = min(mh, k / bs);
    }
  }
  cout << mh << '\n';
  return 0;
}
