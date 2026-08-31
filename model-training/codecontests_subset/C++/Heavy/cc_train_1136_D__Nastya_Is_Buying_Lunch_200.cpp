#include <bits/stdc++.h>
using namespace std;
long long nMod = 1e9 + 7;
inline long long GCD(long long a, long long b) {
  while (b != 0) {
    long long c = a % b;
    a = b;
    b = c;
  }
  return a;
};
inline long long LCM(long long a, long long b) { return (a / GCD(a, b)) * b; };
int n, m;
vector<set<int> > back(300005), forw(300005);
vector<int> arr(300005);
int res = 0;
bool canMove(int pos) {
  int dstPos = n - 1 - res;
  for (int i = pos + 1; i <= dstPos; i++) {
    if (*back[arr[pos]].lower_bound(arr[i]) == arr[i]) {
    } else {
      return false;
    }
  }
  for (int i = pos; i < dstPos; i++) {
    arr[pos] = arr[pos + 1];
  }
  return true;
}
void vietnakid() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) cin >> arr[i];
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    forw[v].insert(u);
    back[u].insert(v);
  }
  for (int i = n - 2; i >= 0; i--) {
    if (back[arr[i]].count(arr[n - 1])) {
      int j = i;
      while (j < n - 2 && back[arr[j]].count(arr[j + 1])) {
        swap(arr[j], arr[j + 1]);
        j++;
      }
    }
  }
  int i = n - 1;
  while (i > 0 && forw[arr[i]].count(arr[i - 1])) {
    res++;
    swap(arr[i], arr[i - 1]);
    i--;
  }
  cout << res << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie();
  vietnakid();
  cerr << "\nTime elapsed: " << 1000 * clock() / CLOCKS_PER_SEC << "ms\n";
  return 0;
}
