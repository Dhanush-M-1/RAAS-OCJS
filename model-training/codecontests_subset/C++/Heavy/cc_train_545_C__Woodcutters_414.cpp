#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int x, h, prevx, prevh;
  cin >> n;
  vector<long long> dpl(n, 0);
  vector<long long> dpn(n, 0);
  vector<long long> dpr(n, 0);
  for (int i = 0; i < n; ++i) {
    cin >> x >> h;
    if (i == 0) {
      dpl[0] = dpr[0] = 1;
      dpn[0] = 0;
    } else {
      if (x - prevx > h)
        dpl[i] = max(dpl[i - 1], dpn[i - 1]) + 1;
      else {
        dpl[i] = 0;
        if (x - prevx <= prevh) dpr[i - 1] = 0;
      }
      if (x - prevx > h + prevh) dpl[i] = max(dpr[i - 1] + 1, dpl[i]);
      dpr[i] = max(dpl[i - 1], dpn[i - 1]) + 1;
      if (x - prevx > prevh) {
        dpn[i] = max(max(dpr[i - 1], dpn[i - 1]), dpl[i - 1]);
        dpr[i] = max(dpr[i], dpr[i - 1] + 1);
      } else {
        dpn[i] = max(dpn[i - 1], dpl[i - 1]);
      }
    }
    prevx = x;
    prevh = h;
  }
  cout << max(max(dpl[n - 1], dpn[n - 1]), dpr[n - 1]);
  return 0;
}
