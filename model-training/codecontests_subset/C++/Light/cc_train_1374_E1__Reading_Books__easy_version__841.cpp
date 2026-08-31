#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, n, k, alike, blike, t, total = 0;
  cin >> n >> k;
  vector<int> a, b, coll;
  for (i = 0; i < n; i++) {
    cin >> t >> alike >> blike;
    if (alike) {
      if (blike)
        coll.push_back(t);
      else
        a.push_back(t);
    } else if (blike)
      b.push_back(t);
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  for (i = 0; i < min(a.size(), b.size()); i++) coll.push_back(a[i] + b[i]);
  if (k > coll.size())
    cout << -1;
  else {
    sort(coll.begin(), coll.end());
    for (i = 0; i < k; i++) total += coll[i];
    cout << total;
  }
  return 0;
}
