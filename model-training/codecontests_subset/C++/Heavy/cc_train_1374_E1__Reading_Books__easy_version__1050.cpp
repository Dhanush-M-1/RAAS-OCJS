#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, k;
  cin >> n >> k;
  vector<tuple<long long, long long, long long>> v;
  long long x = 0, y = 0, z = 0;
  for (long long i = 0; i < n; i++) {
    long long a, b, c;
    cin >> a >> b >> c;
    v.push_back(make_tuple(a, b, c));
    if (b == 1 && c == 1) {
      x++;
    }
    if (b == 1 && c == 0) {
      y++;
    }
    if (b == 0 && c == 1) {
      z++;
    }
  }
  sort(v.begin(), v.end());
  long long sum = 0;
  long long sum1 = 0;
  long long sum2 = 0;
  long long j = 0, w = 0, q = 0;
  long long a[x], b[y], c[z];
  for (long long i = 0; i < v.size(); i++) {
    if (get<1>(v[i]) == get<2>(v[i]) && get<2>(v[i]) == 1) {
      sum += get<0>(v[i]);
      a[j] = sum;
      j++;
    }
    if (get<1>(v[i]) == 1 && get<2>(v[i]) == 0) {
      sum1 += get<0>(v[i]);
      b[w] = sum1;
      w++;
    }
    if (get<1>(v[i]) == 0 && get<2>(v[i]) == 1) {
      sum2 += get<0>(v[i]);
      c[q] = sum2;
      q++;
    }
  }
  if ((w + j) < k || (j + q) < k) {
    cout << -1 << "\n";
  } else {
    long long ans = 10000000000;
    if ((q) >= k && (w) >= k) {
      ans = b[k - 1] + c[k - 1];
    }
    for (long long i = 0; i < j; i++) {
      if ((k - i - 2) >= 0 && (k - i - 2) < w && (k - i - 2) < q) {
        if ((ans) > (a[i] + b[k - i - 2] + c[k - i - 2])) {
          ans = a[i] + b[k - i - 2] + c[k - i - 2];
        }
      }
      if ((k - i - 2) < 0) {
        if (j >= k) {
          if ((ans) > a[k - 1]) {
            ans = a[k - 1];
          }
        }
      }
    }
    cout << ans << "\n";
  }
}
