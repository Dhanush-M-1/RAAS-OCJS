#include <bits/stdc++.h>
using namespace std;
int main() {
  int T;
  cin >> T;
  while (T--) {
    int n;
    cin >> n;
    vector<pair<int, int> > A(n);
    for (int i = 0; i < n; i++) {
      cin >> A[i].first;
      A[i].second = i + 1;
    }
    sort(A.begin(), A.end());
    if (A[0].first + A[1].first <= A[n - 1].first) {
      cout << A[0].second << ' ' << A[1].second << ' ' << A[n - 1].second
           << '\n';
    } else {
      cout << "-1\n";
    }
  }
}
