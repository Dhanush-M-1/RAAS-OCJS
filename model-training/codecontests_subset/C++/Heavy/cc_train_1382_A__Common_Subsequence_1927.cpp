#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int t;
  cin >> t;
  while (t--) {
    int a, b;
    int r = 0;
    cin >> a >> b;
    vector<int> A, B;
    vector<int> v(a + b);
    for (int i = 0; i < a; i++) {
      cin >> r;
      A.push_back(r);
    }
    for (int i = 0; i < b; i++) {
      cin >> r;
      B.push_back(r);
    }
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    auto it =
        set_intersection(A.begin(), A.end(), B.begin(), B.end(), v.begin());
    bool printed = false;
    if (it != B.end()) {
      for (auto itr = v.begin(); itr != it; ++itr) {
        cout << "YES\n"
             << "1 " << *itr << "\n";
        printed = true;
        break;
      }
    }
    if (printed == false) {
      cout << "NO"
           << "\n";
    }
  }
  return 0;
}
