#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x;
  cin >> n;
  vector<int> e;
  vector<int> e1;
  vector<int> e2;
  for (int i = 0; i < n; i++) {
    cin >> x;
    e.push_back(x);
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    e1.push_back(x);
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    e2.push_back(x);
  }
  sort(e.begin(), e.end());
  sort(e1.begin(), e1.end());
  sort(e2.begin(), e2.end());
  for (int i = 0; i < n; i++) {
    if (e[i] != e1[i]) {
      cout << e[i] << "\n";
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (e1[i] != e2[i]) {
      cout << e1[i] << "\n";
      break;
    }
  }
}
