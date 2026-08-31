#include <bits/stdc++.h>
using namespace std;
long long n, m, k;
int temp1, t, mini = 1000000007, a[100008];
long long fastpow(long long int a, long long int b) {
  if (b == 0) return 1ll;
  long long ret = fastpow(a, b / 2);
  ret = (ret * ret) % 1000000007;
  ret = (ret + 1000000007) % 1000000007;
  if (b % 2 == 1) ret = (ret * a) % 1000000007;
  ret = (ret + 1000000007) % 1000000007;
  return ret;
}
vector<long long int> vec[100008];
long long int visited[100008];
void dfs(long long int node) {
  visited[node] = 1;
  mini = min(a[node], mini);
  for (int i = 0; i < vec[node].size(); i++) {
    if (!visited[vec[node][i]]) {
      dfs(vec[node][i]);
    }
  }
}
map<int, int> mymap;
int pre[100008], d;
int findmax(int lo, int hi, int offset) {
  int low = lo, high = hi;
  while (low < high) {
    int mid = (high + low) / 2;
    int check = d - mid + offset;
    auto it = mymap.upper_bound(check);
    if (it != mymap.end()) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }
  int temp = d - low + offset;
  auto tt = mymap.upper_bound(temp);
  if (tt != mymap.end()) {
    if (low == 0) return -1;
    return low - 1;
  } else {
    return low;
  }
}
int main() {
  bool flag = 0;
  long long int ans = 0;
  cin >> n >> d;
  for (int i = 1; i <= n; i++) cin >> a[i];
  pre[0] = 0;
  for (int i = 1; i <= n; i++) {
    pre[i] = pre[i - 1] + a[i];
    auto it = mymap.find(pre[i]);
    if (it != mymap.end()) {
      mymap[pre[i]]++;
    } else {
      mymap[pre[i]] = 1;
    }
  }
  int cur = 0;
  for (int i = 1; i <= n; i++) {
    auto it = mymap.find(pre[i]);
    if ((it->second) == 1) {
      mymap.erase(it);
    } else {
      (it->second)--;
    }
    if (a[i]) {
      cur += a[i];
    } else {
      if (cur < 0) {
        int res = findmax(0, d, pre[i]);
        if (res != -1) {
          cur = res;
          ans++;
        } else {
          flag = 1;
          break;
        }
      }
    }
    if (cur > d) {
      flag = 1;
      break;
    }
  }
  if (!flag)
    cout << ans << endl;
  else
    cout << -1 << endl;
  return 0;
}
