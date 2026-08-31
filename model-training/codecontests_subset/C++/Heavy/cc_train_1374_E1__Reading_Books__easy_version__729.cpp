#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("O3")
const long long MOD = 1e9 + 7;
long long n_bits(long long n) {
  long long x = __builtin_popcount(n);
  return x;
}
int pow(int a, int b, int m) {
  int ans = 1;
  while (b) {
    if (b & 1) ans = (ans * a) % m;
    b /= 2;
    a = (a * a) % m;
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  while (t--) {
    int n, k, x, y, z;
    cin >> n >> k;
    vector<int> A;
    vector<int> B;
    vector<int> C;
    for (long long i = 0; i < (n); ++i) {
      cin >> x >> y >> z;
      if (y == z && y == 1) {
        C.push_back(x);
      } else if (y == 1 && z == 0) {
        A.push_back(x);
      } else if (z == 1 && y == 0) {
        B.push_back(x);
      }
    }
    if (A.size() + C.size() < k || B.size() + C.size() < k) {
      cout << -1;
      return 0;
    }
    vector<int> t1;
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    int mini = min(A.size(), B.size());
    int j = 0, ans = 0, total = 0;
    for (int i = 0; i < mini; i++) {
      t1.push_back(A[i] + B[i]);
    }
    sort(C.begin(), C.end());
    for (int i = 0; i < C.size(); i++) {
      t1.push_back(C[i]);
    }
    total = 0;
    sort(t1.begin(), t1.end());
    for (int i = 0; i < k; i++) {
      total += t1[i];
    }
    cout << total;
  }
  return 0;
}
