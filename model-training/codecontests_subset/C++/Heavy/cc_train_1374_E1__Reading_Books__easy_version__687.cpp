#include <bits/stdc++.h>
using namespace std;
const int N = 1e5, OO = 0x3f3f3f3f, mod = 1e9 + 7;
int main() {
  cin.tie(0);
  cin.sync_with_stdio(0);
  int n, k;
  cin >> n >> k;
  vector<int> both, A, B;
  for (int i = 0; i < n; i++) {
    int t, a, b;
    cin >> t >> a >> b;
    if (a && b)
      both.push_back(t);
    else if (a)
      A.push_back(t);
    else if (b)
      B.push_back(t);
  }
  sort(both.begin(), both.end());
  sort(A.begin(), A.end());
  sort(B.begin(), B.end());
  if (both.size() + A.size() < k || both.size() + B.size() < k) {
    cout << "-1\n";
    return 0;
  }
  int mi = min(A.size(), B.size());
  for (int i = 0; i < mi; i++) both.push_back(A[i] + B[i]);
  sort(both.begin(), both.end());
  long long ans = 0;
  for (int i = 0; i < k; i++) ans += both[i];
  cout << ans << "\n";
  return 0;
}
