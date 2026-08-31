#include <bits/stdc++.h>
using namespace std;
template <typename T>
T sqr(T x) {
  return x * x;
}
template <typename T>
T gcd(T a, T b) {
  return b ? gcd(b, a % b) : a;
}
const int MAXN = (int)1e6 + 10;
string s;
int n, sum, m;
int flag = 1;
bool mi;
vector<int> a;
int ans[MAXN];
int main() {
  ios_base ::sync_with_stdio(false);
  s = "";
  while (s != "=") {
    cin >> s;
    if (s == "+") flag = 1;
    if (s == "-") flag = -1;
    if (s == "?") a.push_back(flag);
  }
  for (int i = 0; i < a.size(); i++) {
    sum += a[i];
    if (a[i] == -1) mi = true;
  }
  m = a.size();
  cin >> n;
  sum = 0;
  for (int i = 0; i < m; i++) {
    ans[i] = 1;
    sum += ans[i] * a[i];
  }
  for (int i = 0; i < m; i++) {
    if (a[i] == 1)
      while (ans[i] < n && sum < n) ans[i]++, sum++;
    if (a[i] == -1)
      while (ans[i] < n && sum > n) ans[i]++, sum--;
  }
  if (sum != n) {
    cout << "Impossible";
    return 0;
  }
  cout << "Possible"
       << "\n";
  cout << ans[0] << " ";
  for (int i = 1; i < m; i++) {
    if (a[i] == -1)
      cout << "- ";
    else
      cout << "+ ";
    cout << ans[i] << " ";
  }
  cout << "= " << n;
}
