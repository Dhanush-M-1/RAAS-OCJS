#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cout << name << " : " << arg1 << '\n';
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cout.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
const long long int N = 100005;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  {
    long long int i, j, k, n, m, ans = 0, cnt = 0, sum = 0;
    cin >> n;
    long long int a[n];
    long long int mx = -1;
    m = -1;
    for (i = 0; i < n; i++) {
      cin >> a[i];
      if (m == -1)
        m = a[i];
      else
        m = (m ^ a[i]);
    }
    k = -1;
    for (i = 0; i < n - 1; i++) {
      cin >> a[i];
      if (k == -1)
        k = a[i];
      else
        k = (k ^ a[i]);
    }
    j = -1;
    for (i = 0; i < n - 2; i++) {
      cin >> a[i];
      if (j == -1)
        j = a[i];
      else
        j = (j ^ a[i]);
    }
    cout << (k ^ m) << endl;
    cout << (k ^ j) << endl;
  }
}
