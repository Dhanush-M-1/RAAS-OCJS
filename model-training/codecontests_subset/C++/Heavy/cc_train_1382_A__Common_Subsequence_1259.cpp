#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    int m;
    cin >> m;
    vector<int> arr1, arr2, result;
    arr1.reserve(n);
    arr2.reserve(m);
    int c;
    for (int i = 0; i < n; i++) {
      cin >> c;
      arr1.push_back(c);
    }
    for (int i = 0; i < m; i++) {
      cin >> c;
      arr2.push_back(c);
    }
    int res = -1;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (arr1[i] == arr2[j]) res = arr1[i];
    if (res == -1)
      cout << "NO\n";
    else {
      cout << "YES\n";
      cout << 1 << " " << res << "\n";
    }
  }
  return 0;
}
