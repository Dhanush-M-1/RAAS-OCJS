#include <bits/stdc++.h>
using namespace std;
const long double pi = 2 * acos(0.0);
struct arr {
  long long index, val;
};
struct query {
  long long n, ind, index, ans;
};
bool compare(arr a1, arr a2) {
  if (a1.val == a2.val) return (a1.index < a2.index);
  return (a1.val > a2.val);
}
bool compare2(arr a1, arr a2) { return (a1.index < a2.index); }
bool compare1(query q1, query q2) { return (q1.n < q2.n); }
bool compare3(query q1, query q2) { return (q1.index < q2.index); }
int main() {
  long long n, i;
  cin >> n;
  arr A[n];
  for (i = 0; i < n; ++i) {
    cin >> A[i].val;
    A[i].index = i + 1;
  }
  sort(A, A + n, compare);
  long long m;
  cin >> m;
  query q[m];
  for (i = 0; i < m; ++i) {
    cin >> q[i].n >> q[i].ind;
    q[i].index = i;
  }
  sort(q, q + m, compare1);
  for (i = 0; i < m; ++i) {
    if (i != 0) {
      if (q[i].n != q[i - 1].n) {
        sort(A, A + q[i - 1].n, compare);
        sort(A, A + q[i].n, compare2);
        q[i].ans = A[q[i].ind - 1].val;
      } else
        q[i].ans = A[q[i].ind - 1].val;
    } else {
      sort(A, A + q[i].n, compare2);
      q[i].ans = A[q[i].ind - 1].val;
    }
  }
  sort(q, q + m, compare3);
  for (i = 0; i < m; ++i) cout << q[i].ans << "\n";
  return 0;
}
