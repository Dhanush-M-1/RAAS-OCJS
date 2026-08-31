#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  vector<int> va;
  vector<int> vb;
  vector<int> vab;
  int n, k, a, b, t;
  cin >> n >> k;
  for (int p = 0; p < n; p++) {
    cin >> t >> a >> b;
    if (a == 1 && b == 1)
      vab.push_back(t);
    else if (a == 0 && b == 1)
      vb.push_back(t);
    else if (a == 1 && b == 0)
      va.push_back(t);
  }
  sort(va.begin(), va.end());
  int na = va.size();
  sort(vb.begin(), vb.end());
  int nb = vb.size();
  int nab = vab.size();
  sort(vab.begin(), vab.end());
  int ans = 0;
  int p = 0;
  int ai = 0;
  int bi = 0;
  int abi = 0;
  while (p < k) {
    if (ai < na && bi < nb && abi < nab) {
      if (va[ai] + vb[bi] <= vab[abi]) {
        ans = ans + va[ai] + vb[bi];
        ai++;
        bi++;
      } else {
        ans = ans + vab[abi];
        abi++;
      }
      p++;
    } else if (ai < na && bi < nb && abi >= nab) {
      ans = ans + va[ai] + vb[bi];
      ai++;
      bi++;
      p++;
    } else if ((ai >= na || bi >= nb) && abi < nab) {
      ans = ans + vab[abi];
      abi++;
      p++;
    } else
      break;
  }
  if (p == k)
    cout << ans;
  else
    cout << -1;
}
