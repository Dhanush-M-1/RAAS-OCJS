#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  vector<char> v;
  long long ca = 0, ci = 0, cf = 0;
  for (long long i = 0; i < n; i++) {
    char a;
    cin >> a;
    v.push_back(a);
    if (a == 'A') ca++;
    if (a == 'I') ci++;
    if (a == 'F') cf++;
  }
  if (ca + cf == n)
    cout << ca;
  else {
    if (ci > 1)
      cout << 0;
    else
      cout << ci;
  }
  for (long long i = 1; i < n; i++) {
  }
}
