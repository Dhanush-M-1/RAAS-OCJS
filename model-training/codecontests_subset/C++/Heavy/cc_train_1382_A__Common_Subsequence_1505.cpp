#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1e9 + 7;
bool sortbysec(const pair<int, int>& a, const pair<int, int>& b) {
  return (a.second < b.second);
}
long long int modpower(long long int a, long long int b, long long int c) {
  long long int res = 1;
  while (b) {
    if (b & 1LL) res = (res * a) % c;
    a = (a * a) % c;
    b >>= 1;
  }
  return res;
}
long long int gcd(long long int a, long long int b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cout << name << " : " << arg1 << '\n';
}
using namespace std;
const int INF = 987654321;
const int MOD = 1000000007;
const int N = 1e5 + 5;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int a[N], b[N];
    for (int i = 1; i <= 1000; i++) {
      a[i] = 0;
    }
    for (int i = 0; i < n; i++) {
      int x;
      cin >> x;
      a[x]++;
    }
    int j = -1;
    for (int i = 0; i < m; i++) {
      cin >> b[i];
      if (a[b[i]]) {
        j = b[i];
      }
    }
    if (j > 0)
      cout << "YES" << '\n' << "1 " << j << '\n';
    else
      cout << "NO" << '\n';
  }
  return 0;
}
