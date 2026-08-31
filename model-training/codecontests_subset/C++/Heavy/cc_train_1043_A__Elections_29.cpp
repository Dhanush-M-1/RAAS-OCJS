#include <bits/stdc++.h>
using namespace std;
const int INF = INT_MAX;
const long long INFL = LLONG_MAX;
const long double pi = acos(-1);
int N, A[101];
int main() {
  ios_base::sync_with_stdio(0);
  cout.precision(15);
  cout << fixed;
  cout.tie(0);
  cin.tie(0);
  cin >> N;
  int mx = 0;
  for (int(i) = 1; (i) <= (N); (i)++) {
    cin >> A[i];
    mx = max(mx, A[i]);
  }
  for (int(answer) = 1; (answer) <= (1000); (answer)++)
    if (answer >= mx) {
      int a = 0;
      int b = 0;
      for (int(i) = 1; (i) <= (N); (i)++) {
        a += A[i];
        b += answer - A[i];
      }
      if (a < b) {
        cout << answer << '\n';
        return 0;
      }
    }
}
