#include <bits/stdc++.h>
using namespace std;
const double PI =
    3.14159265358979323846264338327950288419716939937510582097494459230;
bool comp(int a, int b) { return (a < b); }
int main() {
  int n;
  cin >> n;
  vector<long long> v(n), v1(n - 1), v2(n - 2);
  for (int i = 0; i < n; i++) cin >> v[i];
  for (int i = 0; i < n - 1; i++) cin >> v1[i];
  for (int i = 0; i < n - 2; i++) cin >> v2[i];
  cout << accumulate(v.begin(), v.end(), 0) -
              accumulate(v1.begin(), v1.end(), 0)
       << "\n"
       << accumulate(v1.begin(), v1.end(), 0) -
              accumulate(v2.begin(), v2.end(), 0);
  return 0;
}
