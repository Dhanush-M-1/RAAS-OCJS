#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, t, a, b, sum = 0, cnt = 0;
  vector<int> A, B, C;
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> t >> a >> b;
    if (a != b) {
      if (a == 1) {
        A.push_back(t);
      } else {
        B.push_back(t);
      }
    } else {
      if (a == 1) {
        C.push_back(t);
      }
    }
  }
  sort(A.begin(), A.end());
  sort(B.begin(), B.end());
  sort(C.begin(), C.end());
  if (A.size() + C.size() < k) {
    cout << -1;
    return 0;
  } else if (B.size() + C.size() < k) {
    cout << -1;
    return 0;
  } else {
    int i = 0, j = 0, l = 0;
    while (i < A.size() && j < B.size() && l < C.size() && cnt < k) {
      if (A[i] + B[j] < C[l]) {
        sum += A[i] + B[j];
        i++;
        j++;
        cnt++;
      } else {
        sum += C[l];
        l++;
        cnt++;
      }
    }
    if (cnt < k) {
      if (l == C.size()) {
        l = cnt;
        while (l < k) {
          sum += A[i];
          i++;
          l++;
        }
        l = cnt;
        while (l < k) {
          sum += B[j];
          j++;
          l++;
        }
      } else {
        i = cnt;
        while (i < k) {
          sum += C[l];
          l++;
          i++;
        }
      }
    }
  }
  cout << sum;
  return 0;
}
