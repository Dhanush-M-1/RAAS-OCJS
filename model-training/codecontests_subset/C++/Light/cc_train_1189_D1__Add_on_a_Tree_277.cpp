#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  unordered_map<int, int> m;
  for (int i = 0; i < n - 1; i++) {
    int a, b;
    cin >> a >> b;
    m[a]++;
    m[b]++;
  }
  for (int i = 1; i <= n; i++) {
    if (m[i] == 2) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
}
