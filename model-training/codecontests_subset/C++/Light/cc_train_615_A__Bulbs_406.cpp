#include <bits/stdc++.h>
using namespace std;
int main() {
  int b, l, k = 0, p, m;
  cin >> b >> l;
  int n[l];
  for (int i = 0; i < l; i++) {
    n[i] = 0;
  }
  for (int i = 0; i < b; i++) {
    cin >> p;
    for (int j = 0; j < p; j++) {
      cin >> m;
      n[m - 1]++;
    }
  }
  for (int i = 0; i < l; i++) {
    if (n[i] == 0) {
      k++;
    }
  }
  if (k > 0) {
    cout << "NO";
  } else {
    cout << "YES";
  }
}
