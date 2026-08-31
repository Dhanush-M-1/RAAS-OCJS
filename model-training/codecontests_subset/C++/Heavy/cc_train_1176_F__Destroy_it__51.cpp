#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<long long> ms(10, -1e18);
  ms[0] = 0;
  for (int k, i = 0; i < n; i++) {
    vector<long long> nms(10, -1e18);
    cin >> k;
    multiset<int> d1;
    int d2 = 0, d3 = 0;
    int c, d;
    for (int j = 0; j < k; j++) {
      cin >> c >> d;
      if (c == 1) {
        d1.insert(d);
        if (d1.size() > 3) d1.erase(d1.begin());
      } else if (c == 2)
        d2 = max(d2, d);
      else
        d3 = max(d3, d);
    }
    vector<pair<int, int> > bestd;
    for (int x : d1) bestd.push_back(make_pair(1, x));
    if (d2 > 0) bestd.push_back(make_pair(2, d2));
    if (d3 > 0) bestd.push_back(make_pair(3, d3));
    for (int j = 0; j < 10; j++) {
      nms[j] = max(nms[j], ms[j]);
      for (int i1 = 0; i1 < bestd.size(); i1++)
        nms[(j + 1) % 10] = max(nms[(j + 1) % 10],
                                ms[j] + bestd[i1].second * ((j >= 9) ? 2 : 1));
      for (int i1 = 0; i1 < bestd.size(); i1++) {
        for (int i2 = i1 + 1; i2 < bestd.size(); i2++) {
          if (bestd[i1].first + bestd[i2].first <= 3)
            nms[(j + 2) % 10] = max(
                nms[(j + 2) % 10], ms[j] + bestd[i1].second + bestd[i2].second +
                                       max(bestd[i1].second, bestd[i2].second) *
                                           ((j >= 8) ? 1 : 0));
        }
      }
      for (int i1 = 0; i1 < bestd.size(); i1++) {
        for (int i2 = i1 + 1; i2 < bestd.size(); i2++) {
          for (int i3 = i2 + 1; i3 < bestd.size(); i3++) {
            if (bestd[i1].first + bestd[i2].first + bestd[i3].first <= 3)
              nms[(j + 3) % 10] =
                  max(nms[(j + 3) % 10],
                      ms[j] + bestd[i1].second + bestd[i2].second +
                          bestd[i3].second +
                          max(bestd[i1].second,
                              max(bestd[i2].second, bestd[i3].second)) *
                              ((j >= 7) ? 1 : 0));
          }
        }
      }
    }
    for (int j = 0; j < 10; j++) ms[j] = nms[j];
  }
  long long ans = 0;
  for (int j = 0; j < 10; j++) ans = max(ans, ms[j]);
  cout << ans << endl;
  return 0;
}
