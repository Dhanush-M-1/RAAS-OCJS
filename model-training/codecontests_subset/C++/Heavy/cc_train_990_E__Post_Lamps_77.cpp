#include <bits/stdc++.h>
using namespace std;
const long long inf = 1000000000000000;
const int mod = 1000000007;
int n, m, k;
int s[1000010];
long long a[1000010];
bool pos[1000010];
int lst[1000010];
long long get(int l) {
  int r = 0;
  int i = -1;
  long long res = 0;
  while (r < n) {
    if (lst[r] <= i) {
      return inf;
    }
    i = lst[r];
    r = lst[r] + l;
    ++res;
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    cin >> s[i];
  }
  for (int i = 0; i < k; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n; i++) {
    pos[i] = true;
  }
  for (int i = 0; i < m; i++) {
    pos[s[i]] = false;
  }
  for (int i = 0; i < n; i++) {
    if (pos[i]) {
      lst[i] = i;
    } else if (i) {
      lst[i] = lst[i - 1];
    } else
      lst[i] = -1;
  }
  long long ans = inf;
  for (int i = 0; i < k; i++) {
    long long t = get(i + 1);
    if (t != inf) {
      ans = min(ans, a[i] * t);
    }
  }
  if (ans == inf) {
    ans = -1;
  }
  cout << ans << '\n';
  return 0;
}
