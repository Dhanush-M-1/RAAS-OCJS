#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, k;
  cin >> n >> k;
  vector<long long int> a, b, c;
  for (int i = 0; i < n; i++) {
    int t, x, y;
    cin >> t >> x >> y;
    if (x && y)
      c.push_back(t);
    else if (x && !y)
      a.push_back(t);
    else if (!x && y)
      b.push_back(t);
  }
  sort(a.begin(), a.end(), greater<long long>());
  sort(b.begin(), b.end(), greater<long long>());
  long long ans = 0;
  int an = a.size(), bn = b.size(), cn = c.size();
  if (an + cn >= k && bn + cn >= k) {
    while ((int)a.size() > 0 && (int)b.size() > 0) {
      c.push_back(a.back() + b.back());
      a.pop_back();
      b.pop_back();
    }
    sort(c.begin(), c.end());
    for (int i = 0; i < k; i++) {
      ans += c[i];
    }
  } else
    ans = -1;
  cout << ans << endl;
  return 0;
}
