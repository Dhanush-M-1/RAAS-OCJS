#include <bits/stdc++.h>
using namespace std;
const long long MOD = 998244353;
struct sqrt_decomp {
  long long n, b;
  vector<long long> values;
  vector<long long> prefix;
  vector<long long> woff;
  vector<long long> w;
  sqrt_decomp(long long n) {
    b = sqrt(n);
    if (b * b != n) {
      b++;
    }
    this->b = b;
    this->n = b * b;
    values = vector<long long>(this->n, 0);
    prefix = vector<long long>(this->n, 0);
    w = vector<long long>(this->n, 0);
    woff = vector<long long>(this->b, 0);
  }
  void rebuild_wedge(long long idx) {
    long long mn = LONG_LONG_MAX;
    for (long long i = 0; i < b; i++) {
      mn = min(mn, w[idx * b + i]);
    }
    woff[idx] += mn;
    fill(prefix.begin() + idx * b, prefix.begin() + (idx + 1) * b, 0);
    for (long long i = 0; i < b; i++) {
      w[idx * b + i] -= mn;
      assert(w[idx * b + i] < b);
      prefix[idx * b + w[idx * b + i]] += values[idx * b + i];
    }
    for (long long i = 1; i < b; i++) {
      prefix[idx * b + i] += prefix[idx * b + i - 1];
    }
  }
  void update_wedge(long long idx, long long d) { woff[idx] += d; }
  void update_point(long long i, long long d) { w[i] += d; }
  long long query_wedge(long long idx, long long thresh) {
    long long target = thresh - woff[idx];
    target = min(b - 1, target);
    if (false) cout << "wedge " << idx << " target: " << target << endl;
    if (target < 0) return 0;
    return prefix[idx * b + target];
  }
  long long query_point(long long i, long long thresh) {
    if ((w[i] + woff[i / b]) <= thresh) return values[i];
    return 0;
  }
  void update(long long l, long long r, long long d) {
    long long i = l;
    set<int> to_rebuild;
    while (i < r) {
      if (i % b == 0 && (r - i) >= b) {
        update_wedge(i / b, d);
        i += b;
      } else {
        update_point(i, d);
        to_rebuild.insert(i / b);
        i++;
      }
    }
    for (auto it = to_rebuild.begin(); it != to_rebuild.end(); it++)
      rebuild_wedge(*it);
  }
  long long query(long long r, long long thresh) {
    if (false) {
      for (long long i = 0; i < b; i++) {
        cout << woff[i] << string(2 * b - 1, ' ');
      }
      cout << endl;
      for (long long i = 0; i < n; i++) {
        cout << w[i] << " ";
      }
      cout << endl;
      for (long long i = 0; i < n; i++) {
        cout << values[i] << " ";
      }
      cout << endl;
      for (long long i = 0; i < n; i++) {
        cout << prefix[i] << " ";
      }
      cout << endl;
    }
    long long ret = 0;
    long long i = 0;
    while (i < r) {
      if (i % b == 0 && (r - i) >= b) {
        ret = (ret + query_wedge(i / b, thresh)) % MOD;
        i += b;
      } else {
        ret = (ret + query_point(i, thresh)) % MOD;
        i++;
      }
    }
    return ret;
  }
  void setv(long long i, long long x) {
    values[i] = x;
    rebuild_wedge(i / b);
  }
  long long getv(long long i) { return values[i]; }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long n, k;
  cin >> n >> k;
  n++;
  vector<long long> prev(n, 0);
  unordered_map<long long, long long> s;
  vector<long long> x(n);
  x[0] = -1;
  for (long long i = 1; i < n; i++) {
    cin >> x[i];
    prev[i] = s[x[i]];
    s[x[i]] = i;
  }
  s.clear();
  sqrt_decomp a(n);
  for (long long i = 0; i < n; i++) {
    if (!i) {
      a.setv(i, 1);
    } else {
      if (false) cout << "inc: [" << prev[i] << ", " << i << ")" << endl;
      a.update(prev[i], i, 1);
      if (prev[i]) {
        if (false)
          cout << "dec: [" << prev[prev[i]] << ", " << prev[i] << ")" << endl;
        a.update(prev[prev[i]], prev[i], -1);
      }
      long long ret = a.query(i, k);
      if (false) cout << i << ": " << ret << endl;
      a.setv(i, ret);
    }
  }
  cout << a.getv(n - 1) << endl;
  return 0;
}
