#include <bits/stdc++.h>
using namespace std;
const int M = 998244353;
vector<int> both, al, bob;
int k;
int good(int cnt, int mi, int ma) {
  if (cnt > mi && (both[cnt - 1] > al[k - cnt] + bob[k - cnt])) return -1;
  if (cnt < ma && (both[cnt] < al[k - cnt - 1] + bob[k - cnt - 1])) return 1;
  return 0;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int n;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    int t, a, b;
    cin >> t >> a >> b;
    if (a && b)
      both.push_back(t);
    else if (a)
      al.push_back(t);
    else if (b)
      bob.push_back(t);
  }
  sort(both.begin(), both.end());
  sort(al.begin(), al.end());
  sort(bob.begin(), bob.end());
  if ((int)min(al.size(), bob.size()) + both.size() < k)
    cout << -1 << "\n";
  else {
    int mi = max(0, k - (int)min(al.size(), bob.size())),
        ma = min(k, (int)both.size());
    int i = mi, j = ma;
    int res = -1;
    while (j - i > 1) {
      int mid = (i + j) >> 1;
      int g = good(mid, mi, ma);
      if (g < 0) j = mid;
      if (g > 0) i = mid;
      if (g == 0) {
        res = mid;
        break;
      }
    }
    if (res < 0) {
      if (good(j, mi, ma) == 0)
        res = j;
      else
        res = i;
    }
    long long sol = 0;
    for (i = 0; i < res; i++) sol += both[i];
    for (i = 0; i < k - res; i++) sol += al[i] + bob[i];
    cout << sol << "\n";
  }
}
