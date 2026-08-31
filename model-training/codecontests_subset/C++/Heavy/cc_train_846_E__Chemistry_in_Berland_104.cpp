#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
int n;
long long ar[N], br[N];
struct T {
  int dest, type;
  long long cost;
};
vector<T> graf[N];
int cnt[N] = {};
int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> ar[i];
  for (int i = 0; i < n; ++i) cin >> br[i];
  for (int i = 0; i < n; ++i) ar[i] -= br[i];
  for (int i = 1; i < n; ++i) {
    int x, k;
    cin >> x >> k;
    --x;
    graf[i].push_back({x, 0, k});
    graf[x].push_back({i, 1, k});
    ++cnt[i], ++cnt[x];
  }
  stack<int> st;
  for (int i = 1; i < n; ++i)
    if (graf[i].size() == 1) st.push(i);
  while (st.size()) {
    int x = st.top();
    st.pop();
    --cnt[x];
    if (cnt[x] > 1 || !x) continue;
    T y;
    for (auto z : graf[x]) {
      if (cnt[z.dest]) y = z;
    }
    if (ar[x] > 0)
      ar[y.dest] += ar[x] / (y.type ? y.cost : 1);
    else if (ar[x] < 0) {
      if (y.type)
        ar[y.dest] += ar[x];
      else {
        if (double(y.cost) * ar[x] < -1e18) {
          cout << "NO" << endl;
          exit(0);
        }
        ar[y.dest] += ar[x] * y.cost;
      }
    }
    if (ar[y.dest] < -1e18) {
      cout << "NO" << endl;
      exit(0);
    }
    cnt[x] = 0;
    st.push(y.dest);
  }
  if (ar[0] >= 0)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
