#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1e9 + 7;
const long long int N = 2e5 + 9;
long long int primes[6] = {1125899906842597, 1495921043, 1005985879,
                           1495921043,       1005985879, 1495921043};
vector<long long int> adj[N];
long long int parent[N];
long long int vis[N];
long long int level[N];
long long int dist[N];
long long int dp[N];
long long int hashing[N];
long long int ar[509][509];
long long int br[509][509];
long long int cr[509][509];
long long int multiply(long long int a, long long int b) {
  return ((a % mod) * (b % mod)) % mod;
}
long long int add(long long int a, long long int b) {
  return ((a % mod) + (b % mod)) % mod;
}
long long int sub(long long int a, long long int b) {
  return ((a % mod) - (b % mod) + mod) % mod;
}
long long int dx[] = {1, -1, 0, 0};
long long int dy[] = {0, 0, 1, -1};
long long int arr[200009];
long long int brr[200009];
long long int tim[200009];
long long int n, k;
int main() {
  int start_s = clock();
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int i, j, m, q, t, a, d, b, c, l, r, e, idx, ind, index, u, v, x, y,
      z, h, sz, sz1, sz2, mid, len, tot, prev, temp, curr, p;
  long long int res = 0, res1 = 0, res2 = 0, ans = 0, ans1 = 0, ans2 = 0,
                val = 0, val1 = 0, val2 = 0, rem = 0, diff = 0, cnt = 0,
                flag = 0, fl = 0, sum = 0, maxi = INT_MIN, mini = INT_MAX,
                total = 0;
  string str, str1, str2;
  char ch, ch1, ch2;
  cin >> n >> k;
  for (i = 1; i <= n; i++) {
    cin >> tim[i] >> arr[i] >> brr[i];
  }
  priority_queue<long long int, vector<long long int>, greater<long long int> >
      common, lef, rig;
  for (i = 1; i <= n; i++) {
    if (arr[i] == 1 && brr[i] == 1) {
      common.push(tim[i]);
    } else if (arr[i] == 1 && brr[i] == 0) {
      lef.push(tim[i]);
    } else if (arr[i] == 0 && brr[i] == 1) {
      rig.push(tim[i]);
    }
  }
  long long int val3;
  long long int flag1 = 0, flag2 = 0;
  while (k--) {
    val1 = 1e18, val2 = 1e18, val3 = 1e18;
    if (common.size() == 0) {
      flag1 = 1;
    }
    if (common.size() != 0) val1 = common.top();
    if (lef.size() == 0 || rig.size() == 0) {
      flag2 = 1;
    }
    if (lef.size() != 0) val2 = lef.top();
    if (rig.size() != 0) val3 = rig.top();
    if (flag1 == 1 && flag2 == 1) {
      return cout << -1, 0;
    }
    if (val1 <= val2 + val3) {
      ans += val1;
      common.pop();
    } else {
      ans += val2 + val3;
      lef.pop();
      rig.pop();
    }
  }
  cout << ans;
}
