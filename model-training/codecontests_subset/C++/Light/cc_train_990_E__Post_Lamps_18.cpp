#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1e9 + 7;
const int N = 1e6 + 10;
vector<long long int> a(N), nxt(N);
long long int val, n, m, k;
bool check(long long int k) {
  if (a[0]) return false;
  long long int i = n;
  val = 0;
  while (i > 0) {
    long long int j = nxt[max(0ll, i - k)];
    if (j == i) return false;
    i = j;
    val++;
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int T = clock();
  cin >> n >> m >> k;
  for (long long int i = 0; i < m; i++) {
    long long int s;
    cin >> s;
    a[s] = 1;
  }
  a[n] = 1;
  long long int cur = n;
  for (long long int i = n; i >= 0; i--) {
    if (!a[i]) cur = i;
    nxt[i] = cur;
  }
  vector<long long int> c(k + 1);
  for (long long int i = 1; i <= k; i++) cin >> c[i];
  long long int ans = mod * mod;
  for (long long int i = 1; i <= k; i++) {
    if (check(i)) ans = min(ans, val * c[i]);
  }
  if (ans == mod * mod)
    cout << -1;
  else
    cout << ans;
  cerr << "\n\nTIME: " << (double)(clock() - T) / CLOCKS_PER_SEC << " sec\n";
  T = clock();
  return 0;
}
