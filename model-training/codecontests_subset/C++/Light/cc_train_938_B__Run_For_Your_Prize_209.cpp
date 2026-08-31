#include <bits/stdc++.h>
using namespace std;
int n;
int v[101010];
int main() {
  cin >> n;
  int lst = 1;
  for (int i = 0; i < n; i++) {
    cin >> v[i];
    int a = v[i] - 1;
    int b = 1e6 - v[i];
    if (a > b) {
      cout << max(lst - 1, (int)1e6 - v[i]) << endl;
      return 0;
    }
    lst = v[i];
  }
  cout << v[n - 1] - 1 << "\n";
  return 0;
}
