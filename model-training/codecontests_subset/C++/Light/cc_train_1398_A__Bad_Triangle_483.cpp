#include <bits/stdc++.h>
using namespace std;
using ll = long long;
mt19937 gen(time(0));
void setIO(string name = "") {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
}
int main() {
  setIO();
  int t, n, x;
  cin >> t;
  for (int j = 0; j < t; j++) {
    cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }
    if (a[n - 1] >= a[0] + a[1]) {
      cout << "1 2 " << n << "\n";
    } else {
      cout << "-1\n";
    }
  }
}
