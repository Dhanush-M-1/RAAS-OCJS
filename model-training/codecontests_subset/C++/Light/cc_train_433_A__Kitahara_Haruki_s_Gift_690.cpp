#include <bits/stdc++.h>
using namespace std;
const int INF = (int)(INT_MAX - 100);
const int N = (int)(0);
const long long mod = (int)(1e+9 + 7);
int main() {
  int n, p;
  cin >> n;
  vector<int> C(3);
  for (int it1 = 0; it1 < n; it1++) {
    scanf("%d", &p);
    C[p / 100]++;
  }
  if (C[1] & 1) return puts("NO"), 0;
  if (C[1] == 0 && (C[2] & 1))
    puts("NO");
  else
    puts("YES");
  return 0;
}
