#include <bits/stdc++.h>
using namespace std;
long long sma[200010];
long long smb[200010];
long long d[200010];
int n;
void adda(int pos, long long x) {
  for (int i = pos; i <= n; i = (i | (i - 1)) + 1) {
    sma[i] += x;
  }
}
long long suma(int pos) {
  long long ans = 0;
  for (int i = pos; i > 0; i &= i - 1) {
    ans += sma[i];
  }
  return ans;
}
void addb(int pos, long long x) {
  for (int i = pos; i <= n; i = (i | (i - 1)) + 1) {
    smb[i] += x;
  }
}
long long sumb(int pos) {
  long long ans = 0;
  for (int i = pos; i > 0; i &= i - 1) {
    ans += smb[i];
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  int k, q;
  long long a, b;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    int x;
    cin >> x;
    if (x == 1) {
      int pos;
      long long v;
      cin >> pos >> v;
      if (d[pos] < b) {
        if (d[pos] + v < b) {
          addb(pos, v);
        } else {
          addb(pos, b - d[pos]);
        }
      }
      if (d[pos] < a) {
        if (d[pos] + v < a) {
          adda(pos, v);
        } else {
          adda(pos, a - d[pos]);
        }
      }
      d[pos] += v;
    } else {
      int pos;
      cin >> pos;
      cout << sumb(pos - 1) + suma(n) - suma(pos + k - 1) << "\n";
    }
  }
  return 0;
}
