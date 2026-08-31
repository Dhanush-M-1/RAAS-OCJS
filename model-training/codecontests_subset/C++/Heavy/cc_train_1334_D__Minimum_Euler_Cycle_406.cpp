#include <bits/stdc++.h>
using namespace std;
long long int max(long long int a, long long int b) {
  if (a >= b)
    return a;
  else
    return b;
}
long long int min(long long int a, long long int b) {
  if (a <= b)
    return a;
  else
    return b;
}
void solve() {
  long long int n, l, r;
  cin >> n >> l >> r;
  if (l == (1LL * n * (n - 1)) + 1) {
    cout << 1 << endl;
    return;
  }
  long long int sum = 0;
  long long int i;
  for (i = n - 1; i >= 1; i--) {
    sum += 1LL * 2 * i;
    if (sum >= l) {
      break;
    }
  }
  vector<long long int> ans;
  long long int total = r - l + 1;
  if (r == (1LL * n * (n - 1)) + 1) total--;
  long long int count = sum - l + 1;
  long long int a, b;
  if ((count % 2) == 0) {
    a = n - i;
    b = n - (count / 2) + 1;
  } else {
    ans.push_back(n - ((count) / 2));
    a = n - i;
    b = n - (count / 2) + 1;
    total--;
  }
  if (count == 1) {
    a++;
    b = a + 1;
  }
  while (total > 0) {
    if (b == n + 1) {
      a++;
      b = a + 1;
    }
    ans.push_back(a);
    total--;
    if (total == 0) break;
    ans.push_back(b);
    total--;
    b++;
  }
  if (r == (1LL * n * (n - 1)) + 1) ans.push_back(1);
  for (auto it : ans) {
    cout << it << " ";
  }
  cout << endl;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
