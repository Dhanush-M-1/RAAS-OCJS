#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
long long powmod(long long a, long long b) {
  long long res = 1;
  a %= mod;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
char c;
int n;
vector<int> p, m;
vector<int> ans;
vector<int> bb;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  bool b = 1;
  int idx = 0;
  while (1) {
    cin >> c;
    if (c == '?') {
      if (b)
        p.push_back(idx), ans.push_back(1), bb.push_back(1);
      else
        m.push_back(idx), ans.push_back(1), bb.push_back(0);
      idx++;
    } else if (c == '+')
      b = 1;
    else if (c == '-')
      b = 0;
    else if (c == '=')
      break;
  }
  cin >> n;
  int n1 = p.size() - m.size() * n, n2 = p.size() * n - m.size();
  if (n1 > n || n2 < n)
    cout << "Impossible"
         << "\n";
  else {
    int left = p.size() - n - m.size();
    int n1 = n + m.size();
    for (int i = 0; i < (int)m.size(); i++) {
      if (left <= 0) break;
      if (left > n - 1)
        ans[m[i]] = n, left -= n - 1, n1 += n - 1;
      else
        ans[m[i]] = 1 + left, n1 += left, left = 0;
    }
    n1 -= p.size();
    for (int i = 0; i < (int)p.size(); i++) {
      if (n1 == 0) break;
      if (n1 > n - 1)
        ans[p[i]] = n, n1 -= n - 1;
      else
        ans[p[i]] = 1 + n1, n1 = 0;
    }
    cout << "Possible"
         << "\n";
    for (int i = 0; i < (int)ans.size(); i++) {
      cout << ans[i];
      if (i + 1 < ans.size()) {
        if (bb[i + 1])
          cout << " + ";
        else
          cout << " - ";
      }
    }
    cout << " = " << n << "\n";
  }
  return 0;
}
