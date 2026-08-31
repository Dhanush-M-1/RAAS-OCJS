#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, x, xa, xb, aa = 0, bb = 0, cc;
  vector<int> a, b, c;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> x >> xa >> xb;
    aa += xa;
    bb += xb;
    if (xa & xb)
      c.push_back(x);
    else if (xa)
      a.push_back(x);
    else if (xb)
      b.push_back(x);
  }
  if (aa < k || bb < k) {
    cout << -1;
    return 0;
  }
  aa = 0;
  bb = 0;
  cc = 0;
  int ka = a.size(), kb = b.size(), kc = c.size();
  x = 0;
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  for (int i = 0; i < k; i++) {
    if (cc >= kc)
      x += a[aa++] + b[bb++];
    else if (aa < ka && bb < kb) {
      if (a[aa] + b[bb] < c[cc])
        x += a[aa++] + b[bb++];
      else
        x += c[cc++];
    } else {
      x += c[cc++];
    }
  }
  cout << x;
  return 0;
}
