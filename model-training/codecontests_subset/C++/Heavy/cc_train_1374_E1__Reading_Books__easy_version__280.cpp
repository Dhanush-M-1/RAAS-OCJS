#include <bits/stdc++.h>
using namespace std;
const int MAX_INT = numeric_limits<int>::max();
const int MAX_UINT = numeric_limits<unsigned int>::max();
void get_acum(const vector<int>& v, vector<int>& acum) {
  int sum = 0;
  for (unsigned int i = 0; i < v.size(); ++i) {
    acum.push_back(sum);
    sum += v[i];
  }
  acum.push_back(sum);
}
int solve(vector<int>& A, vector<int>& B, vector<int>& X, unsigned int k) {
  if (A.size() + X.size() < k || B.size() + X.size() < k) {
    return -1;
  } else {
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    sort(X.begin(), X.end());
    vector<int> A_acum, B_acum, X_acum;
    get_acum(A, A_acum);
    get_acum(B, B_acum);
    get_acum(X, X_acum);
    int res = MAX_INT;
    unsigned int max_i = min((unsigned int)X.size(), k);
    for (unsigned int i = 0; i < max_i + 1; ++i) {
      if (k - i < A_acum.size() && k - i < B_acum.size()) {
        int total = A_acum[k - i] + B_acum[k - i] + X_acum[i];
        if (total < res) res = total;
      }
    }
    return res;
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  unsigned int n, k;
  cin >> n >> k;
  vector<int> A;
  vector<int> B;
  vector<int> X;
  for (unsigned int i = 0; i < n; ++i) {
    unsigned int ti;
    bool ai, bi;
    cin >> ti >> ai >> bi;
    if (ai && bi)
      X.push_back(ti);
    else if (ai)
      A.push_back(ti);
    else if (bi)
      B.push_back(ti);
  }
  cout << solve(A, B, X, k);
  return 0;
}
