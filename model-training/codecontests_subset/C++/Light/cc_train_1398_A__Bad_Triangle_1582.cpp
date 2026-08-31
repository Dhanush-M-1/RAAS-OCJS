#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long int n, i, j;
    cin >> n;
    vector<long long int> v;
    long long int h;
    for (i = 0; i < n; i++) {
      cin >> h;
      v.push_back(h);
    }
    long long int a, b, c;
    a = v[0];
    b = v[1];
    long long int u = 2;
    for (i = 2; i < n; i++) {
      if ((a + b) <= v[i]) {
        c = i;
        break;
      } else
        u++;
    }
    if (u == n)
      cout << "-1\n";
    else
      cout << 1 << " " << 2 << " " << c + 1 << "\n";
  }
}
