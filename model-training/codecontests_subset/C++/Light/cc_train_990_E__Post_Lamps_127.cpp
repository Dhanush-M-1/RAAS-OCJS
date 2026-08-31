#include <bits/stdc++.h>
using namespace std;
const int N = (int)1e6 + 3;
const long long OO = 1e18;
int main(int argc, char* argv[]) {
  ios::sync_with_stdio(0);
  int n, m, k;
  cin >> n >> m >> k;
  vector<int> s(n + 1, 0);
  for (int(i) = (0); (i) < (m); (i)++) {
    int tmp;
    cin >> tmp;
    s[tmp] = 1;
  }
  if (s[0]) {
    cout << -1 << endl;
    return 0;
  }
  int now = 0;
  vector<int> prev(n + 1, 0);
  for (int(i) = (0); (i) < (n + 1); (i)++) {
    if (!s[i]) {
      now = i;
      prev[i] = now;
    } else {
      prev[i] = now;
    }
  }
  vector<int> a;
  a.resize(k, 0);
  for (int(i) = (0); (i) < (k); (i)++) {
    cin >> a[i];
  }
  long long bestAns = OO;
  for (int(K) = (0); (K) < (k); (K)++) {
    int pos = 0;
    long long ans = 0;
    bool can = true;
    for (;;) {
      if (pos == n) {
        break;
      }
      int nxt = pos + (K + 1);
      nxt = min(nxt, n);
      nxt = prev[nxt];
      if (nxt == pos) {
        can = false;
        break;
      }
      ans += a[K];
      pos = nxt;
    }
    if (!can) continue;
    bestAns = min(bestAns, ans);
  }
  if (bestAns == OO) {
    cout << -1 << endl;
  } else {
    cout << bestAns << endl;
  }
  return 0;
}
