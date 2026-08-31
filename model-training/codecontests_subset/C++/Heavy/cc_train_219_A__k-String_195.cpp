#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
void solve() {}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(0);
  int k;
  cin >> k;
  string A;
  cin >> A;
  int arr[26] = {0}, n = A.size();
  for (int i = 0; i < n; ++i) {
    ++arr[A[i] - 'a'];
  }
  for (int i = 0; i < 26; ++i) {
    if (arr[i] % k) {
      cout << -1 << "\n";
      return 0;
    }
  }
  string S = "";
  int rem = 0;
  for (int i = 0; i < 26; ++i) {
    rem = arr[i] / k;
    for (int j = 0; j < rem; ++j) {
      S += (char('a' + i));
    }
  }
  for (int i = 0; i < k; ++i) {
    cout << S;
  }
  cout << "\n";
  return 0;
}
