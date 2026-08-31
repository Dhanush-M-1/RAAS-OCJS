#include <bits/stdc++.h>
using namespace std;
static bool comp(long long int a, long long int b) { return (a > b); }
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n, k;
  cin >> n >> k;
  vector<long long int> A, B, BB;
  for (long long int i = 0; i < n; i++) {
    long long int t, a, b;
    cin >> t >> a >> b;
    if (a == 0 and b == 0) continue;
    if (a == 1 and b == 1) {
      BB.push_back(t);
    } else if (a == 1) {
      A.push_back(t);
    } else if (b == 1) {
      B.push_back(t);
    }
  }
  sort(A.begin(), A.end());
  sort(B.begin(), B.end());
  for (long long int i = 0; i < min(A.size(), B.size()); i++)
    BB.push_back(A[i] + B[i]);
  sort(BB.begin(), BB.end());
  if (BB.size() < k)
    cout << "-1\n";
  else {
    long long int s = 0;
    for (long long int i = 0; i < k; i++) s += BB[i];
    cout << s << '\n';
  }
  return 0;
}
