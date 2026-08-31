#include <bits/stdc++.h>
using namespace std;
long long bit[200005];
void add(long long idx, long long val) {
  for (int i = idx; i < 200005; i += (i & (-i))) {
    bit[i] += val;
  }
}
long long query(long long i) {
  long long ans = 0;
  for (; i > 0; i -= (i & (-i))) ans += bit[i];
  return ans;
}
long long b[200005];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n, i, j, k, m;
  cin >> n;
  long long a[n];
  for (i = 0; i < n; i++) cin >> a[i];
  set<long long> s, s1;
  unordered_map<long long, long long> mp;
  long long sm = 0;
  long long sum[n + 5];
  for (i = 1; i <= n; i++) {
    sm += i;
    mp[sm] = i;
    s.insert(i);
    s1.insert(sm);
    sum[i] = sm;
  }
  for (i = 1; i <= n; i++) {
    add(i, i);
  }
  for (i = n - 1; i >= 0; i--) {
    long long f = 1, l = n;
    long long mid;
    long long anss = 0;
    while (f <= l) {
      mid = (f + l) / 2;
      if (query(mid) > a[i]) {
        l = mid - 1;
      } else {
        f = mid + 1;
        anss = mid;
      }
    }
    anss++;
    b[i] = anss;
    add(anss, -anss);
  }
  for (i = 0; i < n; i++) cout << b[i] << " ";
}
