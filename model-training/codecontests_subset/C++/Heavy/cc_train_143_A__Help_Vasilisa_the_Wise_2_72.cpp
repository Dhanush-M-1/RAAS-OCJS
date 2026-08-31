#include <bits/stdc++.h>
using namespace std;
const int maxn = (int)(1e5) + 123;
const long long inf = (long long)(1e18);
const int INF = (int)(1e9);
int r1, r2, d1, d2, c1, c2;
int main() {
  ios_base::sync_with_stdio(false);
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (int i = 1; i <= 9; ++i)
    for (int j = 1; j <= 9; ++j)
      for (int k = 1; k <= 9; ++k)
        for (int t = 1; t <= 9; ++t)
          if (i != j && j != k && i != k && k != t && j != t && i != t)
            if (i + k == c1 && j + t == c2 && i + j == r1 && k + t == r2 &&
                i + t == d1 && j + k == d2) {
              cout << i << " " << j << "\n" << k << " " << t;
              return 0;
            }
  cout << "-1";
  return 0;
}
