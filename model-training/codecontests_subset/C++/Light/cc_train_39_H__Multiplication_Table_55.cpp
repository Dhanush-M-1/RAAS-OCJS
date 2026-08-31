#include <bits/stdc++.h>
using namespace std;
long n, t;
vector<long> v;
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      t = i * j;
      v.clear();
      while (t) {
        v.push_back(t % n);
        t /= n;
      }
      for (int q = v.size() - 1; q + 1; --q) cout << v[q];
      cout << " ";
    }
    cout << endl;
  }
  cin.get();
  cin.get();
  return 0;
}
