#include <bits/stdc++.h>
using namespace std;
int n, k;
struct pairab {
  int a, b, idx;
};
bool compare(pairab i1, pairab i2) {
  return (i1.b == i2.b) ? (i1.a < i2.a) : (i1.b < i2.b);
}
pairab in[80];
int inf = (int)1e9;
int memo[80][80];
int dp(int i, int takenInFirstK) {
  if (takenInFirstK > k) return -inf;
  if (i >= n) return (takenInFirstK == k) ? 0 : -inf;
  if (memo[i][takenInFirstK] + 1) return memo[i][takenInFirstK];
  int take = dp(i + 1, takenInFirstK + 1) + in[i].a + (in[i].b * takenInFirstK);
  int takeAndDelete = dp(i + 1, takenInFirstK) + (in[i].b * (k - 1));
  return memo[i][takenInFirstK] = max(take, takeAndDelete);
}
int chooseLast;
list<int> print, takeAndDel;
void trace(int i, int takenInFirstK) {
  if (takenInFirstK > k) return;
  if (i >= n) return;
  int ans = dp(i, takenInFirstK);
  int take = dp(i + 1, takenInFirstK + 1) + in[i].a + (in[i].b * takenInFirstK);
  if (ans == take) {
    if (takenInFirstK + 1 == k) {
      chooseLast = in[i].idx;
    } else {
      print.push_back(in[i].idx);
    }
    trace(i + 1, takenInFirstK + 1);
  } else {
    takeAndDel.push_back(in[i].idx);
    trace(i + 1, takenInFirstK);
  }
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  ;
  int tc;
  cin >> tc;
  while (tc--) {
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
      int a, b;
      cin >> a >> b;
      in[i].a = a;
      in[i].b = b;
      in[i].idx = i + 1;
    }
    sort(in, in + n, compare);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= k; j++) {
        memo[i][j] = -1;
      }
    }
    chooseLast = -1;
    trace(0, 0);
    while (takeAndDel.size()) {
      int x = takeAndDel.front();
      takeAndDel.pop_front();
      print.push_back(x);
      print.push_back(-x);
    }
    if (chooseLast + 1) {
      print.push_back(chooseLast);
    }
    cout << print.size() << endl;
    while (print.size()) {
      int x = print.front();
      print.pop_front();
      cout << x << " ";
    }
    cout << endl;
  }
  return 0;
}
