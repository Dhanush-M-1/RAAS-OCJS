#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  string x;
  cin >> x;
  int d = 0;
  for (int i = 0; i < t; i++) {
    if (x[i] == '8') {
      d++;
    }
  }
  if (t / 11 < d) {
    cout << x.size() / 11;
  } else {
    cout << d;
  }
}
