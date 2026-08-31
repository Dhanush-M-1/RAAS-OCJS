#include <bits/stdc++.h>
using namespace std;
template <typename Number>
Number gcd(Number u, Number v) {
  while (v != 0) {
    Number r = u % v;
    u = v;
    v = r;
  }
  return u;
}
long long int binSearch(vector<long long int> v, long long int l,
                        long long int r, long long int x) {
  if (r >= l) {
    long long int mid = l + (r - l) / 2;
    if (v[mid] == x) return mid;
    if (v[mid] > x) return binSearch(v, l, mid - 1, x);
    return binSearch(v, mid + 1, r, x);
  }
  return -1;
}
void solve() {
  long long int n, k;
  cin >> n >> k;
  long long int x, y, z;
  priority_queue<long long int, vector<long long int>, greater<long long int>>
      v1, v2, v3;
  for (long long int i = 0; i < n; i++) {
    cin >> x >> y >> z;
    if (y == 1 && z == 1) {
      v3.push(x);
    } else if (y == 1) {
      v1.push(x);
    } else if (z == 1) {
      v2.push(x);
    }
  }
  if ((v1.size() + v3.size()) < k) {
    cout << -1 << endl;
    return;
  }
  if ((v2.size() + v3.size()) < k) {
    cout << -1 << endl;
    return;
  }
  long long int a = 0, b = 0;
  long long int ans = 0;
  bool fg = 0;
  while (a < k || b < k) {
    if (v3.size() == 0) {
      fg = 1;
      break;
    }
    if (v1.size() != 0 && v2.size() != 0) {
      if ((v1.top() + v2.top()) <= v3.top()) {
        ans += (v1.top() + v2.top());
        v1.pop();
        v2.pop();
      } else {
        ans += v3.top();
        v3.pop();
      }
      a++;
      b++;
    } else {
      ans += v3.top();
      v3.pop();
      a++;
      b++;
    }
  }
  if (fg) {
    while (a < k) {
      ans += v1.top();
      v1.pop();
      a++;
    }
    while (b < k) {
      ans += v2.top();
      v2.pop();
      b++;
    }
  }
  cout << ans << endl;
  return;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
