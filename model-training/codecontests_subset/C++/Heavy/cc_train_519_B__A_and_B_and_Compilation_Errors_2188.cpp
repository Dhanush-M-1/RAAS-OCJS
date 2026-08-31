#include <bits/stdc++.h>
using namespace std;
map<int, int> A, B, C;
vector<int> vec;
int main() {
  int n;
  cin >> n;
  int x;
  for (int i = 0; i < n; i++) {
    cin >> x;
    vec.push_back(x);
    if (A.find(x) != A.end()) {
      ++A[x];
    } else
      A[x] = 1;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    if (B.find(x) != B.end()) {
      ++B[x];
    } else
      B[x] = 1;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    if (C.find(x) != C.end()) {
      ++C[x];
    } else
      C[x] = 1;
  }
  int res_1 = -1, res_2 = -1;
  int id;
  for (int i = 0; i < n; i++) {
    id = vec[i];
    if (B.find(id) == B.end() || B[id] < A[id]) {
      res_1 = id;
    }
    if ((C.find(id) == C.end() && B.find(id) != B.end()) || C[id] < B[id]) {
      res_2 = id;
    }
  }
  cout << res_1 << endl;
  cout << res_2 << endl;
  return 0;
}
