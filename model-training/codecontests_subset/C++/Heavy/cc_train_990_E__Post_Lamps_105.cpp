#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const long long inf = 4e18;
const long long ninf = -inf;
const int imax = 2e9;
const int MAX = 1e6 + 100;
int n, m, k;
int h[MAX], last[MAX];
long long s[MAX];
long long a[MAX];
long long solve(int val) {
  long long ans = 0;
  int repeat = 0;
  for (int i = 0; i < n;) {
    if (!h[i]) {
      ans++;
      i += val;
    } else {
      i = last[i];
    }
    if (i == repeat) {
      return 1e17;
    } else {
      repeat = i;
    }
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    cin >> s[i];
    h[s[i]] = 1;
  }
  for (int i = 1; i <= k; i++) {
    cin >> a[i];
  }
  int last_yes = 0;
  for (int i = 0; i <= n; i++) {
    if (!h[i]) {
      last_yes = i;
    }
    last[i] = last_yes;
  }
  long long cont = 0, mcont = 0;
  for (int i = 0; i <= n; i++) {
    if (h[i]) {
      cont++;
      mcont = max(mcont, cont);
    } else {
      mcont = max(mcont, cont);
      cont = 0;
    }
  }
  long long maxAns = 1e16;
  for (int i = mcont + 1; i <= k; i++) {
    long long ct = solve(i);
    ;
    if (ct < 1e16) maxAns = min(ct * a[i], maxAns);
  }
  if (maxAns >= 9e15) {
    cout << -1 << endl;
  } else {
    cout << maxAns << endl;
  }
}
