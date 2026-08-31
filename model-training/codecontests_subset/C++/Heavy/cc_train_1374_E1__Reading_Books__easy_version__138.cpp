#include <bits/stdc++.h>
using namespace std;
int month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
string lowerCase = "abcdefghijklmnopqrstuvwxyz";
string upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
const int fx8[] = {+1, +1, +0, -1, -1, -1, +0, +1};
const int fy8[] = {+0, +1, +1, +1, +0, -1, -1, -1};
const int fx4[] = {+1, 0, -1, 0};
const int fy4[] = {0, +1, 0, -1};
int tc, t, a, b, c, m, n, k, cnt, cnt2;
vector<int> oo, zo, oz, v;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  tc = 1;
  while (tc--) {
    cin >> n >> k;
    for (int i = 1; i <= n; i++) {
      cin >> t >> a >> b;
      if (a && b)
        oo.push_back(t), v.push_back(t);
      else if (a)
        oz.push_back(t);
      else if (b)
        zo.push_back(t);
    }
    int x = min(oz.size(), zo.size());
    if (x + oo.size() < k) {
      cout << -1 << '\n';
      continue;
    }
    sort(oo.begin(), oo.end());
    sort(oz.begin(), oz.end());
    sort(zo.begin(), zo.end());
    for (int i = 0; i < x; i++) {
      v.push_back(oz[i] + zo[i]);
    }
    sort(v.begin(), v.end());
    long long sum = 0;
    for (int i = 0; i < k; i++) {
      sum += v[i];
    }
    cout << sum << '\n';
  }
  return 0;
}
