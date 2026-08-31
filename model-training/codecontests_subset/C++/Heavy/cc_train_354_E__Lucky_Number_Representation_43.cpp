#include <bits/stdc++.h>
using namespace std;
const int INF = 1000000000;
const double eps = 1e-10;
const int MOD = 100000007;
const int MAXN = 1000000;
vector<pair<int, int> > v[10];
void init() {
  for (int i = (0); i <= (6); ++i)
    for (int j = (0); j <= (6 - i); ++j) {
      v[(i * 4 + j * 7) % 10].push_back(make_pair(i, j));
    }
}
long long pw[] = {
    1,
    10,
    100,
    1000,
    10000,
    100000,
    1000000,
    10000000,
    100000000,
    1000000000,
    10000000000,
    100000000000,
    1000000000000,
    10000000000000,
    100000000000000,
    1000000000000000,
    10000000000000000,
    100000000000000000,
    1000000000000000000,
};
bool ok;
pair<int, int> p[30];
vector<long long> ans;
void fun(long long n, int index) {
  if (ok || n < 0) return;
  if (n == 0) {
    int n4 = 0, n7 = 0;
    ans.clear();
    for (int i = (index - 1); i >= (0); --i) {
      n4 = p[i].first, n7 = p[i].second;
      int size = ans.size();
      for (int j = 0; j < (size); ++j) {
        if (n4 > 0)
          ans[j] = ans[j] * 10 + 4, n4--;
        else if (n7 > 0)
          ans[j] = ans[j] * 10 + 7, n7--;
        else
          ans[j] *= 10;
      }
      while (n4--) ans.push_back(4);
      while (n7--) ans.push_back(7);
      if (ans.size() > 6) return;
    }
    ok = true;
    return;
  }
  int low = n % 10;
  for (int i = 0; i < (v[low].size()); ++i) {
    pair<int, int> t = v[low][i];
    p[index] = t;
    fun(n / 10 - (t.first * 4 + t.second * 7) / 10, index + 1);
  }
}
int main() {
  init();
  int n;
  scanf("%d", &n);
  while (n--) {
    ok = false;
    long long input;
    cin >> input;
    fun(input, 0);
    if (ok) {
      while (ans.size() < 6) ans.push_back(0);
      cout << ans[0];
      for (int i = (1); i < (6); ++i) cout << " " << ans[i];
      cout << endl;
    } else {
      cout << -1 << endl;
    }
  }
  return 0;
}
