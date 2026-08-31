#include <bits/stdc++.h>
using namespace std;
void CyBerForCe() {
  long long n;
  cin >> n;
  vector<long long> v;
  for (long long i = 0; i < n; i++) {
    long long a;
    cin >> a;
    v.push_back(a);
  }
  long long a = 1, b = 2, c = 0;
  for (long long i = 2; i < v.size(); i++) {
    if (v[i] >= v[0] + v[1]) {
      c = i + 1;
      break;
    }
  }
  if (c == 0)
    cout << "-1\n";
  else
    cout << a << " " << b << " " << c << "\n";
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t;
  cin >> t;
  while (t--) CyBerForCe();
  return 0;
}
