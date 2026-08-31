#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  int n, k;
  cin >> n >> k;
  vector<int> d;
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    d.push_back(temp);
  }
  sort(d.begin(), d.end());
  for (int i = d.size() - 1; i >= 0; i--) {
    if (k % d[i] == 0) {
      cout << (int)(k / d[i]) << endl;
      return 0;
    }
  }
  return 0;
}
