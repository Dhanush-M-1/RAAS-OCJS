#include <bits/stdc++.h>
using namespace std;
int n;
void calc(int x) {
  vector<int> v;
  while (x) {
    v.push_back(x % n);
    x /= n;
  }
  for (int i = v.size() - 1; i >= 0; i--) cout << v[i];
  cout << " ";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) calc(i * j);
    cout << endl;
  }
  return -0;
}
