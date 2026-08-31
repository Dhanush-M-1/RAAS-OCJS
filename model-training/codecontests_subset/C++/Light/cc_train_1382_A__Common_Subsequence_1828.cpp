#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, n, m;
  cin >> t;
  for (int z = 1; z <= t; z++) {
    cin >> n;
    cin >> m;
    int arr[n];
    int brr[m];
    int flag = 0;
    int pos = -1;
    set<int> s;
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
      s.insert(arr[i]);
    }
    for (int i = 0; i < m; i++) {
      cin >> brr[i];
      if (s.find(brr[i]) != s.end()) {
        flag = 1;
        pos = i;
      }
    }
    if (pos == -1)
      cout << "NO" << endl;
    else {
      cout << "YES" << endl;
      cout << 1 << " ";
      cout << brr[pos] << endl;
    }
  }
  return 0;
}
