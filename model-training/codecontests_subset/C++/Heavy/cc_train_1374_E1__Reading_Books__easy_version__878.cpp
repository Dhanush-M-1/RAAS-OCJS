#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, k;
  cin >> n >> k;
  vector<long long> a, b, ab;
  int count_a = 0, count_b = 0;
  for (int i = 0; i < n; i++) {
    int t;
    bool b1, b2;
    cin >> t >> b1 >> b2;
    if (b1 && b2) {
      ab.push_back(t);
      count_a++;
      count_b++;
    } else if (b1) {
      a.push_back(t);
      count_a++;
    } else if (b2) {
      b.push_back(t);
      count_b++;
    }
  }
  if (count_a < k || count_b < k) {
    cout << -1 << endl;
  } else {
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());
    sort(ab.begin(), ab.end());
    int na = a.size(), nb = b.size(), nab = ab.size();
    for (int i = 1; i < na; i++) {
      a[i] += a[i - 1];
    }
    for (int i = 1; i < nb; i++) {
      b[i] += b[i - 1];
    }
    for (int i = 1; i < nab; i++) {
      ab[i] += ab[i - 1];
    }
    int x = min(k, nab);
    long long min_time = LONG_LONG_MAX;
    for (int i = 0; i <= x; i++) {
      if (k - i <= min(na, nb)) {
        if (i > 0 && i < k) {
          min_time = min(min_time, ab[i - 1] + a[k - i - 1] + b[k - i - 1]);
        } else if (i == 0) {
          min_time = min(min_time, a[k - 1] + b[k - 1]);
        } else {
          min_time = min(min_time, ab[k - 1]);
        }
      }
    }
    cout << min_time << endl;
  }
}
