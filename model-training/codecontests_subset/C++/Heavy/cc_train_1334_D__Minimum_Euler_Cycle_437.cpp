#include <bits/stdc++.h>
using namespace std;
const int mods = 998244353;
const int maxn = 1e5 + 10;
const int N = 1e5 + 10;
const int E = 2e5 + 10;
long long n, l, r;
long long k[maxn];
vector<int> ans;
int main() {
  int T;
  cin >> T;
  while (T--) {
    cin >> n >> l >> r;
    k[1] = 1;
    for (int i = 2; i <= (n); ++i) {
      k[i] = k[i - 1] + 2 * (n - i + 1);
    }
    long long bo = n;
    for (int i = 1; i <= (n); ++i) {
      if (k[i] > l) {
        bo = i - 1;
        break;
      }
    }
    if (bo >= n) {
      printf("1\n");
      continue;
    }
    long long pc = k[bo];
    long long tot = 1;
    long long tmp;
    ans.clear();
    while (pc <= r) {
      if (bo == n) {
        ans.push_back(1);
        break;
      }
      if (pc % 2 == 1)
        tmp = bo;
      else {
        tmp = bo + tot;
        tot++;
      }
      if (pc >= l) ans.push_back(tmp);
      pc++;
      if (tmp == n) {
        bo++;
        tot = 1;
      }
    }
    for (int i = 0; i <= (ans.size() - 1); ++i) {
      cout << ans[i] << " ";
    }
    cout << endl;
  }
}
