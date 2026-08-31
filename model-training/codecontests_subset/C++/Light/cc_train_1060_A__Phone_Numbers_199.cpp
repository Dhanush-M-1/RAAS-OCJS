#include <bits/stdc++.h>
using namespace std;
int main() {
  clock_t clk_begin = clock();
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  string s;
  cin >> s;
  int c = 0;
  for (int i = 0; i < n; ++i)
    if (s[i] == '8') c++;
  n /= 11;
  cout << min(n, c) << '\n';
  ;
  cerr << "Time taken: " << (double)(clock() - clk_begin) / CLOCKS_PER_SEC
       << '\n';
  return 0;
  ;
}
