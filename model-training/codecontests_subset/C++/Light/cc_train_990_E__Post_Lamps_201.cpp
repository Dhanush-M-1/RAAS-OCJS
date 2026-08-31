#include <bits/stdc++.h>
using namespace std;
bool block[1000005];
int blockst[1000005];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m, k;
  cin >> n >> m >> k;
  vector<int> blocked(m);
  int len = 1;
  int mxlen = 1;
  if (m == 0) {
    mxlen = 0;
  }
  for (int i = 0; i < m; i++) {
    cin >> blocked[i];
    block[blocked[i]] = true;
    if (i > 0) {
      if (blocked[i] - blocked[i - 1] == 1) {
        len++;
        blockst[blocked[i]] = blockst[blocked[i - 1]];
        if (len >= k) {
          cout << -1;
          return 0;
        }
        mxlen = max(mxlen, len);
      } else {
        blockst[blocked[i]] = blocked[i] - 1;
        len = 1;
      }
    } else {
      blockst[blocked[i]] = blocked[i] - 1;
    }
  }
  if (block[0]) {
    cout << -1;
    return 0;
  }
  vector<long long int> costs(k + 1);
  for (int i = 1; i <= k; i++) {
    cin >> costs[i];
  }
  long long int mncost = 9223372036854775807LL;
  for (int siz = mxlen + 1; siz <= k; siz++) {
    long long int used = 0;
    for (int pos = 0; pos < n; pos += siz) {
      if (block[pos]) {
        pos = blockst[pos];
      }
      used += costs[siz];
      if (used >= mncost) {
        break;
      }
    }
    mncost = min(mncost, used);
  }
  if (mncost == 9223372036854775807LL) {
    cout << -1;
    return 0;
  }
  cout << mncost;
  return 0;
}
