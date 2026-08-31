#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  void solve(std::istream& in, std::ostream& out) {
    map<int, int> a, b, c;
    int n;
    in >> n;
    int m;
    for (int i = 0; i < n; ++i) {
      in >> m;
      a[m]++;
    }
    for (int i = 0; i < n - 1; ++i) {
      in >> m;
      b[m]++;
    }
    for (int i = 0; i < n - 2; ++i) {
      in >> m;
      c[m]++;
    }
    out << minus(a, b) << endl << minus(b, c) << endl;
  }
  int minus(map<int, int>& a, map<int, int>& b) {
    for (auto i : a)
      if (b[i.first] < i.second) return i.first;
    return 0;
  }
};
void solve(std::istream& in, std::ostream& out) {
  out << std::setprecision(12);
  Solution solution;
  solution.solve(in, out);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  istream& in = cin;
  ostream& out = cout;
  solve(in, out);
  return 0;
}
