#include <bits/stdc++.h>
using namespace std;
int main()
  {int N; cin >> N;
  string S; map<string, int> m; while (N--) cin >> S, ++m[S];
  for (auto s : {"AC", "WA", "TLE", "RE"}) printf("%s x %d\n", s, m[s]);}