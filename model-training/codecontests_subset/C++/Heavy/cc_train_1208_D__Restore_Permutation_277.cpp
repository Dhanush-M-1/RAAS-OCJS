#include <bits/stdc++.h>
using namespace std;
long long power(long long a, long long b, long long m) {
  a %= m;
  long long ret = 1;
  while (b) {
    if (b & 1) ret = ((ret % m) * (a % m)) % m;
    a = ((a % m) * (a % m)) % m;
    b >>= 1;
  }
  return ret;
}
const int N = 2e5 + 5;
long long n, bit[N + 3], a[N + 2], ans[N + 2];
void update(long long val, int x) {
  for (; x <= N; x += x & (-x)) {
    bit[x] += val;
  }
}
long long query(int x) {
  int tm = x;
  long long ret = 0;
  while (x > 0) {
    ret += bit[x];
    x -= x & (-x);
  }
  ret += ans[tm - 1];
  return ret;
}
void pre() {
  long long now = 0;
  ans[0] = 0;
  for (long long i = 1; i < N; i++) {
    now += i;
    ans[i] = now;
  }
}
int main() {
  pre();
  cin >> n;
  vector<long long> vec;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = n - 1; i >= 0; i--) {
    int l = 1, r = n + 1, mid;
    while ((r - l) > 1) {
      mid = (l + r) / 2;
      long long result = query(mid);
      if (result <= a[i]) {
        l = mid;
      } else {
        r = mid;
      }
    }
    if (query(l + 1) == a[i]) {
      vec.push_back(l + 1);
      update(-(l + 1), l + 2);
    } else {
      vec.push_back(l);
      update(-(l), l + 1);
    }
  }
  reverse(vec.begin(), vec.end());
  for (auto it : vec) {
    cout << it << " ";
  }
  return 0;
}
