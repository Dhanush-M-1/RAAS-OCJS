#include <bits/stdc++.h>
using namespace std;
int main() {
  long long q, c, i;
  cin >> q;
  if (q == 1) {
    cout << "1" << endl;
    cout << "0";
    return 0;
  }
  vector<pair<long long, long long>> a;
  for (i = 2; i * i <= q; i++) {
    if (q % i == 0) {
      c = 0;
      while (q % i == 0) {
        c++;
        q = q / i;
      }
      a.push_back({i, c});
    }
  }
  if (q > 1) {
    a.push_back({q, 1});
  }
  if (a.size() == 1) {
    if (a[0].second == 2) {
      cout << "2" << endl;
    } else {
      cout << "1" << endl;
      if (a[0].second == 1) {
        cout << "0";
      } else {
        cout << (a[0].first) * (a[0].first);
      }
    }
  } else if (a.size() == 2) {
    if (a[0].second == 1 && a[1].second == 1) {
      cout << "2" << endl;
    } else {
      cout << "1" << endl;
      cout << (a[0].first) * (a[1].first);
    }
  } else {
    cout << "1" << endl;
    cout << (a[0].first) * (a[1].first);
  }
}
