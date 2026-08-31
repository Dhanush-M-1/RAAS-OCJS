#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  vector<int> A(m);
  while (n--) {
    int x;
    cin >> x;
    while (x--) {
      int a;
      cin >> a;
      --a;
      A[a] = 1;
    }
  }
  cout << (count(A.begin(), A.end(), 1) == m ? "YES" : "NO") << '\n';
}
