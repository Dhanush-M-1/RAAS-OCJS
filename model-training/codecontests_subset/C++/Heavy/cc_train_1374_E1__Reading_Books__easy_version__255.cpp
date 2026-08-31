#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, m;
  cin >> n >> m;
  vector<long long int> aa, bb, cc;
  vector<long long int> a(n + 5);
  vector<long long int> b(n + 5);
  vector<long long int> c(n + 5);
  for (long long int i = 1; i <= n; i++) {
    cin >> a[i] >> b[i] >> c[i];
    if (b[i] && c[i])
      cc.push_back(a[i]);
    else if (b[i])
      aa.push_back(a[i]);
    else if (c[i])
      bb.push_back(a[i]);
  }
  sort(aa.begin(), aa.end());
  sort(bb.begin(), bb.end());
  sort(cc.begin(), cc.end());
  vector<long long int> vc1(n + 5), vc2(n + 5);
  for (long long int i = 0; i <= (long long int)aa.size() - 1; i++) {
    if (!i) {
      int gg = 0;
    } else {
      vc1[i] = vc1[i - 1];
    }
    vc1[i] += aa[i];
  }
  for (long long int j = 0; j <= (long long int)bb.size() - 1; j++) {
    if (!j) {
      int hh = 0;
    } else {
      vc2[j] = vc2[j - 1];
    }
    vc2[j] += bb[j];
  }
  long long int mxx = INT_MAX, s = 0;
  for (long long int k = 0; k <= cc.size(); k++) {
    if (!k) {
      int hg = 0;
    } else {
      m--;
      s += cc[k - 1];
    }
    if (aa.size() < m) {
      continue;
    }
    if (bb.size() < m) {
      continue;
    }
    if (m > 0) {
      mxx = min(mxx, s + vc1[m - 1] + vc2[m - 1]);
    } else
      mxx = min(mxx, s);
  }
  if (mxx != INT_MAX) {
    int yy = 0;
  } else
    mxx = -1;
  cout << mxx << endl;
}
