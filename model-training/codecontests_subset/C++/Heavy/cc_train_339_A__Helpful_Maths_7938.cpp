#include <bits/stdc++.h>
using namespace std;
const long long INF64 = 3e18;
const int mod = (int)1e9 + 7;
long long binp(long long a, long long b) {
  if (b == 0) return 1;
  long long ans = binp(a, b / 2);
  long long tmp = (ans * ans);
  if (b % 2) return ((tmp * a));
  return ((tmp));
}
void display(vector<long long> v) {
  for (auto x : v) cout << x << " ";
  cout << "\n";
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  string sum;
  cin >> sum;
  long long n = sum.size();
  vector<long long> v;
  for (long long i = 0; i < n; i++) {
    if (sum[i] == '1' || sum[i] == '2' || sum[i] == '3')
      v.push_back(sum[i] - '0');
  }
  long long m = v.size();
  sort(v.begin(), v.end());
  for (long long j = 0; j < m - 1; j++) cout << v[j] << "+";
  cout << v[m - 1] << '\n';
}
