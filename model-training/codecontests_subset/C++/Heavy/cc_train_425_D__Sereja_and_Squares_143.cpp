#include <bits/stdc++.h>
using namespace std;
pair<int, int> s[1 << 20];
vector<int> A[1 << 20];
vector<int> B[1 << 20];
unordered_set<int> S[1 << 20];
int main(void) {
  srand(time(0));
  int n;
  cin >> n;
  for (int i = 1; i <= n; ++i)
    cin >> s[i].first >> s[i].second, A[s[i].first].push_back(s[i].second),
        B[s[i].second].push_back(s[i].first);
  for (int i = 0; i <= 1e5; ++i)
    sort(A[i].begin(), A[i].end()), sort(B[i].begin(), B[i].end());
  for (int i = 1; i <= n; ++i) S[s[i].first].insert(s[i].second);
  long long ans = 0;
  sort(s + 1, s + 1 + n);
  for (int i = 1; i <= n; ++i) {
    int cntx = lower_bound(A[s[i].first].begin(), A[s[i].first].end(),
                           s[i].second + 1) -
               A[s[i].first].begin();
    int cnty = lower_bound(B[s[i].second].begin(), B[s[i].second].end(),
                           s[i].first + 1) -
               B[s[i].second].begin();
    int szA = A[s[i].first].size(), szB = B[s[i].second].size();
    int D = 0;
    if (szA - cntx < szB - cnty) {
      for (int j = cntx; j < szA; ++j)
        D = A[s[i].first][j] - s[i].second,
        ans += S[D + s[i].first].count(s[i].second) &&
               S[D + s[i].first].count(D + s[i].second);
    } else {
      for (int j = cnty; j < szB; ++j)
        D = B[s[i].second][j] - s[i].first,
        ans += S[s[i].first].count(D + s[i].second) &&
               S[D + s[i].first].count(D + s[i].second);
    }
  }
  cout << ans << '\n';
  return 0;
}
