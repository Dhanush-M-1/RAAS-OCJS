#include <bits/stdc++.h>
using namespace std;
int mpow(int base, int exp);
void ipgraph(int n, int m);
void dfs(int u, int par);
const int mod = 1e9 + 7;
struct cmp {
  bool operator()(const int& lhs, const int& rhs) const { return lhs < rhs; }
};
int mpow(int base, int exp) {
  base %= mod;
  int result = 1;
  while (exp > 0) {
    if (exp & 1) result = ((long long)result * base) % mod;
    base = ((long long)base * base) % mod;
    exp >>= 1;
  }
  return result;
}
bool isPrime(int n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 == 0 || n % 3 == 0) return false;
  for (int i = 5; i * i <= n; i = i + 6)
    if (n % i == 0 || n % (i + 2) == 0) return false;
  return true;
}
void solve() {
  long long n, k, time;
  bool l1, l2;
  cin >> n >> k;
  vector<int> a1, a2, a3;
  for (int i = 0; i < n; i++) {
    cin >> time;
    cin >> l1 >> l2;
    if (l1 & l2) {
      a1.push_back(time);
    } else if (l1) {
      a2.push_back(time);
    } else if (l2) {
      a3.push_back(time);
    }
  }
  if (a1.size() + a2.size() < k || a1.size() + a3.size() < k) {
    cout << -1;
    return;
  }
  sort(a1.begin(), a1.end());
  sort(a2.begin(), a2.end());
  sort(a3.begin(), a3.end());
  int p1 = 0, p2 = 0, p3 = 0;
  int cnt = 0, res = 0;
  int s1 = a1.size(), s2 = a2.size(), s3 = a3.size();
  while (cnt < k && p1 < s1 && p2 < s2 && p3 < s3) {
    if (a1[p1] < a2[p2] + a3[p3]) {
      res += a1[p1];
      p1++;
    } else {
      res += a2[p2] + a3[p3];
      p2++;
      p3++;
    }
    cnt++;
  }
  while (cnt < k && p1 < s1) {
    res += a1[p1];
    p1++;
    cnt++;
  }
  while (cnt < k && p2 < s2 && p3 < s3) {
    res += a2[p2] + a3[p3];
    p2++;
    p3++;
    cnt++;
  }
  cout << res;
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int t = 1;
  solve();
  cout << "\n";
  return 0;
}
