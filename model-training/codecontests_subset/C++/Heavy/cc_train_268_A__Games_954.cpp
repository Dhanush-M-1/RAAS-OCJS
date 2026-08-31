#include <bits/stdc++.h>
const long long int MOD = 1e9 + 7;
int dx8[] = {0, 0, 1, 1, 1, -1, -1, -1};
int dy8[] = {1, -1, 1, -1, 0, 0, -1, 1};
int dx4[] = {0, 0, 1, -1};
int dy4[] = {1, -1, 0, 0};
using namespace std;
void vok() {
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);
}
long long int gcd(long long int a, long long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long int lcm(long long int a, long long int b) {
  return ((a * b) / gcd(a, b));
}
vector<long long int> pp;
void gen() {
  vector<bool> prime(33000, true);
  prime[0] = prime[1] = false;
  for (int p = 0; p * p <= 33000; p++) {
    if (prime[p]) {
      for (int i = p * p; i <= 33000; i += p) prime[i] = false;
    }
  }
  for (int i = 0; i < 33000; i++)
    if (prime[i]) pp.push_back(i);
}
long long int find(vector<int>& A, int n) {}
void solve() {
  long long int n, m, x, y, a, b, k;
  a = b = x = y = k = 0;
  long long int ans = 0, res = 0;
  cin >> n;
  string str;
  vector<int> A, B;
  for (int i = 0; i < n; i++) {
    cin >> a;
    cin >> b;
    A.push_back(a);
    B.push_back(b);
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (A[i] == B[j]) x++;
    }
  }
  cout << x << endl;
}
int main() {
  vok();
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
