#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t;
  cin >> t;
  while (t--) {
    long long int n, m;
    cin >> n >> m;
    long long int A[n], B[m];
    for (long long int i = 0; i < n; i++) {
      cin >> A[i];
    }
    for (long long int i = 0; i < m; i++) {
      cin >> B[i];
    }
    long long int flag = 0, num = 0, temp = 0;
    unordered_map<long long int, long long int> mp;
    for (int i = 0; i < n; i++) mp[A[i]]++;
    for (auto x : mp) {
      for (long long int i = 0; i < m; i++) {
        if (B[i] == x.first) {
          num = x.first;
          flag = 1;
          break;
        }
      }
      if (flag == 1) break;
    }
    if (flag == 1) {
      cout << "YES\n1 " << num << "\n";
    } else {
      cout << "NO\n";
    }
  }
  return 0;
}
