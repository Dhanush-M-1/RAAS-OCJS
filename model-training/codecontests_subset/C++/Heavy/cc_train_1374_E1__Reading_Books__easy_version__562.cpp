#include <bits/stdc++.h>
using namespace std;
const long long INF = 2000000000000;
const long long MOD = 998244353;
const int N = 100009;
int main() {
  int n, k;
  cin >> n >> k;
  vector<long long> A, B, both;
  for (int i = 0; i < int(n); i++) {
    long long t, a, b;
    cin >> t >> a >> b;
    if (a == 1 && b == 1)
      both.push_back(t);
    else if (a == 1)
      A.push_back(t);
    else if (b == 1)
      B.push_back(t);
  }
  sort(A.begin(), A.end());
  sort(B.begin(), B.end());
  for (int i = 0; i < int(min(A.size(), B.size())); i++) {
    both.push_back(A[i] + B[i]);
  }
  sort(both.begin(), both.end());
  long long tot = 0;
  if (int(both.size()) < k) {
    cout << -1 << "\n";
    return 0;
  }
  for (int i = 0; i < int(k); i++) {
    tot += both[i];
  }
  cout << tot << "\n";
}
