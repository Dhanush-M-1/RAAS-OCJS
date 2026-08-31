#include <bits/stdc++.h>
using namespace std;
bool compare(pair<pair<long long int, long long int>, long long int> p1,
             pair<pair<long long int, long long int>, long long int> p2) {
  return p1.first.first < p2.first.first;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n, i;
  multiset<long long int> s, s1, s2;
  cin >> n;
  long long int a[n + 1], b[n], c[n - 1], ans;
  for (i = 1; i <= n; i++) {
    cin >> a[i];
    s.insert(a[i]);
  }
  for (i = 1; i <= n - 1; i++) {
    cin >> b[i];
    s1.insert(b[i]);
  }
  for (i = 1; i <= n; i++) {
    if (s1.count(a[i]) != s.count(a[i])) {
      cout << a[i] << "\n";
      ans = a[i];
      break;
    }
  }
  for (i = 1; i <= n - 2; i++) {
    cin >> c[i];
    s2.insert(c[i]);
  }
  s2.insert(ans);
  for (i = 1; i <= n; i++) {
    if (s2.count(a[i]) != s.count(a[i])) {
      cout << a[i] << "\n";
      break;
    }
  }
  return 0;
}
