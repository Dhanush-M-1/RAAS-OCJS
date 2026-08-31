#include <bits/stdc++.h>
using namespace std;
vector<long long> D;
vector<long long> B;
vector<long long> A;
int main() {
  long long a = 0, b = 0;
  long long n, k;
  long long ti, al, bl, time = 0;
  cin >> n >> k;
  for (long long i = 0; i < n; ++i) {
    cin >> ti >> al >> bl;
    if (al + bl == 2)
      D.push_back(ti);
    else if (al == 1)
      A.push_back(ti);
    else if (bl == 1)
      B.push_back(ti);
    a += al;
    b += bl;
  }
  if (a < k || b < k) {
    cout << -1 << endl;
    return 0;
  }
  if (n == k && k == a && k == b) {
    time += accumulate(D.begin(), D.end(), 0);
    time += accumulate(A.begin(), A.end(), 0);
    time += accumulate(B.begin(), B.end(), 0);
    cout << time << endl;
    return 0;
  }
  a = b = k;
  sort(D.begin(), D.end());
  sort(A.begin(), A.end());
  sort(B.begin(), B.end());
  for (long long i = 0, j = 0, l = 0; a > 0 || b > 0;) {
    if (i < D.size() && j < A.size() && l < B.size()) {
      if (D[i] <= A[j] + B[l]) {
        time += D[i];
        ++i;
        --a;
        --b;
      } else {
        time += A[j] + B[l];
        ++j;
        ++l;
        --a;
        --b;
      }
    } else if (i < D.size() && j < A.size() && l >= B.size()) {
      if (a > 0 && b > 0) {
        time += D[i];
        ++i;
        --a;
        --b;
      } else if (a > 0 && b <= 0) {
        if (D[i] < A[j]) {
          time += D[i];
          ++i;
          --a;
          --b;
        } else {
          time += A[j];
          ++j;
          --a;
        }
      }
    } else if (i < D.size() && j >= A.size() && l < B.size()) {
      if (a > 0 && b > 0) {
        time += D[i];
        ++i;
        --a;
        --b;
      } else if (a <= 0 && b > 0) {
        if (D[i] < B[l]) {
          time += D[i];
          ++i;
          --a;
          --b;
        } else {
          time += B[l];
          ++l;
          --b;
        }
      }
    } else if (i >= D.size()) {
      if (a > 0 && j < A.size()) {
        time += A[j];
        ++j;
        --a;
      } else if (b > 0 && l < B.size()) {
        time += B[l];
        ++l;
        --b;
      }
    } else if (i < D.size() && j >= A.size() && l >= B.size()) {
      time += D[i];
      ++i;
      --a;
      --b;
    }
  }
  cout << time << endl;
}
