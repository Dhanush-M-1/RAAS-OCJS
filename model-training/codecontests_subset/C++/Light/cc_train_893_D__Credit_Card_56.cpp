#include <bits/stdc++.h>
using namespace std;
long long n;
long long k, m;
long long mod = 1e9 + 7;
vector<int> ar, tag;
vector<vector<int> > graph;
int main() {
  std::ios_base::sync_with_stdio(false);
  std::cin.tie(nullptr);
  long long d;
  cin >> n >> d;
  vector<long long> acc;
  for (int a, i = 0; i < n; i++) {
    cin >> a;
    ar.push_back(a);
    if (i)
      acc.push_back(acc[i - 1] + a);
    else
      acc.push_back(a);
    if (acc[i] > d) return cout << -1, 0;
  }
  vector<long long> postmax(n + 1, 0);
  for (int i = n - 1; i >= 0; i--) {
    if (i == n - 1)
      postmax[i] = (acc[i]);
    else
      postmax[i] = (max(acc[i], postmax[i + 1]));
  }
  postmax.push_back(INT_MIN);
  long long addon = 0;
  int count = 0;
  for (int i = 0; i < n; i++) {
    if (acc[i] + addon > d) return cout << -1, 0;
    if (ar[i] == 0 && acc[i] + addon < 0 && i != n - 1) {
      long long minval = 0 - (acc[i] + addon);
      long long maxval = d - (postmax[i + 1] + addon);
      if (minval > maxval) return cout << -1, 0;
      addon += min(maxval, d + minval);
      count++;
    }
  }
  if (acc[n - 1] + addon < 0 && ar[n - 1] == 0) count++;
  return cout << count, 0;
}
