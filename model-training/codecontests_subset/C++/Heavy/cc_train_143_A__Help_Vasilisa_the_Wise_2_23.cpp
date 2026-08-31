#include <bits/stdc++.h>
using namespace std;
vector<int> solve(int r1, int r2, int c1, int c2, int d1, int d2) {
  for (int a = 1; a <= 9; ++a)
    for (int b = 1; b <= 9; ++b)
      for (int c = 1; c <= 9; ++c)
        for (int d = 1; d <= 9; ++d) {
          if (a == b or a == c or a == d or b == c or b == d or c == d)
            continue;
          if (a + b == r1 and c + d == r2 and a + c == c1 and b + d == c2 and
              a + d == d1 and b + c == d2)
            return {a, b, c, d};
        }
  return {};
}
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  auto ans = solve(r1, r2, c1, c2, d1, d2);
  if (ans.empty())
    cout << -1 << '\n';
  else {
    cout << ans[0] << ' ' << ans[1] << '\n';
    cout << ans[2] << ' ' << ans[3] << '\n';
  }
  return 0;
}
