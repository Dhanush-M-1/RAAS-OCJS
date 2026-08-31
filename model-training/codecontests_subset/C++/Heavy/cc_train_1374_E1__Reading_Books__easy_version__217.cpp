#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const long long mod2 = 998244353;
const long long INF = 1000000001;
const long long N = 100001;
const long double PI = 3.141593;
long double powm(long long base, long long exp) {
  long long ans = 1;
  while (exp) {
    if (exp & 1) ans = (ans * base) % mod;
    exp >>= 1, base = (base * base) % mod;
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n, k;
  cin >> n >> k;
  priority_queue<long long, vector<long long>, greater<long long>> A, B, C;
  for (long long i = 0; i < n; i++) {
    long long t, a, b;
    cin >> t >> a >> b;
    if (a == 1 && b == 1)
      C.push(t);
    else if (a == 1 && b == 0)
      A.push(t);
    else if (a == 0 && b == 1)
      B.push(t);
  }
  if (A.size() + C.size() < k || B.size() + C.size() < k) {
    cout << "-1" << endl;
    return 0;
  }
  long long a = 0, b = 0, fa = 0;
  while (a < k || b < k) {
    if (A.size() == 0 && a < k) {
      a++;
      b++;
      fa += C.top();
      C.pop();
    } else if (C.size() == 0 && a < k) {
      a++;
      fa += A.top();
      A.pop();
    } else if (B.size() == 0 && b < k) {
      a++;
      b++;
      fa += C.top();
      C.pop();
    } else if (C.size() == 0 && b < k) {
      b++;
      fa += B.top();
      B.pop();
    } else if (A.top() + B.top() > C.top()) {
      a++;
      b++;
      fa += C.top();
      C.pop();
    } else {
      a++;
      b++;
      fa += A.top();
      fa += B.top();
      A.pop();
      B.pop();
    }
  }
  cout << fa << endl;
}
