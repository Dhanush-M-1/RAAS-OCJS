#include <bits/stdc++.h>
using namespace std;
const long long oo = 0x3f3f3f3f3f3f3f3f;
const double eps = 1e-9;
vector<long long> have, need;
vector<long long> p, k;
vector<vector<long long> > ch;
void fail() {
  cout << "NO" << endl;
  exit(0);
}
long long dfs(long long i) {
  long long total = have[i] - need[i];
  for (long long j : ch[i]) {
    long long cur = dfs(j);
    if (cur < 0) {
      if (abs(cur * 1.0 * k[j]) > 2e17) fail();
      cur *= k[j];
    }
    total += cur;
    if (abs(total) > 2e17) fail();
  }
  return total;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n;
  cin >> n;
  have.resize(n), need.resize(n);
  for (long long i = (0); i < (n); i++) cin >> have[i];
  for (long long i = (0); i < (n); i++) cin >> need[i];
  p.resize(n), k.resize(n);
  ch.resize(n);
  for (long long i = (1); i < (n); i++) {
    cin >> p[i] >> k[i];
    p[i]--;
    ch[p[i]].push_back(i);
  }
  cout << (dfs(0) >= 0 ? "YES" : "NO") << endl;
}
