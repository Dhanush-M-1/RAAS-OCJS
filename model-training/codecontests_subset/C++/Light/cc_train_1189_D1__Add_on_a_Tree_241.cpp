#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a, b;
  vector<vector<int>> A(n);
  for (int i = 0; i < (n - 1); i++) {
    cin >> a >> b;
    A[a - 1].push_back(b - 1);
    A[b - 1].push_back(a - 1);
  }
  if (n <= 2) {
    cout << "YES" << endl;
    return 0;
  }
  bool flag = false;
  for (int i = 0; i < A.size(); i++) {
    if (A[i].size() != 1 && A[i].size() < 3) {
      flag = true;
    }
  }
  if (flag == false) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
}
