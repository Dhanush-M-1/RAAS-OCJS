#include <bits/stdc++.h>
using namespace std;
long long visit[1005] = {0};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n, m, ans = 0;
  cin >> n >> m;
  long long arr[n + 1];
  long long brr[m + 1];
  vector<int> v[101];
  for (int i = 1; i < n + 1; i++) cin >> arr[i];
  for (int i = 1; i < m + 1; i++) {
    cin >> brr[i];
  }
  for (long long i = 1; i <= m; i++) {
    set<long long> s;
    for (long long j = i - 1; j >= 1 && (brr[j] != brr[i]); j--) {
      if (s.find(brr[j]) == s.end()) {
        ans += arr[brr[j]];
        s.insert(brr[j]);
      }
    }
  }
  cout << ans;
}
