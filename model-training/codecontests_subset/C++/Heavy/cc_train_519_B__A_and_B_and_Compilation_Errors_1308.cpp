#include <bits/stdc++.h>
using namespace std;
const long double pi = acos(-1);
int CNT_ = 0;
const int mod = 1e9 + 7;
const int maxn = 2e5 + 100;
string current[maxn], initial[maxn];
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  unordered_map<int, int> f1, f2;
  int n;
  cin >> n;
  for (int i = 0, x; i < n; ++i) {
    cin >> x;
    f1[x]++;
  }
  n--;
  for (int i = 0, x; i < n; ++i) {
    cin >> x;
    f2[x]++;
    if (--f1[x] == 0) f1.erase(x);
  }
  cout << f1.begin()->first << '\n';
  n--;
  for (int i = 0, x; i < n; ++i) {
    cin >> x;
    if (--f2[x] == 0) f2.erase(x);
  }
  cout << f2.begin()->first << '\n';
  return 0;
}
