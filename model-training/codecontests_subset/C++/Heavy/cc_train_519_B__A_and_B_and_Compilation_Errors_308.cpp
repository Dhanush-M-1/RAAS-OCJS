#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, i, j, k;
  vector<long long int> a1, a2, a3;
  cin >> n;
  for (i = 0; i < n; i++) {
    int x;
    cin >> x;
    a1.push_back(x);
  }
  sort(a1.begin(), a1.end());
  for (i = 0; i < n - 1; i++) {
    int x;
    cin >> x;
    a2.push_back(x);
  }
  sort(a2.begin(), a2.end());
  for (i = 0; i < n - 2; i++) {
    int x;
    cin >> x;
    a3.push_back(x);
  }
  sort(a3.begin(), a3.end());
  for (i = 0; i < n - 1; i++) {
    for (j = i; j < n; j++) {
      if (a2[i] == a1[j] && a1[j] != 0) {
        a1[j] = 0;
        break;
      }
    }
  }
  for (i = 0; i < n; i++) {
    if (a1[i] != 0) cout << a1[i] << endl;
  }
  for (i = 0; i < n - 2; i++) {
    for (j = i; j < n - 1; j++) {
      if (a3[i] == a2[j] && a2[j] != 0) {
        a2[j] = 0;
        break;
      }
    }
  }
  for (i = 0; i < n - 1; i++) {
    if (a2[i] != 0) cout << a2[i] << endl;
  }
  return 0;
}
