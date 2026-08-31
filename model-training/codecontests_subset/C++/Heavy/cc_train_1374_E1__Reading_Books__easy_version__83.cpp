#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18;
const long long MAX = 1e5 + 10;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, k;
  cin >> n >> k;
  vector<long long> a, b, ab;
  ab.push_back(0);
  a.push_back(0);
  b.push_back(0);
  for (int i = 0; i < n; i++) {
    long long t, A, B;
    cin >> t >> A >> B;
    if (A == 1 && B == 1)
      ab.push_back(t);
    else if (A == 1)
      a.push_back(t);
    else if (B == 1)
      b.push_back(t);
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(ab.begin(), ab.end());
  long long ans = INF;
  for (int i = 1; i < ab.size(); i++) ab[i] += ab[i - 1];
  for (int i = 1; i < a.size(); i++) a[i] += a[i - 1];
  for (int i = 1; i < b.size(); i++) b[i] += b[i - 1];
  for (int i = 0; i < min((int)ab.size(), k + 1); i++) {
    if (a.size() > k - i && b.size() > k - i)
      ans = min(ans, ab[i] + a[k - i] + b[k - i]);
  }
  if (ans != INF)
    cout << ans << "\n";
  else
    cout << -1 << "\n";
}
