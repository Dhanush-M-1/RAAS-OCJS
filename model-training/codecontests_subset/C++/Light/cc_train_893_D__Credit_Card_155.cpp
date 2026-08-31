#include <bits/stdc++.h>
using namespace std;
long long gcd1(long long a, long long b) {
  if (a == 0) return b;
  return gcd1(b % a, a);
}
long long modx(long long base, long long ex) {
  long long ans = 1LL, val = base;
  while (ex > 0LL) {
    if (ex & 1LL) ans = (ans * val) % 1000000007LL;
    val = (val * val) % 1000000007LL;
    ex = ex >> 1LL;
  }
  return ans;
}
const int maxn = 1e5 + 10;
long long n, d;
long long a[maxn], maxx[maxn], pre[maxn];
bool flag;
vector<int> v;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> d;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    pre[i] = pre[i - 1] + a[i];
    if (pre[i] > d) flag = true;
    if (a[i] == 0) v.push_back(i);
  }
  if (flag) {
    cout << -1 << endl;
    return 0;
  }
  maxx[n + 1] = INT_MIN;
  for (int i = n; i >= 1; i--) maxx[i] = max(pre[i], maxx[i + 1]);
  long long temp = 0, cnt = 0;
  for (int i = 0; i < v.size(); i++) {
    if (pre[v[i]] + temp < 0) {
      long long t = maxx[v[i]] + temp;
      cnt++;
      long long add = d - t;
      if (add + pre[v[i]] + temp < 0) {
        cout << -1 << endl;
        return 0;
      }
      temp += add;
    }
  }
  cout << cnt << endl;
  return 0;
}
