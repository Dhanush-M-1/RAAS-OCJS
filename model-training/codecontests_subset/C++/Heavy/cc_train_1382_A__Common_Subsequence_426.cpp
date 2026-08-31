#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, m, pos;
    int i;
    int count1 = 0, count2 = 0;
    int arr1[1001], arr2[1001];
    unordered_set<int> s1;
    cin >> n;
    cin >> m;
    for (i = 0; i < n; i++) {
      cin >> arr1[i];
      s1.insert(arr1[i]);
    }
    for (i = 0; i < m; i++) {
      cin >> arr2[i];
      if (s1.find(arr2[i]) != s1.end()) {
        count1++;
        pos = i;
      }
    }
    if (count1 > 0) {
      cout << "YES"
           << "\n";
      cout << 1 << " " << arr2[pos] << "\n";
    } else
      cout << "NO"
           << "\n";
  }
}
