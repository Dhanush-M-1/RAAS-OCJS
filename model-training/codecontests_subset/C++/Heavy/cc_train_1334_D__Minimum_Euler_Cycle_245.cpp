#include <bits/stdc++.h>
using namespace std;
vector<long long> v;
void insert(long long start, long long n) {
  long long lim = start + 1;
  while (lim <= n) {
    v.push_back(start);
    v.push_back(lim);
    lim++;
  }
}
void solve() {
  long long n, l, r;
  cin >> n >> l >> r;
  long long len = r - l + 1;
  long long start = 1;
  while (start < n && l > 2 * (n - start)) {
    l -= 2 * (n - start);
    start++;
  }
  if (start == n) {
    cout << "1\n";
    return;
  }
  v.clear();
  while (start < n && v.size() < len + l - 1) {
    insert(start, n);
    start++;
  }
  if (start == n) {
    v.push_back(1);
  }
  long long i = l - 1;
  while (len--) {
    cout << v[i] << " ";
    i++;
  }
  cout << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long test = 1;
  cin >> test;
  while (test--) solve();
  return 0;
}
