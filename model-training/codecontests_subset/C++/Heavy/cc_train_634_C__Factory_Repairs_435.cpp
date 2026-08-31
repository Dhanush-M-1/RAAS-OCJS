#include <bits/stdc++.h>
using namespace std;
long long n, k, A, B, q;
vector<long long> ta;
void aupdate(long long v, long long l, long long r, long long p, long long x) {
  if (l == r) {
    ta[v] = min(ta[v] + x, A);
  } else {
    long long m = (l + r) / 2;
    if (p <= m) {
      aupdate(v * 2, l, m, p, x);
    } else {
      aupdate((v * 2) + 1, m + 1, r, p, x);
    }
    ta[v] = ta[v * 2] + ta[(v * 2) + 1];
  }
}
long long asum(long long v, long long l1, long long r1, long long l,
               long long r) {
  if (l1 == l && r1 == r) {
    return ta[v];
  } else {
    long long m = (l1 + r1) / 2;
    if (r <= m) {
      return asum(v * 2, l1, m, l, r);
    } else {
      if (l > m) {
        return asum((v * 2) + 1, m + 1, r1, l, r);
      } else {
        return asum(v * 2, l1, m, l, m) +
               asum((v * 2) + 1, m + 1, r1, m + 1, r);
      }
    }
  }
}
vector<long long> tb;
void bupdate(long long v, long long l, long long r, long long p, long long x) {
  if (l == r) {
    tb[v] = min(B, tb[v] + x);
  } else {
    long long m = (l + r) / 2;
    if (p <= m) {
      bupdate(v * 2, l, m, p, x);
    } else {
      bupdate((v * 2) + 1, m + 1, r, p, x);
    }
    tb[v] = tb[v * 2] + tb[(v * 2) + 1];
  }
}
long long bsum(long long v, long long l1, long long r1, long long l,
               long long r) {
  if (l1 == l && r1 == r) {
    return tb[v];
  } else {
    long long m = (l1 + r1) / 2;
    if (r <= m) {
      return bsum(v * 2, l1, m, l, r);
    } else {
      if (l > m) {
        return bsum((v * 2) + 1, m + 1, r1, l, r);
      } else {
        return bsum(v * 2, l1, m, l, m) +
               bsum((v * 2) + 1, m + 1, r1, m + 1, r);
      }
    }
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k >> A >> B >> q;
  ta.resize(n * 4);
  tb.resize(n * 4);
  fill(ta.begin(), ta.end(), 0);
  fill(tb.begin(), tb.end(), 0);
  while (q--) {
    long long t;
    cin >> t;
    if (t == 1) {
      long long d, a;
      cin >> d >> a;
      d--;
      aupdate(1, 0, n - 1, d, a);
      bupdate(1, 0, n - 1, d, a);
    } else {
      long long p;
      cin >> p;
      p--;
      long long ans;
      if (k == n) {
        ans = 0;
      } else {
        if (p == n - k) {
          ans = bsum(1, 0, n - 1, 0, p - 1);
        } else {
          if (p == 0) {
            ans = asum(1, 0, n - 1, k, n - 1);
          } else {
            ans = bsum(1, 0, n - 1, 0, p - 1) + asum(1, 0, n - 1, p + k, n - 1);
          }
        }
      }
      cout << ans << '\n';
    }
  }
  return 0;
}
