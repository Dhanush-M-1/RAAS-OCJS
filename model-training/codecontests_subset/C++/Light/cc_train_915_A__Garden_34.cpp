#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, w[110], mn = 1000;
  cin >> n >> k;
  for (int i = 0; i < n; i++) cin >> w[i];
  for (int i = 0; i < n; i++)
    if (k % w[i] == 0) mn = min(mn, (k / w[i]));
  cout << mn << endl;
  return 0;
}
