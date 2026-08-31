#include <bits/stdc++.h>
using namespace std;
void test_case() {
  long long int n, k;
  cin >> n >> k;
  vector<long long int> as, bs, cs;
  for (long long int i = 0; i < n; i++) {
    long long int t, a, b;
    cin >> t >> a >> b;
    if (a + b == 2)
      cs.push_back(t);
    else if (a == 1)
      as.push_back(t);
    else if (b == 1)
      bs.push_back(t);
  }
  if (as.size() + cs.size() < k) {
    cout << -1;
    return;
  }
  if (bs.size() + cs.size() < k) {
    cout << -1;
    return;
  }
  sort(as.begin(), as.end());
  sort(bs.begin(), bs.end());
  sort(cs.begin(), cs.end());
  long long int a, b, c, done = 0, res = 0;
  a = b = c = 0;
  while (c < cs.size() && c < k) res += cs[c++];
  while (a + c < k) res += as[a++];
  while (b + c < k) res += bs[b++];
  while (a < as.size() && b < bs.size() && c > 0 && as[a] + bs[b] <= cs[c - 1])
    res += (as[a++] + bs[b++] - cs[--c]);
  cout << res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int t = 1;
  for (long long int i = 0; i < t; i++) {
    test_case();
    cout << endl;
  }
  return 0;
}
